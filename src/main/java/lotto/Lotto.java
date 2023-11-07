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
    
//    Lotto 객체에 다른 Lotto 객체를 인자로 받아 일치하는 번호와 갯수를 반환하는 메서드 추가
//    당첨 번호와 사용자의 번호가 얼마나 일치하는지 확인 가능
    public int countMatchedNumbers(Lotto other) {
        return (int) numbers.stream()
            .filter(other.numbers::contains)
            .count();
    }
    
    @Override
    public String toString() {
        return numbers.toString();
    }
}
