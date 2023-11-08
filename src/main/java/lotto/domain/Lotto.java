package lotto.domain;

import lotto.domain.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoValidator(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
//        numbers.sort(Comparator.naturalOrder());
    }

    public void showLottoNumber() {
        System.out.print("[");
        ArrayList<Integer> arrayList = new ArrayList<>(numbers);
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i ++) {
            System.out.print(arrayList.get(i));
            if (i != arrayList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public Integer compareLotto(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (lotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }
}
