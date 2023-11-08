package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.RandomNumbers;
import lotto.validator.InputValidator;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validator.InputValidator.checkUserInputIsIntegerNOutOfRange;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Controller {
    private static LottoResults lottoResults;
    private static RandomNumbers randomNumbers;
    private static Lotto lotto;
    private static Bonus bonus;

    public Controller(){
        createLottoResults();
        createRandomNumbers();
        createLotto();
        createBonus();
    }

    public void run() {
        checkLottoResults();
        printResults();
    }

    private static void createLottoResults() {
        printGetPurchasePriceInput();
        while(true) {
            try {
                lottoResults = new LottoResults(getPurchasePriceInput());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void createRandomNumbers() {
        int LottoPapers = lottoResults.getLottoPapers();
        randomNumbers = new RandomNumbers(LottoPapers);
        printPurchasedLottoPapers(LottoPapers);
        for (int i = 0; i < LottoPapers; i++) {
            printPurchasedEachLottoResult(randomNumbers.getEachLottoNumbers(i));
        }
    }

    private static void createLotto() {
        printGetWinningNumberInput();
        while (true) {
            try {
                String numbers = getWinningNumberInput();
                InputValidator.checkUserInputIsNull(numbers);
                List<String> tmpLotto = Arrays.asList(numbers.split(","));
                checkUserInputIsIntegerNOutOfRange(tmpLotto);
                lotto = new Lotto(tmpLotto.stream()
                        .mapToInt(Integer::parseInt)
                        .boxed().collect(Collectors.toList()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void createBonus() {
        printGetBonusNumberInput();
        while (true) {
            try {
                bonus = new Bonus(getBonusNumberInput());
                checkLottoContainBonus(bonus.getBonus());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkLottoResults() {
        for(int i=0;i<lottoResults.getLottoPapers();i++) {
            lottoResults.updateEachLottoResult(
                    lotto.countMatchEachLotto(randomNumbers.getEachLottoNumbers(i)),
                    bonus.checkMatchEachLotto(randomNumbers.getEachLottoNumbers(i))
            );
        }
    }

    private void printResults() {
        printLottoResults(lottoResults.getLottoResults());
        printProfit(lottoResults.getRateOfProfit());
    }

    public static void checkLottoContainBonus(Integer bonus) throws IllegalArgumentException {
        if (lotto.checkLottoContainBonus(bonus)) {
            throw new IllegalArgumentException("[ERROR] 이미 로또 번호에 포함된 보너스 번호입니다.");
        }
    }

}
