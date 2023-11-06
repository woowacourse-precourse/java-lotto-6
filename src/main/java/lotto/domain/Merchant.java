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
        // TODO: 가격 검증. 돈을 받고 확인하는 것은 상인이기 때문에 이곳에서 검사하는 것이 적당하다고 생각했다.
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
