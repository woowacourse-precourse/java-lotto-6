package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static InputView instance;

    private InputView() {}

    public static InputView getInstance() {
        if(instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

}
