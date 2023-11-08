package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import javax.sound.midi.Soundbank;

public class InputView {

    private static final String MSG_AMOUNT_OF_MONEY = "구입금액을 입력해 주세요.";
    private static final String MSG_WINNING_NUMBER = "당첨 번호를 입력해 주세요..";
    private static final String MSG_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static String inputAmountOfMoney() {
        System.out.println(MSG_AMOUNT_OF_MONEY);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(MSG_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(MSG_BONUS_NUMBER);
        return Console.readLine();
    }


}
