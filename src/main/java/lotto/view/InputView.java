package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.util.LottoConverter;
import lotto.util.Validator;

public class InputView {

    public static String inputMoney() {
        String money = Console.readLine();
        Validator.validateMoney(money);
        return money;
    }

    public static Lotto inputWinningLottoNumbers() {
        String winningLottoNumbers = Console.readLine();
        Validator.validateInputPattern(winningLottoNumbers);
        return LottoConverter.convertStringToLotto(winningLottoNumbers);
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
