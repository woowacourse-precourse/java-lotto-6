package lotto;

import java.util.List;

//구매한 로또 개수만큼 객체를 새로 생성해준다! - 붕어빵 느낌
public class Lotto {
    private final List<Integer> numbers;
    //접근 제어자 변경 불가능
    //필드(인스턴스 변수) 추가 불가능

    //생성자로서, 랜덤으로 뽑힌 번호 6개 ArrayList를 인자로 받아들이기
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호가 생성되었습니다.");
        }
    }

    // TODO: 추가 기능 구현

    //number가 private으로 접근이 제어되었기 때문에, getter 메소드 구현
    public List<Integer> getLottoNumbers() {
        return numbers;
    }


}

