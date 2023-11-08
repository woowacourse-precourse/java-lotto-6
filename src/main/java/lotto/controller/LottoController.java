package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.LottoSetPriceException;

public class LottoController {

    private final LottoSetPriceException lottoSetPriceException = new LottoSetPriceException();

    public int LottoSetPrice() {
        String readPrice = Console.readLine();
        int lottoPrice = lottoSetPriceException.checkPriceException(readPrice);
        return lottoPrice;
    }
}
