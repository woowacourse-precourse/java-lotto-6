package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }


    public void run() throws IllegalArgumentException{

        try {
            //횟수 체크
            int times = runInputMoney();

            //로또 생성 후 출력
            List<Lotto> lottoes = lottoService.createLottoes(times);
            runPrintPurchaseLottoes(lottoes);

            //유저의 당첨 번호, 보너스 번호
            Lotto userWinningNum = runInputWinningNum();
            Integer bonusNum = runInputBonusNum(userWinningNum);

            //구매 로또랑 유저 번호랑 매칭 작업
            HashMap<Integer, Integer> matchCount = runMatchNums(lottoes, userWinningNum, bonusNum);
            double rateOfReturn = lottoService.calculateRateOfReturn(times*1000, matchCount);

            //당첨 통계 출력 -> 파라미터 채우기
            runPrintFinalResult(matchCount, rateOfReturn);

        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }

    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    //inputView 실행
    public int runInputMoney(){
        String inputMoney = InputView.inputMoney();
        int times = lottoService.convertToTimes(inputMoney);
        return times;
    }

    public Lotto runInputWinningNum(){
        String inputWinningNum = InputView.inputWinningNum();
        Lotto lotto = lottoService.convertToLotto(inputWinningNum);
        return lotto;
    }

    public int runInputBonusNum(Lotto winningNum){
        String inputBonusNum = InputView.inputBonusNum();
        return lottoService.validateUserBonusNum(winningNum, inputBonusNum);
    }

    //서비스 코드 실행
    public HashMap<Integer, Integer> runMatchNums(List<Lotto> lottoes, Lotto userWinningNum, Integer bonusNum){
        return lottoService.matchNums(lottoes, userWinningNum, bonusNum);
    }


    //outputView 실행
    public void runPrintPurchaseLottoes(List<Lotto> lottoes){
        OutputView.printPurchaseLottoes(lottoes);
    }

    public void runPrintFinalResult(HashMap<Integer, Integer> matchCount, double rateOfReturn){
        OutputView.printFinalResult(matchCount, rateOfReturn);
    }


}
