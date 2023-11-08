package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import util.Formatter;

public class InputView {
    public static int userPurchaseLotto() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> lottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Formatter.stringToIntegerList(Console.readLine());
        return numbers;
    }

    public static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
