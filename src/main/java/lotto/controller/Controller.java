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
import static lotto.view.InputView.*;
import static lotto.view.InputView.getBonusNumberInput;
import static lotto.view.OutputView.*;

public class Controller {
    private static LottoResults LottoResults;
    private static RandomNumbers RandomNumbers;
    private static Lotto Lotto;
    private static Bonus Bonus;

    public static void gameEngineStart() {
        printGetPurchasePriceInput();
        while(true) {
            try {
                LottoResults = new LottoResults(getPurchasePriceInput());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int LottoPapers = LottoResults.getLottoPapers();
        RandomNumbers = new RandomNumbers(LottoPapers);
        printPurchasedLottoPapers(LottoPapers);
        for (int i=0;i<LottoPapers;i++) {
            printPurchasedEachLottoResult(RandomNumbers.getEachLottoNumbers(i));
        }
    }

    public static void gameEngine() {
        printGetWinningNumberInput();
        while (true) {
            try {
                Lotto = new Lotto(splitToList(getWinningNumberInput()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        printGetBonusNumberInput();
        while (true) {
            try {
                Bonus = new Bonus(validateBonus(getBonusNumberInput()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for(int i=0;i<LottoResults.getLottoPapers();i++) {
            LottoResults.updateEachLottoResults(
                    Lotto.countMatchEachLotto(RandomNumbers.getEachLottoNumbers(i)),
                    Bonus.checkMatchEachLotto(RandomNumbers.getEachLottoNumbers(i))
            );
        }
    }

    public static void gameEnd() {
        printLottoResults(LottoResults.getLottoResults());
        printProfit(LottoResults.getRateOfProfit());
    }

    private static List<Integer> splitToList(String userInputLotto) {
        List<String> lotto = Arrays.asList(userInputLotto.split(","));
        InputValidator.checkUserInputLength(lotto,LOTTO_LENGTH);
        for(int i=0;i<LOTTO_LENGTH;i++) {
            InputValidator.checkUserInputIsInteger(lotto.get(i));
            InputValidator.checkUserInputOutOfRange(Integer.parseInt(lotto.get(i)),MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER);
        }
        return lotto.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    private static int validateBonus(String bonus) {
        InputValidator.checkUserInputIsInteger(bonus);
        int tmpBonus = Integer.parseInt(bonus);

        InputValidator.checkUserInputOutOfRange(tmpBonus,MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER);
        checkLottoContainBonus(tmpBonus);

        return tmpBonus;
    }

    public static void checkLottoContainBonus(int bonus) throws IllegalArgumentException {
        if (Lotto.checkLottoContainBonus(bonus)) {
            throw new IllegalArgumentException("[ERROR] 이미 로또 번호에 포함된 보너스 번호입니다.");
        }
    }

}
