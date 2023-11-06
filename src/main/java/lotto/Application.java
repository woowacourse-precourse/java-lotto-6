package lotto;

import lotto.controller.LottoController;
import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.dto.Yield;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.view.LottoResultPrint;
import java.util.List;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {

        BuyInfo buyPriceInfo = new BuyInfo();
        buyPriceInfo = lottoController.buyInfo(buyPriceInfo);

        int buyNumber = buyPriceInfo.getBuyNumber();
        // 여기에 티켓들의 정보들이 다 담겨있음 -> 조회 필요
        List<SeasonLottoResultVO> autoLottoTicket = lottoController
                                                    .createAutoLottoBuyChoice(buyPriceInfo
                                                    .getBuyNumber());

        // 번호들 출력되는 구문
        lottoController.showAutoLottoTicks(buyNumber,autoLottoTicket);

        //유저가 입력받은 값을 받아서 Lotto에 저장하는 구문
        Lotto userLottoNumbers = lottoController
                                .userInputMasterLottoNumbers();

        //유저 보너스 번호 입력하는 구간
        LottoBonus lottoBonus = lottoController
                                .userInputMasterLottoBonusNumber(userLottoNumbers);

        // 당첨 통계 나오는 구간
        System.out.println("당첨 통계");
        System.out.println("---");

        //티켓을 조회하는 로직
        LottoResultPrint lottoResultPrint = lottoController.LottoPrizeResult
                                                            (autoLottoTicket,
                                                              userLottoNumbers,
                                                              lottoBonus);
        lottoResultPrint.lottoResultPrint();

        // 당첨 통계를 출력하는 부분

        Yield yieldAttribute = new Yield();
        int investment = buyPriceInfo.getBuyWon();
        long totalPrize = lottoResultPrint.resultTotalPrize();
        yieldAttribute.setInvestmen(investment);
        yieldAttribute.setTotalPrize(totalPrize);
        lottoController.LottoYield(yieldAttribute);
    }
}
