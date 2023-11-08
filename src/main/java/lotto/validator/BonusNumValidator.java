package lotto.validator;

import java.util.List;

public class BonusNumValidator implements BasicValidator<String> {
    @Override
    public void validate(String input) {
        isInputEmpty(input);
        hasOneBonusNum(input);
        isRangeValid(input);
    }

    public void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    public void hasOneBonusNum(String input) {
        String[] bonusNums = input.split(" ");
        if (bonusNums.length > 1) {
            throw new IllegalArgumentException("보너스 번호는 1개만 가능합니다.");
        }
    }

    public void isRangeValid(String input) {
        int bonusNum = Integer.parseInt(input);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
