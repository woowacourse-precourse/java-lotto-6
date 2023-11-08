package lotto.controller;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.service.LottoService;
import lotto.validator.ValidateBonusNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    LottoService service=new LottoService();
    public void run(){
        OutputView.printRequestPurchaseAmount();
        int purchaseAmount = requestPurchaseAmount();

        Lottos lottos = service.exchangeLottoTicket(purchaseAmount);
        printLotto(lottos);

        OutputView.printRequestWinningNumber();
        Lotto winningNumber = requestWinningNumber();

        OutputView.printRequestBonusNumber();
        int bonusNumber = requestBonusNumber(winningNumber);

        WinningNumber winningNumbers = service.setWinningNumber(winningNumber, bonusNumber);

        List<LottoResult> result = printWinningStatics(lottos, winningNumbers);

        printTotalRevenue(purchaseAmount, result);
    }

    private List<LottoResult> printWinningStatics(Lottos lottos, WinningNumber winningNumbers) {
        List<LottoResult> result = service.getResult(lottos, winningNumbers);
        OutputView.printWinningStatics(result);
        return result;
    }

    private void printTotalRevenue(int purchaseAmount, List<LottoResult> result) {
        double revenue = service.calculateRevenue(purchaseAmount, result);
        OutputView.printTotalRevenue(revenue);
    }

    private int requestPurchaseAmount(){
        while(true){
            try {
                return InputView.requestPurchaseAmount();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }


    private Lotto requestWinningNumber(){
        while(true){
            try {
                List<Integer> winningNumbers = InputView.requestWinningNumber();
                Lotto winningNumber =new Lotto(winningNumbers);
                return winningNumber;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber(Lotto winningNumber){
        while(true){
            try {
                int bonusNumber = InputView.requestBonusNumber();
                ValidateBonusNumber.validateDuplicateBonusNumber(winningNumber,bonusNumber);
                return bonusNumber;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printLotto(Lottos lottos){
        List<Lotto> lottos1 = lottos.getLottos();
        for (Lotto lotto : lottos1) {
            OutputView.printLotto(lotto.getLotto());
        }
    }

}
