package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumber(numbers);
        loopCheckNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 숫자 6개를 입력해야 합니다.");
        }
    }

    private void loopCheckNumberRange(List<Integer> numbers){
        for(int number : numbers){
            checkNumberRange(number);
        }
    }

    private void checkNumberRange(int number){
        if(number<1 || number>45){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkSameNumber(List<Integer> numbers){
        boolean hasSameNumber =false;

        hasSameNumber = numbers.size() != numbers.stream().distinct().count();
        if (hasSameNumber) {
            throw new IllegalArgumentException("당첨 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
