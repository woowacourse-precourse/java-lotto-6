package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMoney;
import lotto.util.converter.ConverterHolder;

public class InputView {

    private static final String LOTTO_MONEY_INPUT = "구입금액을 입력해 주세요.";

    public LottoMoney getLottoMoney() {
        System.out.println(LOTTO_MONEY_INPUT);
        String input = Console.readLine();
        try {
            return ConverterHolder.convert(input, LottoMoney.class);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoMoney();
        }
    }
}
