package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class InputView {
    public static int inputPurchaseAmount() {
        try {
            String input = inputNotBlank();
            Lotto.validateInputString(input);
            int purchaseInput = Integer.parseInt(input);
            Lotto.validateInputPurchaseAmount(purchaseInput);
            return LottoService.amountPurchaseDivide(purchaseInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static Lotto inputWinningNum() {
        try {
            String input = inputNotBlank();
            List<Integer> winNumberList = Lotto.validateInputWinningNumber(input);
            Lotto.validateNoDuplicates(winNumberList);
            Lotto.validateNumberRange(winNumberList);
            Lotto.validateSixNumbers(winNumberList);
            return new Lotto(winNumberList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    public static int inputBonusNum(Lotto winningNumbers) {
        try {
            String input = inputNotBlank();
            Lotto.validateInputString(input);
            Lotto.validateBonusNumberRange(Integer.parseInt(input), winningNumbers);
            int bonusNumber = Integer.parseInt(input);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum(winningNumbers);
        }
    }

    private static String inputNotBlank() {
        String input = Console.readLine();
        Lotto.validateIsBlank(input);
        return input;
    }
}
