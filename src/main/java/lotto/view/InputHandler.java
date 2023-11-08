package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
public class InputHandler {

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(readLine());
                Validator.validateThousand(amount);
                Validator.validatePositive(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 금액을 입력하세요. (구입금액은 1000원 단위이며, 양수이어야 합니다.)");
            }
        }
    }

    public static List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNum = readLine();
                List<Integer> lottoNums = parseWinningNums(winningNum);
                Validator.validateUnique(lottoNums);
                return lottoNums;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 번호를 입력하세요. (로또 번호는 쉼표로 구분되며, 1부터 45까지의 숫자여야 합니다.)");
            }
        }
    }

    public static int inputBonusNum(List<Integer> winningNums) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNum = Integer.parseInt(readLine());
                Validator.validateRange(bonusNum);
                winningNums.add(bonusNum);
                Validator.validateUnique(winningNums);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 번호를 입력하세요. (보너스 번호는 1부터 45까지의 숫자이어야 합니다.)");
            }
        }
    }


    private static List<Integer> parseWinningNums(String input) {
        String[] nums = input.split(",");
        List<Integer> winningNums = new ArrayList<>();

        for (String num : nums) {
            Validator.validateEmpty(num);
            Validator.validateNumeric(num);
            winningNums.add(Integer.parseInt(num.trim()));
        }
        return winningNums;
    }

}
