public class CombatAction {
    private String name;
    private double damage;
    private double manaCost;

    public CombatAction(String _name, double _damage, double _manaCost) {
        this.name = _name;
        this.damage = _damage;
        this.manaCost = _manaCost;
    }

    // Name Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Damage Methods
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    // Mana Methods
    public double getManaCost() {
        return manaCost;
    }

    public void setManaCost(double manaCost) {
        this.manaCost = manaCost;
    }

    // Display
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        System.out.println("Mana Cost: " + manaCost);
    }

    public static CombatAction[] allActions;


}
