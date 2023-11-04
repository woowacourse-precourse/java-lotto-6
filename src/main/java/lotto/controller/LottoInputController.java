package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputController {
    private static final LottoInputController inputController = new LottoInputController();

    private LottoInputController() {
    }

    public static LottoInputController getInstance() {
        return inputController;
    }

    public String getUserInputForAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public String getUserInputForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        final String input = Console.readLine();
        return input;
    }

    public String getUserInputForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        final String input = Console.readLine();
        return input;
    }
}
