package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.util.LottoConverter;
import lotto.util.Validator;

public class InputView {
    private InputView() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static Integer inputMoney() {
        try {
            String money = Console.readLine();
            Validator.validateMoney(money);

            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public static Lotto inputWinningLottoNumbers() {
        try {
            String winningLottoNumbers = Console.readLine();
            Validator.validateInputPattern(winningLottoNumbers);

            return LottoConverter.convertStringToLotto(winningLottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoNumbers();
        }
    }

    public static Integer inputBonusNumber() {
        try {
            String bonusNumber = Console.readLine();
            Validator.validateInputType(bonusNumber);

            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }
}
