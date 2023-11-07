package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import javax.sound.midi.Soundbank;

public class InputView {


    public static String inputAmountOfMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static String inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }


}
