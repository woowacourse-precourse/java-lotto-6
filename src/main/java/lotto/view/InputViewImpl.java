package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    @Override
    public String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    @Override
    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    protected String readLine() {
        return Console.readLine();
    }
}
