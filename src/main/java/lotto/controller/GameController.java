package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.util.Util;
import lotto.util.Validation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class GameController {

    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    private Buyer buyer;


    public void run() {
        beforePlayGame();
        gameResult();
    }

    private void beforePlayGame() {
        buyer = Buyer.from(getInputPurchaseAmount());
        Service.buyLotteries(buyer);
        showPurchasedLotteries(buyer.getPurchasedLotto());
    }

    private void gameResult() {
        List<Integer> winningNumbers = getInputWinningNumbers();
        int bonusNumber = getInputBonusNumbers(winningNumbers);
        Service.resultLotteries(buyer, winningNumbers, bonusNumber);
        OutputMessage.showLottoResult(buyer.getResultRank());
        OutputMessage.showYield(Service.getYield(buyer));
    }

    private int getInputPurchaseAmount() {
        try {
            InputMessage.inputPurchaseAmount();
            String input = Console.readLine();
            Validation.validateInputIsNumber(input);
            int purchaseAmount = Util.stringToInt(input);
            Validation.validateDivisibleNumber(purchaseAmount, PURCHASE_AMOUNT_UNIT);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            return getInputPurchaseAmount();
        }
    }

    private void showPurchasedLotteries(List<Lotto> lotteries) {
        OutputMessage.purchasedLotto(lotteries.size());
        lotteries.forEach(lotto -> OutputMessage.showLottoNumbers(lotto.getNumbers()));
    }

    private List<Integer> getInputWinningNumbers() {
        try {
            InputMessage.inputWinningNumbers();
            List<String> inputNumbers = Util.splitInputNumbers(Console.readLine());
            Validation.validateListNumeric(inputNumbers);
            
            List<Integer> winningNumbers = Util.stringListToIntegerList(inputNumbers);
            Validation.validateListSize(winningNumbers, LOTTO_SIZE);
            Validation.validateListNumbersInRange(winningNumbers, LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER);
            Validation.validateListDuplication(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            return getInputWinningNumbers();
        }
    }

    private int getInputBonusNumbers(List<Integer> winningNumbers) {
        try {
            InputMessage.inputBonusNumber();
            String input = Console.readLine();
            Validation.validateInputIsNumber(input);

            int bonusNumber = Util.stringToInt(input);
            Validation.validateNumberInRange(bonusNumber, LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER);
            Validation.validateNumberInList(winningNumbers, bonusNumber);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            return getInputBonusNumbers(winningNumbers);
        }
    }
}