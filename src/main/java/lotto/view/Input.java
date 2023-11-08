package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static String setPlayerMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> setWinnerNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return makeNumberChange(Console.readLine());
    }

    public static int setBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> makeNumberChange(String winnerNumber) {
        String[] tmp = winnerNumber.split(",");
        List<Integer> winnerNum = new ArrayList<>();
        for (String s : tmp) {
            winnerNum.add(convent(s));
        }
        return winnerNum;
    }

    public static int convent(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR} 숫자를 입력해 주세요.");
        }
    }
}
