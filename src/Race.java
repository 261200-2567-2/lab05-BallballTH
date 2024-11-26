public interface Race {
    Stats initializeStats();
    String getRaceName();
    String getDescription();
    void startLine();
}

class Human implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(50, 50, 50, 1);
    }

    @Override
    public String getRaceName() {
        return "Human";
    }

    @Override
    public String getDescription() {
        return "Balanced and versatile, humans excel at adapting to any situation.";
    }

    @Override
    public void startLine() {
        System.out.println("Adaptability is the key to survival!");
    }
}

class Elf implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(40, 70, 40, 1);
    }

    @Override
    public String getRaceName() {
        return "Elf";
    }

    @Override
    public String getDescription() {
        return "Agile and intelligent, elves are known for their affinity with magic and speed.";
    }

    @Override
    public void startLine() {
        System.out.println("Magic flows through my veins.");
    }
}

class Orc implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(90, 20, 40, 1);
    }

    @Override
    public String getRaceName() {
        return "Orc";
    }

    @Override
    public String getDescription() {
        return "Strong and resilient, orcs are natural warriors who prioritize raw power.";
    }

    @Override
    public void startLine() {
        System.out.println("Strength will crush all obstacles!");
    }
}

class Dwarf implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(80, 30, 40, 1);
    }

    @Override
    public String getRaceName() {
        return "Dwarf";
    }

    @Override
    public String getDescription() {
        return "Hardy and stout, dwarves are durable and tough, excelling in physical endurance.";
    }

    @Override
    public void startLine() {
        System.out.println("The mountain is my shield, my hammer, my home.");
    }
}

class Goblin implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(30, 40, 80, 1);
    }

    @Override
    public String getRaceName() {
        return "Goblin";
    }

    @Override
    public String getDescription() {
        return "Cunning and quick, goblins rely on their speed and wit to survive.";
    }

    @Override
    public void startLine() {
        System.out.println("Catch me if you can!");
    }
}

class Dragonkin implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(60, 60, 30, 1);
    }

    @Override
    public String getRaceName() {
        return "Dragonkin";
    }

    @Override
    public String getDescription() {
        return "Descendants of dragons, they possess strong vitality and magical aptitude.";
    }

    @Override
    public void startLine() {
        System.out.println("The blood of dragons fuels my strength.");
    }
}

class Undead implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(100, 30, 20, 1);
    }

    @Override
    public String getRaceName() {
        return "Undead";
    }

    @Override
    public String getDescription() {
        return "Resurrected beings who are hard to kill, but their speed is hindered.";
    }

    @Override
    public void startLine() {
        System.out.println("Death is just the beginning.");
    }
}

class Fae implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(20, 90, 40, 1);
    }

    @Override
    public String getRaceName() {
        return "Fae";
    }

    @Override
    public String getDescription() {
        return "Mystical beings connected to nature, they have low endurance but exceptional magical abilities.";
    }

    @Override
    public void startLine() {
        System.out.println("The magic of nature flows through me.");
    }
}

class Beastfolk implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(70, 20, 60, 1);
    }

    @Override
    public String getRaceName() {
        return "Beastfolk";
    }

    @Override
    public String getDescription() {
        return "Animalistic humanoids with great physical agility and strength.";
    }

    @Override
    public void startLine() {
        System.out.println("Let instincts guide the way.");
    }
}

class Tiefling implements Race {
    @Override
    public Stats initializeStats() {
        return new Stats(50, 70, 30, 1);
    }

    @Override
    public String getRaceName() {
        return "Tiefling";
    }

    @Override
    public String getDescription() {
        return "Demonic heritage grants them strong magical power and moderate physical abilities.";
    }

    @Override
    public void startLine() {
        System.out.println("Darkness empowers me.");
    }
}
