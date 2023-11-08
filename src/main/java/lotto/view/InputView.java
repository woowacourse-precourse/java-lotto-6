package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.InputConverter;
import lotto.model.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoMoneyValidator;
import lotto.validator.LottoNumberValidator;

public class InputView {

    public static final String REQUEST_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static Integer getLottoMoney() {
        System.out.println(REQUEST_LOTTO_MONEY);

        String lottoMoneyInput = Console.readLine();
        try {
            LottoMoneyValidator.validate(lottoMoneyInput);
        } catch (IllegalArgumentException e) {
            return getLottoMoney();
        }

        return InputConverter.convertLottoMoney(lottoMoneyInput);
    }

    public static Lotto getWinningLotto() {
        System.out.println();
        System.out.println(REQUEST_WINNING_LOTTO_NUMBER);

        String lottoNumberInput = Console.readLine();
        try {
            LottoNumberValidator.validate(lottoNumberInput);
        } catch (IllegalArgumentException e) {
            return getWinningLotto();
        }

        return InputConverter.convertWinningLotto(lottoNumberInput);
    }

    public static Integer getBonusNumber(Lotto winningLotto) {
        System.out.println();
        System.out.println(REQUEST_BONUS_NUMBER);

        String bonusNumberInput = Console.readLine();
        try {
            BonusNumberValidator.validate(bonusNumberInput, winningLotto);
        } catch (IllegalArgumentException e) {
            return getBonusNumber(winningLotto);
        }

        return InputConverter.convertBonusNumber(bonusNumberInput);
    }


}
