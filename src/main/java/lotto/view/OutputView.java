package lotto.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_PREFIX + exceptionMessage);
    }

    public void requestPurchaseAmountMessage() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchasedNumberMessage(int number) {
        System.out.println(number + PRINT_LOTTO_PURCHASE_MESSAGE);
    }

    public void printAllLottoNumbers(String allLottoNumbers) {
        System.out.println(allLottoNumbers);
    }

    public void requestWinningLottoMessage() {
        System.out.println(REQUEST_WINNING_LOTTO_MESSAGE);
    }

    public void requestBonusNumberMessage() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }
}
