package domain;

import utils.Validator;

import java.util.List;

public class Player {
    private Lotto winningLotto;
    private int bonusNumber;
    private double money;
    private double lottoSum = 0;

    public Player(int money) {
        this.money = money;
    }

    private Player(List<Integer> numbers, int bonusNumber, int money) {
    }

    public void setWinningLotto(List<Integer> numbers) {
        validateWinningNumber(numbers);
        winningLotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(winningLotto.getLottoNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void earn(int sum) {
        lottoSum += sum;
    }

    public void minus(int sum) {
        lottoSum -= sum;
    }

    private void validateWinningNumber(List<Integer> numbers) {
        Validator.checkLottoSizeNumberInput(numbers);
        Validator.checkLottoDuplicatedNumberInput(numbers);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
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
