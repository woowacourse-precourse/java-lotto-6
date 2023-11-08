package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.WinningLottoNumbers;
import lotto.service.LottoCountService;
import lotto.service.LottoGenerateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoGenerateService lottoGenerateService;
    private LottoCountService lottoCountService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoGenerateService = new LottoGenerateService();
        lottoCountService = new LottoCountService();
    }

    public void play() {
        try {
            int lottoAmount = getInput(() -> inputView.getPurchaseAmount());

//            int lottoAmount = getPurchaseInput();

            List<Lotto> userPurchasedLotto = lottoGenerateService.generateMultipleLotto(lottoAmount);

            outputView.printPurchasedLotto(userPurchasedLotto);

//            WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbersInput();

            WinningLottoNumbers winningLottoNumbers = getInput(()-> inputView.getWinningLottoNumbers());


            Bonus bonus = inputView.getBonusLottoNumber(winningLottoNumbers);

            Match matchResult = lottoCountService.countMatching(userPurchasedLotto, winningLottoNumbers, bonus);

            outputView.printMatchResult(matchResult);

            double profit = lottoCountService.countProfit(matchResult, lottoAmount);

            outputView.printProfit(profit);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getPurchaseInput(){

        do {
            try {
                int lottoAmount = inputView.getPurchaseAmount();
                return lottoAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    private WinningLottoNumbers getWinningLottoNumbersInput(){
        do {
            try {
                WinningLottoNumbers winningLottoNumbers = inputView.getWinningLottoNumbers();
                return winningLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while (true);

    }

    private <T> T getInput(Supplier<T> inputSupplier){
        do {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while (true);
    }

}
