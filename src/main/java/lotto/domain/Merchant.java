package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merchant {

    private Merchant() {  }

    public static Merchant of() {
        return new Merchant();
    }

    public List<Lotto> getLotteryNumberWith(int price) {
        List<Lotto> result = new ArrayList<>();
        int count = price / 1000;
        for (int i = 0; i < count; i++) {
            result.add(getOneLotteryNumber());
        }
        return result;
    }

    private Lotto getOneLotteryNumber() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 45; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        List<Integer> numbers = numberList.subList(0, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
