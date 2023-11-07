package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class InputView {
    public static int inputPurchaseAmount() {
        String input = inputNotBlank();
        Lotto.validateInputString(input);
        int purchaseInput = Integer.parseInt(input);
        Lotto.validateInputPurchaseAmount(purchaseInput);
        return LottoService.amountPurchaseDivide(purchaseInput);
    }

    public static Lotto inputWinningNum() {
        String input = inputNotBlank();
        List<Integer> winNumberList = Lotto.validateInputWinningNumber(input);
        Lotto.validateNoDuplicates(winNumberList);
        Lotto.validateNumberRange(winNumberList);
        Lotto.validateSixNumbers(winNumberList);
        return new Lotto(winNumberList);
    }

    public static int inputBonusNum(Lotto winningNumbers) {
        String input = inputNotBlank();
        Lotto.validateInputString(input);
        Lotto.validateBonusNumberRange(Integer.parseInt(input), winningNumbers);
        int bonusNumber = Integer.parseInt(input);

        return bonusNumber;
    }

    private static String inputNotBlank() {
        String input = Console.readLine();
        Lotto.validateIsBlank(input);
        return input;
    }
}
