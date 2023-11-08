package lotto.domain.util;

import static lotto.validation.LottoValidator.numbersStringToList;
import static lotto.validation.LottoValidator.validateBonusNumber;
import static lotto.validation.LottoValidator.validateLottoNumbers;
import static lotto.validation.LottoValidator.validateMoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public final class LottoParser {
    private LottoParser() {
    }

    public static int parseMoney(String moneyInput) {
        int parsedMoney = Integer.parseInt(moneyInput);
        validateMoney(parsedMoney);
        return parsedMoney;
    }

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        validateLottoNumbers(winningNumbers);
        return numbersStringToList(winningNumbers);
    }

    public static int parseBonusNumber(String bonusInput) {
        validateBonusNumber(bonusInput);
        return Integer.parseInt(bonusInput);
    }

    public static List<List<Integer>> parseLottoToInteger(List<Lotto> lottos) {
        List<List<Integer>> sortedLottosNumber = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> numbersCopy = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbersCopy);
            sortedLottosNumber.add(numbersCopy);
        }

        return sortedLottosNumber;
    }
}
