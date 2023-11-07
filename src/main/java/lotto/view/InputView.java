package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.InputConverter;
import lotto.validator.LottoMoneyValidator;

public class InputView {
    public static Integer getLottoMoney() {
        String lottoMoneyInput = Console.readLine();
        LottoMoneyValidator.validate(lottoMoneyInput);
        return InputConverter.convertLottoMoney(lottoMoneyInput);
    }
}
