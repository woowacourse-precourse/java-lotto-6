package domain;

import utils.Validator;

import java.util.List;

public class Player {
    private Lotto winningLotto;
    private int bonusNumber;

    public Player(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        winningLotto = new Lotto(numbers);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        Validator.checkLottoSizeNumberInput(numbers);
        Validator.checkLottoDuplicatedNumberInput(numbers);
        Validator.checkLottoBonusNumber(numbers, bonusNumber);
    }
}
