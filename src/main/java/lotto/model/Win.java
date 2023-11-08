package lotto.model;

public class Win {

    private final Lotto lotto;
    private final int bonus;

    public Win(Lotto lotto, int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }
    public Reward result(Lotto inputlotto){
        int correct = inputlotto.countCorrect(inputlotto);
        boolean bonusBool = inputlotto.containNumbers(bonus);
        return Reward.choice(correct,bonusBool);

    }
}
