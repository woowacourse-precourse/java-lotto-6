package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.InputConverter;
import lotto.validator.LottoMoneyValidator;

public class InputView {
    public static Integer getLottoMoney() {
        String lottoMoneyInput = Console.readLine();
        try {
            LottoMoneyValidator.validate(lottoMoneyInput);
        } catch (IllegalArgumentException e) {
            return getLottoMoney();
        }

        return InputConverter.convertLottoMoney(lottoMoneyInput);
    }

}
