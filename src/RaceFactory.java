public class RaceFactory {
    public Race getHuman() {
        return new Human();
    }

    public Race getElf() {
        return new Elf();
    }

    public Race getOrc() {
        return new Orc();
    }

    public Race getGoblin() {
        return new Goblin();
    }

    public Race getDwarf() {
        return new Dwarf();
    }

    public Race getDragonkin() {
        return new Dragonkin();
    }

    public Race getUndead() {
        return new Undead();
    }

    public Race getFae() {
        return new Fae();
    }

    public Race getBeastfolk() {
        return new Beastfolk();
    }

    public Race getTiefling() {
        return new Tiefling();
    }
}
