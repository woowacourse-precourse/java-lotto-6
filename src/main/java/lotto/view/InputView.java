package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String INPUT_MONEY ="구입 금액을 입력해주세요.";
    private final static String INPUT_WINNING_LOTTO ="당첨 번호를 입력해주세요.";
    private final static String INPUT_BONUS_NUMBER ="보너스 번호를 입결해 주세요.";

    public String InputMoney(){
        System.out.println(INPUT_MONEY);
        return readLine();
    }

    public String InputWinningLotto(){
        System.out.println(INPUT_WINNING_LOTTO);
        return readLine();
    }

    public String InputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return readLine();
    }
}