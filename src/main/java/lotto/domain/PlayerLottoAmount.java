package lotto.domain;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private final int amount;

    public PlayerLottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    // 구매 가능한 로또 개수 계산 메소드
    public int calculateLottoCount() {
        return amount / LOTTO_MIN_AMOUNT;
    }

    // 자료형이 숫자 인지 확인 메소드
    private static int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch(NumberFormatException e){
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }
    }

    private void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    // 음수가 아닌지 확인 메소드
    private void validateNatural(int amount) {
        if (amount <= 0) {
            ExceptionMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }

    // 1000원 단위인지 확인 메소드
    private void validateDivisible(int amount) {
        if (amount % LOTTO_MIN_AMOUNT != 0){
            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }
}
