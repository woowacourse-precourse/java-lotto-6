package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Validator.isValidPurchaseAmount(Console.readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            return Validator.isValidWinningNumbers(Console.readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            return Validator.isValidBonusNumber(Console.readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputBonusNumber();
        }
    }
}
