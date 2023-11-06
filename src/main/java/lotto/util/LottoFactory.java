package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoRule;
import lotto.domain.lotto.Lotto;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto createLotto(){
        List<Integer> lottoNumbers = getLottoNumbers();
        return new Lotto(sortedAscending(lottoNumbers));
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                LottoRule.STANDARD.getStartNumber(),
                LottoRule.STANDARD.getLastNumber(),
                LottoRule.STANDARD.getLottoSize());
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

    public static Lotto createLotto(List<Integer> numbers){
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
