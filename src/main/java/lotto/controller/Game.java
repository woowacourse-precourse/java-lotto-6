package lotto.controller;

import static lotto.constants.ExceptionMessage.IS_DUPLICATE_BONUS_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constants.Rank;
import lotto.domain.Calculator;
import lotto.domain.Comparator;
import lotto.domain.Convertor;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningCount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private static final int THOUSAND_UNIT = 1000;
    private int purchaseAmount;
    private int bonusNumber;
    private double profitRate;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Map<Rank, Integer> winningResult;

    public void start() {
        createPurchaseAmount();
        int purchaseQuantity = purchaseAmount / THOUSAND_UNIT;
        createLottos(purchaseQuantity);
        OutputView.printPurchaseResult(lottos);
        createWinningNumbers();
        createBonusNumber();
        createWinningResult();
        createProfitRate();
        OutputView.printWinningResult(winningResult);
        OutputView.printProfitRate(profitRate);
    }

    private void createPurchaseAmount() {
        while (true) {
            try {
                purchaseAmount = InputView.askPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private void createLottos(int purchaseQuantity) {
        lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    private void createWinningNumbers() {
        while (true) {
            try {
                Lotto lotto = new Lotto(Convertor.convertToNumbers(InputView.askWinningNumbers()));
                winningNumbers = lotto.getNumbers();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private void createBonusNumber() {
        while (true) {
            try {
                bonusNumber = new Number(InputView.askBonusNumber()).getNumber();
                validateDuplicated();
                break;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private void createWinningResult() {
        List<WinningCount> winningCounts = createWinningCounts();
        winningResult = Calculator.classify(winningCounts);
    }

    private List<WinningCount> createWinningCounts() {
        return Comparator.compare(lottos, winningNumbers,
                bonusNumber);
    }

    private void createProfitRate() {
        profitRate = Calculator.calculateProfitRate(winningResult, purchaseAmount);
    }


    private void validateDuplicated() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(IS_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
