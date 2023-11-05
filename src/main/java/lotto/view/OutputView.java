package lotto.view;

public class OutputView {
    final static String MONEY_INPUT_MESSAGE = "구매금액을 입력해주세요.";

    public String inputMoney() {
        System.out.println("구매금액을 입력해주세요.");
        return MONEY_INPUT_MESSAGE;
    }
}
