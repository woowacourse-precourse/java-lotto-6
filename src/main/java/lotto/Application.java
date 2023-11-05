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

        //유저가 입력받은 값을 받아서 Lotto에 저장하는 구문
        Lotto userLottoNumbers = lottoController
                                .userInputMasterLottoNumbers();
        System.out.println(userLottoNumbers);
        LottoBonus userLottoBonusNumber;

        //유저 보너스 번호 입력하는 구간
        LottoBonus lottoBonus = lottoController
                                .userInputMasterLottoBonusNumber(userLottoNumbers);
        System.out.println(lottoBonus);

        // 번호들 출력되는 구문
        lottoController.showAutoLottoTicks(buyNumber,autoLottoTicket);








    }
}
