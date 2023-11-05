package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.message.InputMessage;

public class InputView {

    public String inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
