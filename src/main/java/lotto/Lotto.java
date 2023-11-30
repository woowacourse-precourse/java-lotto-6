package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    // 로또 번호 6 개 저장 리스트
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        printNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }

        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void printNumbers() {
        for(int i = 0 ; i < numbers.size(); i++) {
            if(i == 0) System.out.print("[");
            System.out.print(numbers.get(i));
            if(i == 5) {
                System.out.println("]");
            } else {
                System.out.print(", ");
            }
        }
    }

    public double compare(List<Integer> winning_num, Integer bonus_num) {
        double count = 0;

        for(int a = 0; a < 6; a++) {
            if(winning_num.get(a) == bonus_num) {
                count += 0.5;
            }
        }

        for(int i =0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(Objects.equals(numbers.get(i), winning_num.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}
