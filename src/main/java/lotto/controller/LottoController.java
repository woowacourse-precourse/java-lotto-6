package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }



    //실제 실행
    public void run() throws IllegalArgumentException{

        try {

            //횟수 체크
            int times = runInputMoney();

            //로또 생성 후 출력
            List<Lotto> lottoes = lottoService.createLottoes(times);
            runPrintPurchaseLottoes(lottoes);

            //유저의 당첨 번호, 보너스 번호 -> validation
            Lotto userWinningNum = runInputWinningNum();
            Integer bonusNum = runInputBonusNum(userWinningNum);


            //TODO 구매 로또랑 유저 번호랑 매칭 작업


            //TODO 당첨 통계 출력 -> 파라미터 채우기
            runPrintFinalResult();

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
        if(lottoService.validateUserBonusNum(winningNum, inputBonusNum))
            return Integer.parseInt(inputBonusNum);
        return 0;
    }

    //TODO 서비스 코드 실행





    //outputView 실행
    public void runPrintPurchaseLottoes(List<Lotto> lottoes){
        OutputView.printPurchaseLottoes(lottoes);
    }

    public void runPrintFinalResult(){
        OutputView.printFinalResult();
    }


}
