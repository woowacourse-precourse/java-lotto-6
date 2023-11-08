package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.service.ValidateService;
import lotto.view.GameView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constant.*;

public class LottoGame {

    private ValidateService validateService;
    private LottoService lottoService;
    private GameView gameView;

    private int buyPrice;
    private int lottoCount;
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winNumbers;
    private int bonusNumber;
    private int totalWinPrice;
    private double rateOfReturn;
    private int[] result;

    public LottoGame() {
        this.validateService = new ValidateService();
        this.lottoService = new LottoService();
        this.gameView = new GameView();
    }

    public void start() {
        buyLottoInput();
        publishLotto();
        printLotto();
        winNumbersInput();
        bonusNumberInput();
        calculateResult();
    }

    private void calculateResult() {
        result = lottoService.calculateResult(lottos,winNumbers,bonusNumber);
        totalWinPrice = lottoService.calculateTotalWinPrice(result);
        rateOfReturn = calculateRateOfReturn();
    }

    private double calculateRateOfReturn() {
        return totalWinPrice / buyPrice * 100;
    }

    private void buyLottoInput() {
        boolean correctInputFlag;
        do {
            try {
                String buyPriceInput = Console.readLine();
                buyPrice = validateService.validateBuyLottoInput(buyPriceInput);
                correctInputFlag = true;
            } catch (IllegalArgumentException e) {
                gameView.errorMessageView(e.getMessage());
                correctInputFlag = false;
            }
        } while (!correctInputFlag);
    }

    private void publishLotto() {
        calculateLottoCount();
        lottoService.createLotto(lottoCount, lottos);
    }

    private void calculateLottoCount() {
        lottoCount = buyPrice / LOTTO_PRICE_FOR_ONE;
    }

    private void printLotto() {
        gameView.lottoPrintView(lottoCount, lottos);
    }

    private void winNumbersInput() {
        boolean correctInputFlag;
        do {
            try {
                String winNumbersInput = Console.readLine();
                winNumbers = validateService.createWinNumbers(winNumbersInput);
                correctInputFlag = true;
            } catch (IllegalArgumentException e) {
                gameView.errorMessageView(e.getMessage());
                correctInputFlag = false;
            }
        } while (!correctInputFlag);
    }

    private void bonusNumberInput() {
        boolean correctInputFlag;
        do {
            try {
                String bonusNumberInput = Console.readLine();
                bonusNumber = validateService.validateBonusNumberInput(winNumbers, bonusNumberInput);
                correctInputFlag = true;
            } catch (IllegalArgumentException e) {
                gameView.errorMessageView(e.getMessage());
                correctInputFlag = false;
            }
        } while (!correctInputFlag);
    }
}
