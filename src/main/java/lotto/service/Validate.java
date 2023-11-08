package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public void IsThousandFormat(int money) {
        while (money > 11) {
            if (money%1000 != 0) {
                System.out.println("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
                throw new IllegalArgumentException();
            }
            money /= 1000;
        }
    }

    public void IsDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void IsRightNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void IsRightRangeNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i) > 45) || (numbers.get(i) < 1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void IsSortedNumbers(List<Integer> numbers) {
        for (int i=0;i<numbers.size()-1;i++) {
            if (numbers.get(i) > numbers.get(i+1))
                throw new IllegalArgumentException();
        }
    }


}