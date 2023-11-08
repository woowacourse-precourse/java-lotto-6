package lotto.domain.util;

import static lotto.domain.validation.Validator.numbersStringToList;
import static lotto.domain.validation.Validator.validateBonusNumber;
import static lotto.domain.validation.Validator.validateLottoNumbers;
import static lotto.domain.validation.Validator.validateMoney;

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
