package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class LottoInputView {

    private LottoInputView() {
    }

    public static int inputPurchasePrice() {
        LottoOutputView.printPurchasePriceMessage();
        String purchasePrice = Console.readLine();
        LottoInputValidator.validateNumeric(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    public static List<Integer> inputWinningLottoNumbers() {
        LottoOutputView.printWinningLottoNumbersMessage();
        String winningLottoNumbers = Console.readLine();
        LottoInputValidator.validateNumericCommaUnion(winningLottoNumbers);

        return convertToIntegerList(winningLottoNumbers);
    }

    public static int inputBonusNumber() {
        LottoOutputView.printBonusNumberMessage();
        String bonusNumber = Console.readLine();
        LottoInputValidator.validateNumeric(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private static List<Integer> convertToIntegerList(String target) {
        String[] split = target.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }

}
