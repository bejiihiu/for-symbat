package kz.bejiihiu.game.skills;

public class Skills {
    public int shooting;
    public int stealth;
    public int tactics;

    public Skills(int shooting, int stealth, int tactics) {
        this.shooting = shooting;
        this.stealth = stealth;
        this.tactics = tactics;
    }

    public int total() {
        return shooting + stealth + tactics;
    }

    @Override
    public String toString() {
        return String.format("Стрельба: %d, Скрытность: %d, Тактика: %d", shooting, stealth, tactics);
    }
}
