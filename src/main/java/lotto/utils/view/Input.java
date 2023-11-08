package lotto.utils.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumbers;
import lotto.utils.constant.BuyPrice;

public class Input {
    public BuyPrice setupBuyPrice() {
        return new BuyPrice(Console.readLine());
    }

    public LottoNumbers setupLottoNumbers() {
        return new LottoNumbers(Console.readLine());
    }
}
