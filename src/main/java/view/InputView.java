package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LINEBREAK = "\n";
    private static final String INPUT_LOTTO_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public String enterLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String enterLottoNumber() {
        System.out.println(LINEBREAK + INPUT_LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
