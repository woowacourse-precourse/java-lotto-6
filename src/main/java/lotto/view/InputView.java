package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_MONEY = "구입금액을 입력해 주세요.";
    private static final String ENTER_MAIN_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_LOTTO = "\n보너스 번호를 입력해 주세요.";

    public String enterMoney() {
        System.out.println(ENTER_MONEY);

        return readLine();
    }

    public String enterLotto() {
        System.out.println(ENTER_MAIN_LOTTO);

        return readLine();
    }

    public String enterBonusNumber() {
        System.out.println(ENTER_BONUS_LOTTO);

        return readLine();
    }

    public void close() {
        Console.close();
    }
}
