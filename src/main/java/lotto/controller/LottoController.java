package lotto.controller;

import java.lang.reflect.Method;
import java.util.List;
import lotto.dto.LottoStatistics;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        buyLotto();
        setWinningNumbers();
        setBonusNumber();
        getWinningStatistic();
    }

    private void buyLotto(){
        while(true) {
            try {
                int purchaseAmount = inputView.inputLottoPurchaseAmount();
                lottoService.buyLotto(purchaseAmount);

                outputView.printLottoNumbers(lottoService.getMyLotto());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void setWinningNumbers(){
        while(true) {
            try {
                List<Integer> winningNumbers = inputView.inputLottoWinningNumbers();
                lottoService.saveWinningNumbers(winningNumbers);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber(){
        while(true) {
            try {
                int bonusNumber = inputView.inputLottoBonusNumber();
                lottoService.saveBonusNumber(bonusNumber);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void getWinningStatistic(){
        LottoStatistics lottoStatistics = lottoService.calcLotto();

        outputView.printLottoStatistics(lottoStatistics);
    }
}
