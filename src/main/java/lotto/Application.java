package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.lottoMachineInput();
        List<Lotto> lottoBundle = lottoMachine.lottoMachineOutput();

        LottoResultChecker lottoResultChecker = new LottoResultChecker(lottoBundle);
        lottoResultChecker.lottoResultCheckerInput();
        lottoResultChecker.lottoResultCheckerOutput();

    }

}
