package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    // 로또 번호 6 개 저장 리스트
    private final List<Integer> numbers;
    private Result result;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
        printNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
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

    public double compare(List<Integer> winning_num, int bonus_num) {
        double count = 0;
        for(int i = 0; i < 6; i++) {
            if(numbers.get(i) == bonus_num) {
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
