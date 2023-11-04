package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ValidateNumberFormat;
import lotto.validation.ValidateThousandWonFormat;

public class OutputView {
    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void readBuyLottoMessage(int quantity) {
        System.out.println(quantity + BUY_LOTTO_MESSAGE);
    }
}
