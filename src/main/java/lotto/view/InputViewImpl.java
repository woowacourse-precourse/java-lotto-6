package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String readPurchaseAmount() {
        return readLine("구입금액을 입력해 주세요.");
    }

    @Override
    public String readWinningNumbers() {
        return readLine("당첨 번호를 입력해 주세요.");
    }

    @Override
    public String readBonusNumber() {
        return readLine("보너스 번호를 입력해 주세요.");
    }

    protected String readLine(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
