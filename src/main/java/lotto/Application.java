package lotto;

import lotto.controller.LottoController;
import lotto.io.LottoPrizeResult;
import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.LottoIoService;
import lotto.view.LottoResultPrint;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {

       LottoResultPrint lottoResultPrint = new LottoResultPrint();
/*
        lottoResultPrint.addResult(3,false);
        lottoResultPrint.addResult(4,false);
        lottoResultPrint.addResult(4,false);
        lottoResultPrint.addResult(5,false);

        lottoResultPrint.lottoResultPrint();*/
        //3개 일치 ( 5,000원 ) - 1개
        //4개 일치 ( 50,000월 ) - 2개
        //5개 일치 ( 1,500,000원 ) - 1개
        //5개 일치, 보너스 볼 일치 ( 30,000,000원 ) - 0개
        //6개 일치 ( 2,000,000,000원 ) - 0개






        BuyInfo buyPriceInfo = new BuyInfo();
        buyPriceInfo = lottoController.buyInfo(buyPriceInfo);

        int buyNumber = buyPriceInfo.getBuyNumber();
        // 여기에 티켓들의 정보들이 다 담겨있음 -> 조회 필요
        List<SeasonLottoResultVO> autoLottoTicket = lottoController
                                                    .createAutoLottoBuyChoice(buyPriceInfo
                                                    .getBuyNumber());

        // 유저 인풋 받아서 둘 다 리스트에 숑 넣기 - 코드 재활용하기
    /*    Lotto lottoMasterNumber = new Lotto();
        LottoBonus lottoMasterBonusNumber = new LottoBonus();*/

        //유저가 입력받은 값을 받아서 Lotto에 저장하는 구문
        Lotto userLottoNumbers = lottoController
                                .userInputMasterLottoNumbers();
        LottoBonus userLottoBonusNumber;

        //유저 보너스 번호 입력하는 구간
        LottoBonus lottoBonus = lottoController
                                .userInputMasterLottoBonusNumber(userLottoNumbers);
        // 번호들 출력되는 구문
        lottoController.showAutoLottoTicks(buyNumber,autoLottoTicket);

        // 당첨 통계 나오는 구간
        System.out.println("---");

        // 통계 이넘부터 구현하면 됨

        // --- 결과담기

        for (SeasonLottoResultVO ticket : autoLottoTicket){
            int matchPoint = 0;
            boolean bonusMatch = false;

            for(int number : ticket.getAutoLottoNumber()){
                if(userLottoNumbers.getNumbers().contains(number)){
                    //일치하는 것 디버깅
                    System.out.println(userLottoNumbers.getNumbers().contains(number));
                    matchPoint++;
                    System.out.println(matchPoint);
                }
            }
            if (lottoBonus.getNumber().contains(ticket.getAutoBonusNumber())){
                bonusMatch = true;
            }
            lottoResultPrint.addResult(matchPoint,bonusMatch);
        }

        lottoResultPrint.lottoResultPrint();




    }
}
