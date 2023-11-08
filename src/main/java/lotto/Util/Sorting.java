package lotto.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static List<Integer> LottoNum(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
