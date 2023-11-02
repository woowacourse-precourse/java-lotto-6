package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public String getLottoNumber() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
    // 유저 인풋, 로또 번호 모두 이 모델을 활용하기
    // 로또는 리스트를 파라미터로 받아 생성함
    // 다른 도메인에서 인풋 받은 것을 나누어 여기로 보내줌
    // 여기서 확인 하는 예외 사항
    // 1. 개수
    // 2. 중복 숫자
}
