package lotto.model;

import static lotto.enumerate.ConfigInteger.LOTTO_END_NUMBER;
import static lotto.enumerate.ConfigInteger.LOTTO_START_NUMBER;
import static lotto.enumerate.ConfigString.REPLACE_REPLACEMENT;
import static lotto.enumerate.ConfigString.REPLACE_TARGET;
import static lotto.enumerate.ConfigString.SPLIT_REGEX;
import static lotto.enumerate.ErrorCode.BONUS_NUMBER_IS_NOT_INTEGER;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_BONUS_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.enumerate.ErrorCode.WINNING_NUMBER_IS_NOT_INTEGER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.record.LottoNumberRecord;

public class WinningNumber {

    private final LottoNumbers numbers;
    private final BonusNumber bonusNumber;

    public WinningNumber(String numbers, String bonusNumber) {
        List<Integer> convertedNumbers = convert(numbers);

        this.numbers = new LottoNumbers(convertedNumbers);
        this.bonusNumber = new BonusNumber(this.numbers, bonusNumber);
    }



    private static String[] getSplit(String numbers) {
        return numbers.replace(REPLACE_TARGET.getString(), REPLACE_REPLACEMENT.getString()).split(SPLIT_REGEX.getString());
    }

    private List<Integer> convert(String numbers) {
        numberValid(numbers);
        return Arrays.stream(getSplit(numbers)).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }

    private void numberValid(String numbers) {
        if (Arrays.stream(getSplit(numbers)).anyMatch(this::notInt)) {
            exceptionCodeThrow(WINNING_NUMBER_IS_NOT_INTEGER);
        }
    }

    private boolean notInt(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public int countMatchingNumbers(LottoNumberRecord lottoNumberRecord) {
        int matches = 0;
        for (int number : lottoNumberRecord.numbers()) {
            matches = getMatches(number, matches);
        }
        return matches;
    }

    private int getMatches(int number, int matches) {
        if (numbers.getLottoNumbers().contains(number)) {
            matches++;
        }
        return matches;
    }

    public boolean hasMatchingBonusNumber(LottoNumberRecord lottoNumberRecord) {
        return lottoNumberRecord.numbers().contains(bonusNumber.getBonusNumber());
    }

}
