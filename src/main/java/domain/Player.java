package domain;

import utils.Validator;

import java.util.List;

public class Player {
    private Lotto winningLotto;
    private int bonusNumber;
    private double money;
    private double lottoSum = 0;

    public Player(List<Integer> numbers, int bonusNumber, int money) {
        validate(numbers, bonusNumber);
        winningLotto = new Lotto(numbers);
        this.money = money;
    }

    public void earn(int sum) {
        lottoSum += sum;
    }

    public void minus(int sum) {
        lottoSum -= sum;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        Validator.checkLottoSizeNumberInput(numbers);
        Validator.checkLottoDuplicatedNumberInput(numbers);
        Validator.checkLottoBonusNumber(numbers, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public double getMoney() {
        return money;
    }

    public double getLottoSum() {
        return lottoSum;
    }
}
