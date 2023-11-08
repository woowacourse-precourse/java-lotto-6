package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumber {

    private static final int Start_Number = 1;
    private static final int Final_Number = 45;
    private static final int Number_Range = 6;

    public List<Integer> getNumbers() {

        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Start_Number, Final_Number, Number_Range));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
