package lotto.service;

import java.util.List;
import java.util.Comparator;

import static lotto.type.LottoProperty.LOTTO_MIN_NUMBER;
import static lotto.type.LottoProperty.LOTTO_MAX_NUMBER;
import static lotto.type.LottoProperty.LOTTO_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;

public class AutoLottoNumber {

    public static List<Integer> putOutNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                (LOTTO_MIN_NUMBER.getLottoProperty(), LOTTO_MAX_NUMBER.getLottoProperty(),
                        LOTTO_NUMBER_SIZE.getLottoProperty());
//      sortNumber(numbers);
        return numbers;
    }
    /* ApplicationTest에서 List.of으로 주어주는 바람에 작동시키면 오류가 뜸.
    private static void sortNumber(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
     */
}
