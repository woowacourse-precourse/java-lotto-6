package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class InputView {

    private static List<Integer> winningNumberList;

    public static String inputPlayerAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> inputLottoWinningNum() {
        System.out.print("\n");
        System.out.println("당첨 번호를 입력해 주세요.");
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.print("\n");
        System.out.println("보너스 번호를 입력해 주세요.");
        try{
            String t = Console.readLine();
            return Integer.parseInt(t);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            Controller controller = new Controller();
            controller.validateBonus();
            throw new IllegalArgumentException();
        }
        //return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            Controller controller = new Controller();
            controller.validateBonus();
            throw new IllegalArgumentException();
        }
    }
}
