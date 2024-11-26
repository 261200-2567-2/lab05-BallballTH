public interface Accessory {
    String getName();
    String getDescription();
    double[] getEffect(); // Returns an array of stat effects: {HP, Mana, Speed}
}

class RingOfStrength implements Accessory {
    @Override
    public String getName() {
        return "Ring of Strength";
    }

    @Override
    public String getDescription() {
        return "A powerful ring that increases strength and defense.";
    }

    @Override
    public double[] getEffect() {
        // Returns effects: +20 HP, +0 Mana, +0 Speed
        return new double[] {20, 0, 0};
    }
}

class AmuletOfWisdom implements Accessory {
    @Override
    public String getName() {
        return "Amulet of Wisdom";
    }

    @Override
    public String getDescription() {
        return "An ancient amulet that increases mana and magical power.";
    }

    @Override
    public double[] getEffect() {
        // Returns effects: +0 HP, +20 Mana, +0 Speed
        return new double[] {0, 20, 0};
    }
}

class CloakOfShadows implements Accessory {
    @Override
    public String getName() {
        return "Cloak of Shadows";
    }

    @Override
    public String getDescription() {
        return "A mystical cloak that increases speed and evasion.";
    }

    @Override
    public double[] getEffect() {
        // Returns effects: +0 HP, +0 Mana, +15 Speed
        return new double[] {0, 0, 15};
    }
}
