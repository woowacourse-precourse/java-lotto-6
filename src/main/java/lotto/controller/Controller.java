package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.RandomNumbers;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Constants.*;
import static lotto.validator.InputValidator.checkUserInputIsIntegerNOutOfRange;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Controller {
    private static LottoResults LottoResults;
    private static RandomNumbers RandomNumbers;
    private static Lotto Lotto;
    private static Bonus Bonus;

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
                LottoResults = new LottoResults(getPurchasePriceInput());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void createRandomNumbers() {
        int LottoPapers = LottoResults.getLottoPapers();
        RandomNumbers = new RandomNumbers(LottoPapers);
        printPurchasedLottoPapers(LottoPapers);
        for (int i = 0; i < LottoPapers; i++) {
            printPurchasedEachLottoResult(RandomNumbers.getEachLottoNumbers(i));
        }
    }

    private static void createLotto() {
        printGetWinningNumberInput();
        while (true) {
            try {
                String numbers = getWinningNumberInput();
                List<String> lotto = Arrays.asList(numbers.split(","));
                checkUserInputIsIntegerNOutOfRange(lotto);
                Lotto = new Lotto(lotto.stream()
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
                Bonus = new Bonus(getBonusNumberInput());
                checkLottoContainBonus(Bonus.getBonus());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkLottoResults() {
        for(int i=0;i<LottoResults.getLottoPapers();i++) {
            LottoResults.updateEachLottoResults(
                    Lotto.countMatchEachLotto(RandomNumbers.getEachLottoNumbers(i)),
                    Bonus.checkMatchEachLotto(RandomNumbers.getEachLottoNumbers(i))
            );
        }
    }

    private void printResults() {
        printLottoResults(LottoResults.getLottoResults());
        printProfit(LottoResults.getRateOfProfit());
    }

    public static void checkLottoContainBonus(Integer bonus) throws IllegalArgumentException {
        if (Lotto.checkLottoContainBonus(bonus)) {
            throw new IllegalArgumentException("[ERROR] 이미 로또 번호에 포함된 보너스 번호입니다.");
        }
    }

}
