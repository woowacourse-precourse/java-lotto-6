package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoGame;

public class InputValidator {
    public static boolean isNumber(String inputValue) {
        return inputValue.matches(LottoGame.REGEX);
    }
    public static boolean isCorrectCount(int length) {
        return length == LottoGame.LOTTO_NUMBER_COUNT;
    }

    public static boolean isCorrectNumber(int lottoNumber) {
        return lottoNumber >= LottoGame.LOTTO_MIN_NUMBER && lottoNumber <= LottoGame.LOTTO_MAX_NUMBER;
    }

    public static boolean isDuplicateNumberForString(List<String> lottoNumbers) {
        Set<String> deduplicateNumbers = new HashSet<>(lottoNumbers);
        return lottoNumbers.size() != deduplicateNumbers.size();
    }

    public static boolean isDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> deduplicateNumbers = new HashSet<>(lottoNumbers);
        return lottoNumbers.size() != deduplicateNumbers.size();
    }
}
