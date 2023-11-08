package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Util.Validation;

public class InputView {

    public static int getPurchaseAmount() {
        String input = Console.readLine();
        return Validation.validatePurchaseAmount(input);
    }

    public static List<Integer> getLottoNumbers() {
        String input = Console.readLine();
        return Validation.validateLottoNumbers(input);
    }

    public static int getBonusNumber(List<Integer> lottoNumbers) {
        String input = Console.readLine();
        return Validation.validateBonusNumber(lottoNumbers, input);
    }
}
