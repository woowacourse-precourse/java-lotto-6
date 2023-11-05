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
            int times = runInputView();

            List<Lotto> lottoes = lottoService.createLottoes(times);

            runPrintPurchaseLottoes(lottoes);


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

    public int runInputWinningNum(){
        String inputWinningNum = InputView.inputWinningNum();

    }

    public int runInputBonusNum(){
        String inputBonusNum = InputView.inputBonusNum();

    }



    //서비스 코드 실행


    //outputView 실행
    public void runPrintPurchaseLottoes(List<Lotto> lottoes){
        OutputView.printPurchaseLottoes(lottoes);
    }
    public void runOutputView(){

    }


}
