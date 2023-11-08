package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private static List<Integer> winNums;

    private static Lotto lotto;

    public static int inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return inputLottoAmount();
        }
    }

    public static List<Integer> inputWinNums() {
        winNums = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNum = Console.readLine();
        String[] res = inputNum.split(",");

        for (String numString : res) {
            int num = Integer.parseInt(numString);
            winNums.add(num);
        }
        return winNums;
    }

    public static int inputBonusNum() {
        int bonusNum;
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Integer.parseInt(Console.readLine());
        return bonusNum;
    }


}
