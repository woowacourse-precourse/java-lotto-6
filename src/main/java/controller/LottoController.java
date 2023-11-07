/**
 * @Package_name   : model
 * @Class_name     : LottoController
 * <p>
 * Create Date : 2023-11-07
 * Create User : 정은채
 */
package controller;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import model.Lotto;
import model.LottoNumberPicker;
import model.LottoNumberComparater;
import model.LottoNumberSetHolder;
import model.LottoResultJudger;
import model.LottoTicketSeller;
import model.LottoWinResultsHolder;
import view.InputView;
import view.OutputView;

public class LottoController {
    /**
     * Description : 로또 로직 컨트롤러
     *
     * @Method : controlLotto()
     */
    public void controlLotto(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 구입금액 입력요청 출력하고 입력받은 후에 LottoTicketSeller에게 전달하여 구매, 구매완료문구 출력
        outputView.printLottoBuy();
        int money = inputView.inputLottoBuy();
        outputView.printNextLine();

        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(money);
        int lottoTicketNum = lottoTicketSeller.receiveLottotickets();
        outputView.printLottoBuyComplete(lottoTicketNum);

        //산 티켓 수만큼 lottoNumberPicker를 이용해 로또수를 얻어 LottoNumberSetHolder에 저장하고 출력
        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        LottoNumberSetHolder lottoNumberSetHolder = new LottoNumberSetHolder();
        while(lottoTicketNum-- > 0){
            List<Integer> LottoNums  = lottoNumberPicker.lottoNumberPick();
            Lotto lotto = new Lotto(LottoNums);
            lottoNumberSetHolder.lottoNumberSetAdd(lotto);
            outputView.printLottoNums(LottoNums);
        }
        outputView.printNextLine();

        // 당첨번호와 보너스숫자 입력요청 출력, 입력받아서 LottoNumberComparater에 비교를 위해 넣어두기
        outputView.printLottoNumRequest();
        ArrayList<Integer> resultLottoNum = inputView.inputLottoNum();
        outputView.printNextLine();
        outputView.printBonusNumRequest();
        int resultBonusNum = inputView.inputBonusNum();
        LottoNumberComparater lottoNumberComparater = new LottoNumberComparater(resultLottoNum, resultBonusNum);

        // lottoNumberSetHolder에 담긴 lotto들을 LottoNumberComparater에 넣어서 값을 받아 LottoWinResultsHolder에 넣기
        ArrayList<Lotto> LottoNumberSet = lottoNumberSetHolder.getLottoNumberSet();
        LottoWinResultsHolder lottoWinResultsHolder = new LottoWinResultsHolder();
        for (Lotto lotto : LottoNumberSet){
            String LottoWinResult = lottoNumberComparater.comparaterLottoResult(lotto.getLottoNumbers());
            lottoWinResultsHolder.lottoWinResultsAdd(LottoWinResult);
        }
        outputView.printNextLine();

        // lottoWinResultsHolder에서 전체 결과 맵 가져와서 LottoResultJudger 이용해 톡계출력
        Map<String, Integer> winResults = lottoWinResultsHolder.getWinResults();
        outputView.printWinStatistic(winResults);

        LottoResultJudger lottoResultJudger = new LottoResultJudger(winResults);
        double profit = lottoResultJudger.getProfit();
        outputView.printTotalProfit(profit);

    }
}
