package Controller;

import Model.LottoAnswerSheet;
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


    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.randomLottoGenerator = new RandomLottoGenerator();
        this.lottoAnswerSheet = new LottoAnswerSheet();
    }

    private int receiveUserMoneyAndGetAmount() {
        try {
            String inputAmount = inputView.getInputPurchaseAmount();
            return inputValidator.checkInputPurchaseAmount(inputAmount);
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

    private Lotto generateWinningLotto(List<Integer> winningLottoNumbers) {
        try {
            return lottoAnswerSheet.generateWinningLotto(winningLottoNumbers);
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveWinningLottoNumbers();
        }
    }


    public void start() {
        int lottoAmount = receiveUserMoneyAndGetAmount();
        List<Lotto> userLottos = randomLottoGenerator.generateLottos(lottoAmount);
        Lotto winningLotto = receiveWinningLottoNumbers();
    }
}
