package lotto;

import lotto.controller.LottoController;
import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.LottoIoService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {




        BuyInfo buyPriceInfo = new BuyInfo();
        buyPriceInfo = lottoController.buyInfo(buyPriceInfo);

        int buyNumber = buyPriceInfo.getBuyNumber();
        List<SeasonLottoResultVO> autoLottoTicket = lottoController
                                                    .createAutoLottoBuyChoice(buyPriceInfo
                                                    .getBuyNumber());

        // 유저 인풋 받아서 둘 다 리스트에 숑 넣기 - 코드 재활용하기
    /*    Lotto lottoMasterNumber = new Lotto();
        LottoBonus lottoMasterBonusNumber = new LottoBonus();*/

        Lotto userLottoNumber = lottoController
                                .userInputMasterLottoNumbers();



        lottoController.showAutoLottoTicks(buyNumber,autoLottoTicket);








    }
}
