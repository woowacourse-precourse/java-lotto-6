package lotto.controller;


import java.util.List;
import lotto.model.Lotto;
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
        List<Lotto> myLotto = buyLottos(trial);
        Lotto winningLotto = pickLottoNumbers();
        int bonusNumber = pickBonusNumber();
        lottoService.aggregateLotto(myLotto, winningLotto, bonusNumber);
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

    private List<Lotto> buyLottos(final int trial){
        outputView.printWithArguments(Messages.ALARM_TRIAL.toString(), trial);
        List<Lotto> myLotto =  lottoService.generateLottos(trial);
        outputView.printLottos(lottoService.getLottos());
        return myLotto;
    }

    private Lotto pickLottoNumbers(){
        while (true){
            try{
                String numbersBeforeValidated = inputView.readWinningNumbers();
                return lottoService.pickWinningLotto(numbersBeforeValidated);
            }catch (IllegalStateException | IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int pickBonusNumber(){
        while (true){
            try{
                String bonusNumberBeforeValidated = inputView.readBonusNumber();
                return lottoService.pickBonusNumber(bonusNumberBeforeValidated);

            }catch (IllegalStateException | IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void showFinalResult(final int trial){
        outputView.printLottoResult(lottoService.countProfitRate(trial));
    }
}
