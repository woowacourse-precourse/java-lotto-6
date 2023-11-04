package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_LIMIT_VALUE = 6;


    private LottoFactory() {
    }

    public static Lotto getLotto(){
        List<Integer> lottoNumbers = getLottoNumbers();
        return new Lotto(sortedAscending(lottoNumbers));
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_LIMIT_VALUE);
    }

    private static List<Integer> sortedAscending(List<Integer> numbers) {
        List<Integer> sortedNumber = getSortedNumber(numbers);
        if (isNotSort(numbers, sortedNumber)) {
            return sortedNumber;
        }
        return numbers;
    }

    private static boolean isNotSort(List<Integer> numbers, List<Integer> sortedNumber) {
        return !sortedNumber.equals(numbers);
    }

    private static List<Integer> getSortedNumber(List<Integer> numbers) {
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);

        return sortedLotto;
    }

    public static Lotto getLotto(List<Integer> numbers){
        validateSortedAscending(numbers);
        return new Lotto(numbers);
    }

    private static void validateSortedAscending(List<Integer> numbers) {
        List<Integer> sortedNumber = getSortedNumber(numbers);
        if (isNotSort(numbers,sortedNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_NOT_SORTED.getMessage());
        }
    }

}
