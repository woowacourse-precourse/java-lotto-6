package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputBonusNumber {

    private static final String INPUT_BONUSNUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private String inputBonusNumberView(){
        System.out.println(INPUT_BONUSNUMBER_MESSAGE);
        return Console.readLine();
    }
}
