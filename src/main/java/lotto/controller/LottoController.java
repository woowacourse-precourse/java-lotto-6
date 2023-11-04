package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.BuyLotto;
import lotto.domain.Judgement;
import lotto.domain.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final int ERROR_NUMBER = -1;
    private final int MIN_PRICE = 1000;
    private static int correctThree = 0;
    private static int correctFour = 0;
    private static int correctFive = 0;
    private static int correctFiveWithBonus = 0;
    private static int correctSix = 0;
    Validate validate = new Validate();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public long inputBuyLottoPrice() {
        long price = 0;
        String inputPrice = inputView.inputMessageHowMuchPrice();
        while (true) {
            price = validate.validateInputPrice(inputPrice);

            if (price >= MIN_PRICE) {
                break;
            }

            inputPrice = inputView.inputMessageHowMuchPrice();
        }

        return price;
    }

    public List<Integer> inputWinnerNumbers() {
        List<Integer> result;
        String inputNumbers = inputView.inputMessageWinnerNumbers();
        while (true) {
            result = validate.validateWinnerNumbers(inputNumbers);

            if (!result.contains(ERROR_NUMBER)) {
                break;
            }

            inputNumbers = inputView.inputMessageWinnerNumbers();
        }

        return result;
    }

    public int bonusNumbers(List<Integer> list) {
        int result = 0;
        String inputNumber = inputView.inputMessageBonusNumber();
        while (true) {
            result = validate.validateBonusNumber(inputNumber, list);

            if (result > ERROR_NUMBER) {
                break;
            }

            inputNumber = inputView.inputMessageBonusNumber();
        }

        return result;
    }

    public List<Lotto> buyLottos(long inputPrice) {
        BuyLotto buyLotto = new BuyLotto();
        return buyLotto.buyLotto(inputPrice);
    }

    public void outputLottosNumber(List<Lotto> lottos) {
        outputView.outputLottosNumbers(lottos);
    }

    public void outputTotalResult(Judgement judgement) {
        outputView.outputTotalResult(judgement);
    }
}
