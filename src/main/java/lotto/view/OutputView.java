package lotto.view;

public class OutputView {
    final static String MONEY_INPUT_MESSAGE = "구매금액을 입력해주세요.";
    final static String TOTAL_LOTTO_MESSAGE = "8개를 구매했습니다.";

    public String MoneyInputMessage() {
        System.out.println("구매금액을 입력해주세요.");
        return MONEY_INPUT_MESSAGE;
    }

    public String totalLottoMessage() {
        System.out.println("8개를 구매했습니다.");
        return TOTAL_LOTTO_MESSAGE;
    }
}
