package lotto.domain;

import java.util.List;

public class Lotto {
    // 변수
    private final List<Integer> numbers;

    // 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateTest(numbers);
        this.numbers = numbers;
    }

    // 번호가 6개인지 검사하는 메서드
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public void duplicateTest(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = i+1; j <numbers.size(); j++) {
                if(numbers.get(i).equals(numbers.get(j))){
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return "[" + numbers.get(0) +","+ numbers.get(1) +","+ numbers.get(2) +","+ numbers.get(3) +","+ numbers.get(4) +","+ numbers.get(5)  +"]";

    }

    public List<Integer> getNumbers(){return this.numbers;}
}
