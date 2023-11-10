package lotto.domain.lotto;

import lotto.exception.LottoMoneyDivideException;
import lotto.exception.LottoMoneyLessException;
import lotto.exception.LottoNumNotNumException;

public class LottoAmount {
    private static final int LOTTO_AMOUNT_DIVIDE = 1000;
    private static int amount;

    public LottoAmount(String amountString) {
        int amountNum = validateNumber(amountString);
        validate(amountNum);
        this.amount = amountNum;
    }

    public int amountChangeToLottoCnt(){
        return amount / LOTTO_AMOUNT_DIVIDE;
    }

    private static void validate(int amount) {
        validatePositive(amount);
        validateRemainder(amount);
    }

    private static int validateNumber(String lottoMoneyString) {
        try {
            return Integer.parseInt(lottoMoneyString);
        } catch (NumberFormatException e) {
            throw new LottoNumNotNumException();
        }
    }

    private static void validatePositive(int amount) {
        if(amount <= 1000){
            throw new LottoMoneyLessException();
        }
    }

    private static void validateRemainder(int amount) {
        if (amount % LOTTO_AMOUNT_DIVIDE != 0) {
            throw new LottoMoneyDivideException();
        }
    }
}
