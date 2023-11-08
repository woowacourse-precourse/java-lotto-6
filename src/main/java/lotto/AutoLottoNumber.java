package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import static lotto.LottoProperty.LOTTO_MIN_NUMBER;
import static lotto.LottoProperty.LOTTO_MAX_NUMBER;
import static lotto.LottoProperty.LOTTO_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;

public class AutoLottoNumber {

    public static List<Integer> putOutNumber() {
        List<Integer> autoNumber = new ArrayList<>();
        addNumber(autoNumber);
        sortNumber(autoNumber);
        return autoNumber;
    }

    private static void addNumber(List<Integer> numbers) {
        while (numbers.size() < LOTTO_NUMBER_SIZE.getLottoProperty()) {
            int randomNumber = Randoms.pickNumberInRange
                    (LOTTO_MIN_NUMBER.getLottoProperty(), LOTTO_MAX_NUMBER.getLottoProperty());
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private static void sortNumber(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
