package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public String readAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
