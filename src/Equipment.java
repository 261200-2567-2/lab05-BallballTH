import java.util.Arrays;

public class Equipment {
    private String name;
    private Character owner;

    private CombatAction[] combatActions;
    private int currentActions = 0;
    private final int maxActions = 5;


    private double defense;
    private double baseDefense;
    private double runSpeed;
    private double baseRunSpeed;

    private int level;

    public Equipment(String _name, int _level, int _defense, int _runSpeed) {
        this.name = _name;
        combatActions = new CombatAction[maxActions];

        baseDefense = defense = _defense;
        baseRunSpeed = runSpeed = _runSpeed;
        this.level = _level;

        levelUpCalculate(_level-1);
    }

    // Name Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Owner Methods
    public Character getOwner() {
        return owner;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }

    public void updateStatsOwner(){
        if(owner != null){
            owner.updateStatsOnEquip();
        }
    }

    // CombatActions Methods
    public CombatAction[] getCombatActions() {
        return combatActions;
    }

    public CombatAction getCombatAction(int i) {
        return combatActions[i];
    }

    public int getCurrentActions() {
        return currentActions;
    }

    public void addCombatAction(CombatAction _combatAction) {
        if(currentActions == maxActions){
            System.out.println("Max actions reached");
        }else if (combatActions != null) {
            // Deep copy
            combatActions[currentActions] = new CombatAction(_combatAction.getName(),_combatAction.getDamage(),_combatAction.getManaCost());
            currentActions++;
        }

    }

    // Defense Methods
    public double getDefense() {
        return defense;
    }

    public void setDefense(double _defense) {
        this.defense = _defense;
    }

    // Level Methods
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUpCalculate(int value) {
        defense += baseDefense * value * 0.2;
        runSpeed += Math.abs(baseRunSpeed * value * 0.1);
        this.level += value;

        updateStatsOwner();
    }

    // Speed Methods
    public double getRunSpeed() {
        return runSpeed;
    }

    public double getBaseRunSpeed() {
        return baseRunSpeed;
    }

    public void setRunSpeed(int runSpeed) {
        this.runSpeed = runSpeed;
    }

    // Display
    public void displayDetails() {
        System.out.println("Name : " + name);
        for (int i = 0; i < currentActions; i++) {
            System.out.println("Combat Action : " + combatActions[i].getName());
        }
        if(defense != 0) System.out.println("Defense:  " + defense);
        System.out.println("Level : " + level);
        System.out.println("Weight : " + (-runSpeed));

    }

    public static Equipment[] equipments;

}
