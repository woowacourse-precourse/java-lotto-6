package lotto;

import lotto.controller.LottoController;
import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.view.LottoResultPrint;
import java.util.List;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {

       LottoResultPrint lottoResultPrint = new LottoResultPrint();

        BuyInfo buyPriceInfo = new BuyInfo();
        buyPriceInfo = lottoController.buyInfo(buyPriceInfo);

        int buyNumber = buyPriceInfo.getBuyNumber();
        // 여기에 티켓들의 정보들이 다 담겨있음 -> 조회 필요
        List<SeasonLottoResultVO> autoLottoTicket = lottoController
                                                    .createAutoLottoBuyChoice(buyPriceInfo
                                                    .getBuyNumber());

        // 번호들 출력되는 구문
        lottoController.showAutoLottoTicks(buyNumber,autoLottoTicket);

        // 유저 인풋 받아서 둘 다 리스트에 숑 넣기 - 코드 재활용하기
    /*    Lotto lottoMasterNumber = new Lotto();
        LottoBonus lottoMasterBonusNumber = new LottoBonus();*/

        //유저가 입력받은 값을 받아서 Lotto에 저장하는 구문
        Lotto userLottoNumbers = lottoController
                                .userInputMasterLottoNumbers();


        //유저 보너스 번호 입력하는 구간
        LottoBonus lottoBonus = lottoController
                                .userInputMasterLottoBonusNumber(userLottoNumbers);


        // 당첨 통계 나오는 구간
        System.out.println("당첨 통계");
        System.out.println("---");

        // 통계 이넘부터 구현하면 됨

        // --- 결과담기

        for (SeasonLottoResultVO ticket : autoLottoTicket){
            int matchPoint = 0;
            System.out.println(ticket.getAutoLottoNumber());
            System.out.println(ticket.getAutoBonusNumber());
            for(int number : ticket.getAutoLottoNumber()){
                if(userLottoNumbers.getNumbers().contains(number)){
                    matchPoint++;
                }
            }
            boolean bonusMatch = false;

            bonusMatch = ticket.getAutoLottoNumber().contains(lottoBonus.getNumber().get(0));

            System.out.println(bonusMatch);
            lottoResultPrint.addResult(matchPoint,bonusMatch);
        }
        lottoResultPrint.lottoResultPrint();

        // 총 수익률 계산하기

        // 투자 금액
        System.out.println(buyPriceInfo.getBuyWon());
        try {
            System.out.println(lottoResultPrint.resultTotalPrize());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 당첨금




    }
}
