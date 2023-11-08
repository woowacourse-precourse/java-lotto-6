package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public int lottosize;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void generateLottoSize(String price) {
        Integer priceint = Integer.valueOf(price);
        lottosize=priceint/1000;
    }

    // TODO: 추가 기능 구현
}
