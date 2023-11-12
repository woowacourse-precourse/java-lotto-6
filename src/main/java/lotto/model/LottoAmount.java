package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private final int amount;

    public LottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public void validateAmount(int amount){
        validateNatural(amount);
        validateDivisible(amount);
    }
    private static int validateNumber(String amount) throws IllegalArgumentException {
        try{
            return Integer.parseInt(amount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해주세요.");
        }
    }

    private void validateNatural(int amount){
        if (amount <= 0){
            throw new IllegalArgumentException("[ERROR] 양의 정수만 가능합니다.");
        }
    }

    private void validateDivisible(int amount){
        if (amount%LOTTO_MIN_AMOUNT != 0){
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
        }
    }

    public int calculateLottoCount() {
        return amount / LOTTO_MIN_AMOUNT;
    }
}
