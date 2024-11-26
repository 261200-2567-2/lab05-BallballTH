class Stats {
    private double hp;
    private final double baseHp;
    private double maxHp;

    private double mana;
    private final double baseMana;
    private double maxMana;

    // min level and speed are 1
    private double speed;
    private final double maxSpeed = 100;

    private int level = 1;
    private final int maxLevel = 100;


    // Overloading Constructor
    public Stats(double _hp, double _mana, double _speed, int _level, boolean applyLevelUp) {
        hp = baseHp = maxHp = _hp;
        mana = baseMana = maxMana = _mana;
        this.speed = _speed;

        if (applyLevelUp) {
            levelUpCalculate(_level - 1);
        } else {
            this.level = _level; // Directly set the level without recalculating
        }
    }

    public Stats(double _hp, double _mana, double _speed, int _level) {
        this(_hp, _mana, _speed, _level, true);
    }

    // for deep copy
    public Stats(Stats other) {
        this(other.maxHp, other.maxMana, other.speed, other.level, false);
    }

    // Hp Methods
    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setHp(double value) {
        this.hp = clampValue(value, maxHp, 0);
    }

    public void modifyHp(double value) {
        this.hp += value;
        this.hp = clampValue(hp, maxHp, 0);
    }

    public void modifyMaxHp(double value) {
        this.maxHp += value;
    }


    // Mana Methods
    public double getMana() {
        return mana;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public void setMana(double value) {
        this.mana = clampValue(value, maxMana, 0);
    }

    public void modifyMana(double value) {
        this.mana += value;
        this.mana = clampValue(mana, maxMana, 0);
    }

    public void modifyMaxMana(double value) {
        this.maxMana += value;
    }


    // Speed Methods
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double value) {
        this.speed = value;
    }

    public void modifySpeed(double value) {
        this.speed += value;
        // this.speed = clampValue(speed, maxSpeed,1 );
    }


    // Level Methods
    public int getLevel() {
        return level;
    }

    public void setLevel(int value) {
        this.level = value;
    }

    public void modifyLevel(int value) {
        this.level += value;
        this.level = clampValue(level, maxLevel, 1);
    }

    public void levelUpCalculate(int value) {

        double addHp = baseHp * value * 0.1;
        double addMana = baseMana * value * 0.1;

        hp += addHp; maxHp += addHp;
        mana += addMana; maxMana += addMana;
        speed += value;
        level += value;
    }


    // Helper Method to Adjust Values if Maxed or Below Zero
    public double clampValue(double current, double max, double min) {
        if(current >= max){
            return max;
        }else if(current <= min){
            return min;
        }
        return current;
    }

    public int clampValue(int current, int max, int min) {
        if(current >= max){
            return max;
        }else if(current <= min){
            return min;
        }
        return current;
    }


    // Display
    public void displayStats() {
        System.out.println("HP    : " + hp + " / " + maxHp);
        System.out.println("Mana  : " + mana + " / " + maxMana);
        System.out.println("Speed : " + speed);
        System.out.println("Level : " + level);
    }
}