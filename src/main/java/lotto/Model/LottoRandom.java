package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandom {
    public String[] getBuyLotto(int count) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> a;
        String[] list = new String[count];
        for(int i = 0; i < count; i++){
            numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            a = numbers.subList(6 * i, 6 * (i + 1));
            Collections.sort(a);
            list[i] = a.toString();
            System.out.println(list[i]);
        }
        return list;
    }
//    public String[] getBuyLotto(int count) {
//        String[] numbers = new String[count];
//        for(int i = 0; i < count; i++){
//            List list = (Randoms.pickUniqueNumbersInRange(1, 45, 6));
//            Collections.sort(list);
//            numbers[i] = list.toString();
//            System.out.println(numbers[i]);
//        }
//        return numbers;
//    }
}
