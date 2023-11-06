package lotto.exception;

public class LottoPurchaseAmountException {
    private static final String CAN_DIVIDE_THOUSAND_MESSAGE = "구매 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String IS_NUMBER_MESSAGE = "구매 금액은 숫자를 입력해주셔야 합니다.";
    private static final String IS_BLANK_MESSAGE = "구매 금액을 공백으로 입력하셨습니다.";


    public void isDivideThousand(int input) {
        if(input % 1000 != 0) {
            throw new IllegalArgumentException(CAN_DIVIDE_THOUSAND_MESSAGE);
        }
    }

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(IS_NUMBER_MESSAGE);
        }

    }

    public void isBlank(String input) {
        if(input.trim().isEmpty()){
            throw new IllegalArgumentException(IS_BLANK_MESSAGE);
        }
    }
}
