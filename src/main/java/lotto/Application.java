package lotto;

import lotto.io.LottoInputReader;
import lotto.model.dto.BuyInfo;
import lotto.service.convert.ConvertService;
import lotto.service.domain.lotto.LottoIoService;
import lotto.view.LottoOutputPrint;

public class Application {
    private static LottoIoService ls = new LottoIoService();
    private static LottoInputReader input = new LottoInputReader();
    private static LottoOutputPrint result = new LottoOutputPrint();
    private static ConvertService convert = new ConvertService();
    public static void main(String[] args) {
        BuyInfo buyPriceInfo = new BuyInfo();
        buyPriceInfo = ls.inputAndOutputPrice(buyPriceInfo);

        System.out.println(buyPriceInfo.getBuyWon());
        System.out.println(buyPriceInfo.getBuyNumber());






    }
}
