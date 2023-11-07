package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Merchant {

    private Merchant() {  }

    public static Merchant of() {
        return new Merchant();
    }

    public List<Lotto> getLotteryNumberWith(int price) {
        List<Lotto> result = new ArrayList<>();
        int count = price / 1000;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            result.add(getOneLotteryNumber());
        }
        return result;
    }

    private Lotto getOneLotteryNumber() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

}
