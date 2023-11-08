package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.BuyLotto;
import lotto.domain.Judgement;
import lotto.domain.Numbers;
import lotto.domain.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static final int CURRENCY_UNIT = 1000;
    private final int ERROR_NUMBER = -1;
    private final int MIN_PRICE = 1000;
    private final int MIN_CORRECT_AMOUNT = 3;
    private final int MAX_CORRECT_AMOUNT = 6;
    private final long INPUT_PRICE;
    private final List<Lotto> MY_LOTTOS;
    private final List<Integer> WINNER_NUMBERS;
    private final int BONUS_NUMBER;
    private static long totalReward = 0;

    Validate validate = new Validate();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public LottoController() {
        this.INPUT_PRICE = inputBuyLottoPrice();
        this.MY_LOTTOS = buyLottos(INPUT_PRICE);
        outputView.outputLottosNumbers(MY_LOTTOS);
        this.WINNER_NUMBERS = inputWinnerNumbers();
        this.BONUS_NUMBER = inputBonusNumbers();
    }

    private long inputBuyLottoPrice() {
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

    private List<Integer> inputWinnerNumbers() {
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

    private int inputBonusNumbers() {
        int result = 0;
        String inputNumber = inputView.inputMessageBonusNumber();
        while (true) {
            result = validate.validateBonusNumber(inputNumber, WINNER_NUMBERS);

            if (result > ERROR_NUMBER) {
                break;
            }

            inputNumber = inputView.inputMessageBonusNumber();
        }

        return result;
    }

    private List<Lotto> buyLottos(long inputPrice) {
        BuyLotto buyLotto = new BuyLotto();
        return buyLotto.buyLotto(inputPrice);
    }

    /**
     * 실제 호출하는 메서드
     */
    public void calcReward() {
        Judgement judgement = new Judgement();
        for (Lotto lotto : MY_LOTTOS) {
            int correct = lotto.compareLottoToWinnerNumbers(WINNER_NUMBERS, BONUS_NUMBER);

            if (correct > 2) {
                judgement.setCorrectNumber(correct);
                totalReward += judgement.getReward(correct);
            }
        }

        outputView.outputResult(MIN_CORRECT_AMOUNT, MAX_CORRECT_AMOUNT);
    }

    public void outputTotalReward() {
        Numbers numbers = new Numbers();
        double ratioOfReturn = numbers.rateOfReturn(totalReward, INPUT_PRICE);
        outputView.outputTotalResult(ratioOfReturn);
    }
}
