package lotto.util;

public enum ExceptionMessage {

    INPUT_EMPTY_MESSAGE("공백이 아닌 적절한 숫자를 입력해야 합니다."),
    INPUT_WRONG_PURCHASE_MONEY_MESSAGE("구입 금액은 0이상의 로또 가격으로 나누어 떨어지는 숫자여야 합니다."),
    INPUT_WRONG_WINNING_NUMBER_MESSAGE("로또 번호는 1부터 45 사이의 서로 다른 6개의 숫자여야 합니다."),
    INPUT_WRONG_BONUS_NUMBER_MESSAGE("보너스 번호는 당첨 번호와 다른 1부터 45 사이의 숫자여야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message){
        this.message = ERROR_TAG + message;
    }

    public void getMessage(){
        System.out.println(message);
    }

}
