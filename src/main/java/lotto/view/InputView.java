package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호을 입력해 주세요.";

    public String InputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String InputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String InputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }


}
