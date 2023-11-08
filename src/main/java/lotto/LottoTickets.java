package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    public static List<List<Integer>> makeLottoNums(int amount) {
        List<List<Integer>> userLottoList = new ArrayList<>();

        for (int i = 0; i < amount / 1000; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            userLottoList.add(numbers);
            System.out.println(numbers);
        }

        System.out.println();
        return userLottoList;
    }
}
