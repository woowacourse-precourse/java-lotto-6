package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
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

    public String readWinningLotto() {
        System.out.println(WINNING_LOTTO_MESSAGE);
        String winningLotto = Console.readLine();
        return winningLotto;
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

}
