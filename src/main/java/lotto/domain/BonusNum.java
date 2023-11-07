package lotto.domain;

import lotto.validator.BonusNumValidator;

import java.util.List;

public class BonusNum {

    private int bonusNum;

    public BonusNum(String number, List<Integer> winningNum) {
        validate(number, winningNum);
        this.bonusNum = Integer.parseInt(number);
    }

    private void validate(String number, List<Integer> winningNum) {
        BonusNumValidator bonusNumValidator = new BonusNumValidator(number, winningNum);
    }

    public int getBonusNum() {
        return bonusNum;
    }
}