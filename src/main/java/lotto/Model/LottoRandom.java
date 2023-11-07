package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandom {
    public String[] getBuyLotto(int count) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> sliceList;
        String[] list = new String[count];
        for (int i = 0; i < count; i++) {
            numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            sliceList = numbers.subList(6 * i, 6 * (i + 1));
            Collections.sort(sliceList);
            list[i] = sliceList.toString();
            System.out.println(list[i]);
        }
        return list;
    }
}
