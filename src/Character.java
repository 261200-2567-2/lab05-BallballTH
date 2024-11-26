import java.util.Random;   // for isMiss Method

public class Character {
    private String name;
    private Stats stats;
    private Race race;

    private Equipment equipment;
    private double defenseFromEquipment = 0;
    private double modifiedSpeedFromEquipment = 0;

    private Accessory accessory;
    private double[] effectsFromAccessory;

    private CombatAction action;

    public Character(Race _race, String _name) {
        // Deep Copy
        race = _race;
        stats = new Stats(_race.initializeStats());
        name = _name;
        equipment = null;
    }

    // Name Methods
    public String getName() {
        return name;
    }

    // Stats Methods
    public Stats getStats() {
        return stats;
    }

    // Defense Methods
    public double getDefense() {
        return defenseFromEquipment;
    }

    // Equipment Methods
    public Equipment getEquipment() {
        return equipment;
    }

    public void useEquipment(Equipment _equipment) {
        equipment = _equipment;
        _equipment.setOwner(this);
        updateStatsOnEquip(_equipment);
    }

    public void updateStatsOnEquip(Equipment _equipment) {
        defenseFromEquipment += _equipment.getDefense();
        modifiedSpeedFromEquipment += _equipment.getRunSpeed();
        stats.modifySpeed(_equipment.getRunSpeed());
    }

    public void updateStatsOnEquip() {
        defenseFromEquipment = equipment.getDefense();
        double changes = equipment.getRunSpeed() - modifiedSpeedFromEquipment;
        stats.modifySpeed( changes );
        modifiedSpeedFromEquipment = equipment.getRunSpeed();
    }

    public void updateStatsOnUnEquip(Equipment _equipment) {
        defenseFromEquipment -= _equipment.getDefense();
        stats.modifySpeed(-_equipment.getRunSpeed());
    }

    // Accessory Methods
    public void useAccessory(Accessory _accessory) {
        accessory = _accessory;
        effectsFromAccessory = _accessory.getEffect();
        updateEffectsFromAccessory();
    }

    public void updateEffectsFromAccessory() {
        stats.modifyMaxHp(effectsFromAccessory[0]);
        stats.modifyHp(effectsFromAccessory[0]);

        stats.modifyMaxMana(effectsFromAccessory[1]);
        stats.modifyMana(effectsFromAccessory[1]);

        stats.modifySpeed(effectsFromAccessory[2]);
    }

    public double[] getEffectsFromAccessory() {
        return effectsFromAccessory;
    }

    // Action Methods
    public CombatAction getAction() {
        return action;
    }

    public void setAction(CombatAction _action) {
        action = _action;
    }

    // Display
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Race: " + race.getRaceName());
        System.out.println("Equipment: " + (equipment != null ? equipment.getName() : "none"));
        System.out.println("Accessory: " + (accessory != null ? accessory.getName() : "none"));
        System.out.println("Armor : " + defenseFromEquipment);
        stats.displayStats();
    }

    public void attack(CombatAction action, int level, Character other){
        if(isMiss(other)){
            System.out.println(this.name + " Missed!");
            return;
        }
        double damage = calculateDamage(action,level,other);
        other.stats.modifyHp(-damage);
        System.out.println( this.name + " used \"" + action.getName() + "\" to " + other.name + ". it's " + damage + " damage !");
    }

    public double calculateDamage(CombatAction action, int level, Character other){
        double dmg = action.getDamage() * (1 - other.getDefense() / 100);
        double lvlPlus = (level-1) * dmg * 0.1;
        return dmg + lvlPlus;
    }

    // unfinished
    public boolean isMiss( Character defender) {
        // Extract speeds from characters
        double attackerSpeed = this.getStats().getSpeed();
        double defenderSpeed = defender.getStats().getSpeed();

        // Calculate hit chance
        double hitChance = Math.max(0.2, Math.min(1.0, 0.1 + (attackerSpeed / (attackerSpeed + defenderSpeed)) * 0.9));

        // Generate a random roll (0 to 1)
        Random random = new Random();
        double roll = random.nextDouble();

        // Return true if the attack misses
        return roll > hitChance;
    }

}
