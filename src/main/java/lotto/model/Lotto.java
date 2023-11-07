package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicationNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]번호는 6개가 부여되야 합니다.");
        }
    }

    private void validateDuplicationNumber(List numbers) {
        boolean result = numbers.stream().distinct().count() <numbers.size();
        if(result){
            throw new IllegalArgumentException("[ERROR]당첨 번호와 중복되지 않는 값을 입력해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    public void printLottoNumbers(){
        System.out.println(numbers);
    }

    public List<Integer> getLottoNumbers(){
        return numbers;

    }
}
