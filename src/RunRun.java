

public class RunRun{

    public void start() {
        Character player = createCharacter();
        displayCharacterDetails(player);
        pressEnterKeyToContinue();

        player.useEquipment(chooseEquipment());
        disPlayCharacterEquipmentDetails(player);
        displayCharacterDetails(player);
        pressEnterKeyToContinue();

        System.out.println("Let the journey begin!");

        // Encounter two goblins in sequence
        encounterGoblin(player, createGoblin());
        if(player.getStats().getHp() <= 0) {
            System.out.println("You Died");
            return;
        }
        pressEnterKeyToContinue();

        Accessory accessory = chooseAccessory();
        player.useAccessory(accessory);
        displayCharacterDetails(player);
        pressEnterKeyToContinue();

        clearConsole();
        encounterGoblin(player, createGoblin());
        if(player.getStats().getHp() <= 0) {
            System.out.println("You Died");
            return;
        }
        clearConsole();
    }

    // Equipments Methods
    public Equipment chooseEquipment() {
        Equipment[] equipments = createEquipments();
        int ans = chooseMethod(equipments);

        return equipments[ans - 1];
    }

    public Equipment[] createEquipments() {
        CombatAction slash = new CombatAction("Slash", 15, 0);
        CombatAction tackle = new CombatAction("Tackle", 8, 0);
        CombatAction fireball = new CombatAction("Fireball", 40, 30);
        CombatAction thunderbolt = new CombatAction("Thunderbolt", 25, 20);

        Equipment staff = new Equipment("Staff", 1, 0, -10);
        Equipment magicSword = new Equipment("Magic Sword", 1, 0, -10);
        Equipment shield = new Equipment("Shield", 1, 50, -15);

        magicSword.addCombatAction(slash);
        magicSword.addCombatAction(thunderbolt);
        shield.addCombatAction(tackle);
        staff.addCombatAction(thunderbolt);
        staff.addCombatAction(fireball);

        return new Equipment[] { magicSword, shield, staff };
    }

    // Accessory Methods
    public Accessory chooseAccessory() {
        Accessory[] Accessories = createAccessories();
        int ans = chooseMethod(Accessories);

        return Accessories[ans - 1];
    }

    public Accessory[] createAccessories() {
        return new Accessory[] { new RingOfStrength(), new AmuletOfWisdom(), new CloakOfShadows()};
    }

    // Race Methods
    public Race chooseRaces() {
        Race[] races = createRaces();
        int ans = chooseMethod(races);

        return races[ans - 1];
    }

    public Race[] createRaces() {
        return new Race[] {
                new Human(), new Elf(), new Orc(), new Dwarf(), new Goblin(),
                new Dragonkin(), new Undead(), new Fae(), new Beastfolk(), new Tiefling()
        };
    }

    // Character Methods
    public Character createCharacter() {
        System.out.print("Enter your character's name: ");
        ScannerInput sc = new ScannerInput();
        String name = sc.getLineInput();

        Race race = chooseRaces();
        Character player = new Character(race, name);

        CombatAction punch = new CombatAction("Punch", 10, 0);
        player.setAction(punch);

        return player;
    }

    public void displayCharacterDetails(Character character) {
        printLine();
        character.displayInfo();
    }

    public void disPlayCharacterEquipmentDetails(Character character) {
        printLine();
        character.getEquipment().displayDetails();
    }

    public void displayStatsInCombat(Character character) {
        System.out.println(character.getName() + " Stats:");
        System.out.print("HP: " + character.getStats().getHp());
        System.out.print(" | Mana: " + character.getStats().getMana());
        System.out.println();
    }

    public void playerAttackSystem(Character player, Character enemy) {
        System.out.println("Choose an action:");
        System.out.println("1: " + player.getAction().getName());

        for (int i = 0; i < player.getEquipment().getCurrentActions(); i++) {
            System.out.println((i + 2) + ": " + player.getEquipment().getCombatAction(i).getName());
        }

        ScannerInput sc = new ScannerInput();
        int choice = sc.intInput();

        while (choice <= 0 || choice > player.getEquipment().getCurrentActions() + 1) {
            System.out.print("Invalid choice. Try again: ");
            choice = sc.intInput();
        }

        if (choice == 1) {
            player.attack(player.getAction(), player.getStats().getLevel(), enemy);
        } else {
            player.attack(player.getEquipment().getCombatAction(choice - 2), player.getEquipment().getLevel(), enemy);
        }
    }

    public void levelUp(Character player) {
        if(player.getEquipment() != null)player.getEquipment().levelUpCalculate(1);
        player.getStats().levelUpCalculate(2);
        System.out.println("Congratulations! You leveled up!");
        displayCharacterDetails(player);
        disPlayCharacterEquipmentDetails(player);
    }

    // Goblin
    public Character createGoblin() {
        RaceFactory factory = new RaceFactory();
        Character goblin = new Character(factory.getGoblin(), "Goblin");

        Equipment knife = new Equipment("Knife", 1, 0, -5);
        CombatAction stab = new CombatAction("Stab", 10, 0);

        knife.addCombatAction(stab);

        goblin.useEquipment(knife);

        return goblin;
    }

    public void encounterGoblin(Character player, Character goblin) {
        printLine();
        System.out.println("You encounter a " + goblin.getName() + "!");
        printLine();

        while (goblin.getStats().getHp() > 0) {
            displayStatsInCombat(player);

            displayStatsInCombat(goblin);
            printLine();

            playerAttackSystem(player, goblin);

            if (goblin.getStats().getHp() <= 0) {
                break;
            }

            goblin.attack(goblin.getEquipment().getCombatAction(0), goblin.getEquipment().getLevel(), player);
            printLine();

            if(player.getStats().getHp() <= 0) {
                return;
            }
        }

        System.out.println("The goblin has been defeated!");
        levelUp(player);
    }

    // Choose Overloading
    public int chooseMethod(Equipment[] equipments) {
        printLine();

        System.out.println("Choose your equipment:");
        for (int i = 0; i < equipments.length; i++) {
            System.out.println((i + 1) + ": " + equipments[i].getName());
        }

        ScannerInput sc = new ScannerInput();
        int choice = sc.intInput();

        while (choice <= 0 || choice > equipments.length) {
            System.out.print("Invalid choice. Try again: ");
            choice = sc.intInput();
        }
        return choice;
    }

    public int chooseMethod(Race[] races) {
        printLine();

        System.out.println("Choose your Race:");
        for (int i = 0; i < races.length; i++) {
            System.out.println((i + 1) + ": " + races[i].getRaceName());
        }

        ScannerInput sc = new ScannerInput();
        int choice = sc.intInput();

        while (choice <= 0 || choice > races.length) {
            System.out.print("Invalid choice. Try again: ");
            choice = sc.intInput();
        }
        return choice;
    }

    public int chooseMethod(Accessory[] Accessories) {
        printLine();

        System.out.println("Choose your Accessory:");
        for (int i = 0; i < Accessories.length; i++) {
            System.out.println((i + 1) + ": " + Accessories[i].getName());
        }

        ScannerInput sc = new ScannerInput();
        int choice = sc.intInput();

        while (choice <= 0 || choice > Accessories.length) {
            System.out.print("Invalid choice. Try again: ");
            choice = sc.intInput();
        }
        return choice;
    }

    // Console,Etc.
    public void printLine() {
        System.out.println("=========================================");
    }

    public void pressEnterKeyToContinue() {
        System.out.println("Press \"Enter\" key to continue...");
        ScannerInput sc = new ScannerInput();
        sc.getLineInput(); // Waits for the user to press Enter
    }

    public void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

}
