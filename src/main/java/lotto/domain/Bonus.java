package lotto.domain;

public class Bonus {
    private final int bonus;

    private Bonus(int bonus){
        this.bonus = bonus;
    }

    public static Bonus from(String bonus){
        return new Bonus(Integer.parseInt(bonus));
    }
}
