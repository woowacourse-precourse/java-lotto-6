package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    //1.임의의 숫자 리스트를 private list에 입력
    //  해당 매개변수가 list 타입이니 외부에서 돌려서 해당 숫자 입력
    //2.해당 로또 번호 출력
    // public Stirng printLotto() 해서 각 로또 번호 출력

}
