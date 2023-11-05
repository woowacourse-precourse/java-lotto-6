package lotto;

import lotto.controller.LottoController;
import lotto.model.dto.BuyInfo;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.LottoIoService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {
        BuyInfo buyPriceInfo = new BuyInfo();
        buyPriceInfo = lottoController.buyInfo(buyPriceInfo);
        System.out.println(buyPriceInfo.getBuyWon());
        System.out.println(buyPriceInfo.getBuyNumber());

        int buyNumber = buyPriceInfo.getBuyNumber();
        List<SeasonLottoResultVO> autoLottoTicket = lottoController
                                                    .createAutoLottoBuyChoice(buyPriceInfo
                                                    .getBuyNumber());





        lottoController.showAutoLottoTicks(buyNumber,autoLottoTicket);








    }
}
