package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.InputConverter;
import lotto.validator.LottoMoneyValidator;

public class InputView {
    public static Integer getLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String lottoMoneyInput = Console.readLine();
        try {
            LottoMoneyValidator.validate(lottoMoneyInput);
        } catch (IllegalArgumentException e) {
            return getLottoMoney();
        }

        return InputConverter.convertLottoMoney(lottoMoneyInput);
    }

    public static void getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String lottoNumberInput = Console.readLine();
        try {
            LottoNumberValidator.validate(lottoNumberInput);
        } catch (IllegalArgumentException e) {
            return getWinningLotto();
        }
    }

}
