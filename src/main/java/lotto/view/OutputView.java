package lotto.view;

public class OutputView {
    final static String MONEY_INPUT_MESSAGE = "구매금액을 입력해주세요.";
    final static String TOTAL_LOTTO_MESSAGE = "8개를 구매했습니다.";

    public void MoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void totalLottoMessage() {
        System.out.println(TOTAL_LOTTO_MESSAGE);
    }
}
