package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicationCheck(numbers);
        this.numbers = numbers;
    }

    public void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void rangeCheck(List<Integer> numbers){
        for (int num; numbers) { // 1~45 사이의 숫자인지 체크
            if (num < 1 || 45 < num) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void duplicationCheck(List<Integer> numbers){
        if (numbers.stream().distinct().count() < numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 선택할 수 없습니다.");
        }
    }
}