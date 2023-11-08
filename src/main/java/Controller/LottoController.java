package Controller;

import Model.LottoAnswerSheet;
import Model.PrizeResult;
import Model.RandomLottoGenerator;
import Util.InputValidator;
import View.InputView;
import View.OutputView;
import java.util.List;
import lotto.Lotto;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private RandomLottoGenerator randomLottoGenerator;
    private LottoAnswerSheet lottoAnswerSheet;
    private LottoCashier lottoCashier;


    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.randomLottoGenerator = new RandomLottoGenerator();
        this.lottoAnswerSheet = new LottoAnswerSheet();
        this.lottoCashier = new LottoCashier();
    }

    private int receiveUserMoneyAndGetAmount() {
        try {
            String inputAmount = inputView.getInputPurchaseAmount();
            return inputValidator.checkInputPurchaseAmount(inputAmount) / 1000;
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveUserMoneyAndGetAmount();
        }
    }

    private Lotto receiveWinningLottoNumbers() {
        try {
            String winningLottoInput = inputView.getInputLottoWinningNumber();
            List<Integer> winningLottoNumbers = inputValidator.convertToIntegerList(winningLottoInput);
            return lottoAnswerSheet.generateWinningLotto(winningLottoNumbers);
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveWinningLottoNumbers();
        }
    }

    private int receiveBonusLottoNumber(Lotto winningLotto) {
        try {
            String bonusNumberInput = inputView.getInputLottoBonusNumber();
            int bonusNumber = inputValidator.checkInputBonusNumber(bonusNumberInput);
            return lottoAnswerSheet.generateBonusNumber(winningLotto, bonusNumber);
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveBonusLottoNumber(winningLotto);
        }
    }

    private void endLottoGame(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        PrizeResult prizeResult = lottoCashier.calculateLottoResult(userLottos, winningLotto, bonusNumber);
        double rate = lottoCashier.calculateReturnRate(userLottos.size(), prizeResult);
        outputView.printLottoResult(prizeResult);
        outputView.printReturnRate(rate);
    }

    public void start() {
        int lottoAmount = receiveUserMoneyAndGetAmount();
        List<Lotto> userLottos = randomLottoGenerator.generateLottos(lottoAmount);
        outputView.printRandomGeneratedPurchsedLottos(userLottos);
        Lotto winningLotto = receiveWinningLottoNumbers();
        int bonusNumber = receiveBonusLottoNumber(winningLotto);
        endLottoGame(userLottos, winningLotto, bonusNumber);
    }
}
