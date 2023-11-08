package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.Validator;

public class InputView {

    public static int inputPurchaseAmount() {
        try {
            String input = inputNotBlank();
            int purchaseAmount = Validator.purchaseAmountAndGet(input);
            return LottoService.amountPurchaseDivide(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static Lotto inputWinningNum() {
        try {
            String input = inputNotBlank();
            List<Integer> winNumberList = Validator.lottoNumberAndGet(toIntList(input));
            return new Lotto(winNumberList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    public static int inputBonusNum(Lotto winningNumbers) {
        try {
            String input = inputNotBlank();
            return Validator.bonusNumberAndGet(input, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum(winningNumbers);
        }
    }

    private static String inputNotBlank() {
        String input = Console.readLine();
        Validator.isBlank(input);
        return input;
    }

    private static List<Integer> toIntList(String input) {
        return Arrays.asList(input.split(",")).stream()
            .map(Integer::parseInt)
            .toList();
    }
}
