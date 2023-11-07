package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import camp.nextstep.edu.missionutils.Randoms;

public class AutoLottoNumber {
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;

    public static List<Integer> putOutNumber() {
        List<Integer> autoNumber = new ArrayList<>();
        addNumber(autoNumber);
        sortNumber(autoNumber);
        return autoNumber;
    }

    private static void addNumber(List<Integer> numbers) {
        while (numbers.size() < LOTTO_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private static void sortNumber(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
