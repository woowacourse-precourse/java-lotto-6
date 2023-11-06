package lotto;

import java.util.List;

public class Lotto {
    public static int PRICE = 1000;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 하실 수 없습니다.");
        }
    }

    public boolean containLottoNumber(LottoNumber lottoNumber){
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(LottoNumber lottoNumber : numbers){
            result.append(lottoNumber).append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("]");
        return result.toString();
    }
}
