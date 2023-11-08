package lotto.model;


public class LottoDraw {
    private final Lotto lotto;
    private final Bonus bonus;


    private LottoDraw(Lotto lotto, Bonus bonus){
        //exception 필요
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static LottoDraw by(Lotto lotto, Bonus bonus){
        return new LottoDraw(lotto, bonus);
    }


    public int getBonusNumber() {
        return bonus.getBonusNumber();
    }
    public Lotto getLotto() {
        return lotto;
    }

    public boolean isMatching(int number) {
        return lotto.getNumbers().contains(number);
    }

    public boolean isBonusMatching(int number) {
        return number == bonus.getBonusNumber();
    }
}
