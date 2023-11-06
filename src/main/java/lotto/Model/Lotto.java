package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> forCheck = new HashSet<>();

        for(int number : numbers){
            if(!forCheck.add(number)){
                throw new IllegalArgumentException();
            }
        }
    }
}

// 로또 클래스 생성자로 인티저 리스트를 받고 유효성 검사 메서드를 실행.
// 유효성 검사는 넘겨받은 인티저 리스트의 사이즈가 6인지 체크.

// 그렇다면 여기에 리스트에 중복인 숫자가 있는지 아닌지 체크하는 메서드.
// 보너스넘버가 리스트와 겹치는지 체크하는 메서드.

// 요구사항
// 넘버즈 프라이빗 풀지 말기
// 인스턴스 변수 추가 금지 -> 즉 보너스넘버 체크는 불가능?
// 패키지 변경 가능