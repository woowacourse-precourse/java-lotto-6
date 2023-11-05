package lotto.model;

import java.util.List;
import lotto.utils.InputValidator;

public class User {

    private String bonus;
    private UserLotto userLotto;

    public User(List<Integer> numbers, String bonus) {
        validate(numbers, bonus);
        this.userLotto = new UserLotto(numbers);
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers, String bonus) {
        InputValidator.checkBonusNumber(numbers, bonus);
    }

}
