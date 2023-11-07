package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoGenerator;
import lotto.global.validator.Validator;

public class InputView {

    public int inputLottoPrice() {
        System.out.println(OutputType.INPUT_PURCHASE_AMOUNT_MESSAGE.getValue());
        String userInputPrice = Console.readLine();

        Validator validator = new Validator();

        if (!validator.isValidatePurchasePrice(userInputPrice)) {
            return inputLottoPrice();
        }

        return Integer.parseInt(userInputPrice);
    }

    public Lotto inputWinningNumber() {
        System.out.println(OutputType.WINNING_NUMBER_INPUT_MESSAGE.getValue());
        String userInputWinningNumber = Console.readLine();

        Validator validator = new Validator();

        if (!validator.isValidateWinningNumber(userInputWinningNumber)) {
            return inputWinningNumber();
        }
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateWinningNumber(userInputWinningNumber);
    }

    public int inputBonusNumber() {
        System.out.println(OutputType.BONUS_NUMBER_INPUT_MESSAGE.getValue());
        String userInputBonusNumber = Console.readLine();

        Validator validator = new Validator();

        if (!validator.isValidateBonusNumber(userInputBonusNumber)) {
            return inputBonusNumber();
        }
        return Integer.parseInt(userInputBonusNumber);
    }
}
