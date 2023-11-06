package lotto.controller;


import lotto.model.LottoPurchaseManager;
import lotto.utils.Messages;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;
    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void process(){
        final int trial = insertMoney();
        buyLottos(trial);
        pickLottoNumbers();
        pickBonusNumber();
        lottoService.aggregateLotto();
        showFinalResult(trial);
    }

    private int insertMoney(){
        while (true){
            try {
                return handleMoneyInput();
            }catch (IllegalStateException | IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
    private int handleMoneyInput() {
        String moneyBeforeValidated = inputView.readMoney();
        return LottoPurchaseManager.createLottoPurchaseManager(moneyBeforeValidated).getTrial();
    }

    private void buyLottos(final int trial){
        outputView.printWithArguments(Messages.ALARM_TRIAL.toString(), trial);
        lottoService.generateLottos(trial);
        outputView.printLottos(lottoService.getLottos());
    }

    private void pickLottoNumbers(){
        while (true){
            try{
                String numbersBeforeValidated = inputView.readWinningNumbers();
                lottoService.pickWinningLotto(numbersBeforeValidated);
                break;
            }catch (IllegalStateException | IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void pickBonusNumber(){
        while (true){
            try{
                String bonusNumberBeforeValidated = inputView.readBonusNumber();
                lottoService.pickBonusNumber(bonusNumberBeforeValidated);
                break;
            }catch (IllegalStateException | IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void showFinalResult(final int trial){
        outputView.printLottoResult(lottoService.countProfitRate(trial));
    }
}
