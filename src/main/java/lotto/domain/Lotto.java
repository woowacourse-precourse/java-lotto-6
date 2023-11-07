package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; //로또 번호(안스턴스)
    private static final int MIN_NIMBER = 1;//클래스 변수
    private static final int MAX_NUMBER = 45;//클래스 변수



    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    //validate:유효성 검사 컨벤션->예외처리 진행
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateOverlap(List<Integer> numbers){
        //로또 넘버 먼저 생성 하라 감
    }
}
