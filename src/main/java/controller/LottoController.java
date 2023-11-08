/**
 * @Package_name : controller
 * @Class_name : LottoController
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package controller;

import java.util.ArrayList;

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
    public void controlLotto() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printLottoBuy();
        int money = inputView.inputLottoBuy();
        outputView.printNextLine();

        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(money);
        int lottoTicketNum = lottoTicketSeller.receiveLottotickets();
        outputView.printLottoBuyComplete(lottoTicketNum);

        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        LottoNumberSetHolder lottoNumberSetHolder = new LottoNumberSetHolder();
        while (lottoTicketNum-- > 0) {
            List<Integer> LottoNums = lottoNumberPicker.lottoNumberPick();
            Lotto lotto = new Lotto(LottoNums);
            lottoNumberSetHolder.lottoNumberSetAdd(lotto);
            outputView.printLottoNums(LottoNums);
        }
        outputView.printNextLine();

        outputView.printLottoNumRequest();
        ArrayList<Integer> resultLottoNum = inputView.inputLottoNum();
        outputView.printNextLine();
        outputView.printBonusNumRequest();
        int resultBonusNum = inputView.inputBonusNum();
        LottoNumberComparater lottoNumberComparater = new LottoNumberComparater(resultLottoNum, resultBonusNum);

        ArrayList<Lotto> LottoNumberSet = lottoNumberSetHolder.getLottoNumberSet();
        LottoWinResultsHolder lottoWinResultsHolder = new LottoWinResultsHolder();
        for (Lotto lotto : LottoNumberSet) {
            String LottoWinResult = lottoNumberComparater.comparaterLottoResult(lotto.getLottoNumbers());
            lottoWinResultsHolder.lottoWinResultsAdd(LottoWinResult);
        }
        outputView.printNextLine();

        Map<String, Integer> winResults = lottoWinResultsHolder.getWinResults();
        outputView.printWinStatistic(winResults);

        LottoResultJudger lottoResultJudger = new LottoResultJudger(winResults, money);
        double profit = lottoResultJudger.getProfit();
        outputView.printTotalProfit(profit);

    }
}
