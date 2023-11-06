package view;

public class OutputVIew {

    static final String MONEY_INPUT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    static final String PURCHASING_RESULT_MESSAGE = "개를 구매했습니다.";

    void  printMoneyInputRequestMessage() {
        System.out.println(MONEY_INPUT_REQUEST_MESSAGE);
    }

    void printPurchasingResultMessage() {
        System.out.println(PURCHASING_RESULT_MESSAGE);
    }
}
