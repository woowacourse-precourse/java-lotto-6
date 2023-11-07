package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputRequirement {
    static List<String> winningNums = new ArrayList<>();

    public static int inputLottoAmount() {
        PrintInstructions.printAmountInstruction();
        try {
            int amount = Integer.parseInt(Console.readLine());
            Validation.validateAmount(amount);
            return amount;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            return inputLottoAmount();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            return inputLottoAmount();
        }
    }

    public static Lotto inputWinningNumbers() {
        PrintInstructions.printWinningNumberInstruction();
        winningNums = (Arrays.asList(Console.readLine().split(",")));
        try {
            Validation.isAllValidNumbers(winningNums);
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            inputWinningNumbers();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            inputWinningNumbers();
        }
        return new Lotto(convertStringToInt(winningNums));
    }

    public static List<Integer> convertStringToInt(List<String> original) {
        List<Integer> convert = new ArrayList<>();
        for (String previous : original) {
            int num = Integer.parseInt(previous);
            convert.add(num);
        }
        return convert;
    }

    public static int inputBonusNumber() {
        PrintInstructions.printBonusInstruction();
        try {
            int bonus = Integer.parseInt(Console.readLine());
            Validation.validateBonusNumber(bonus, winningNums);
            return bonus;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            return inputBonusNumber();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
            return inputBonusNumber();
        }
    }
}
