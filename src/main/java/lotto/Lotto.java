package lotto;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    public Lotto buy(List<LottoNumber> numbers, int amount){
        validatePaymentAmount(amount);
        return new Lotto(numbers);
    }

    public Lotto raffle(List<LottoNumber> numbers){
        return new Lotto(numbers);
    }

    private Lotto(List<LottoNumber> numbers) {
        validateNumberSize(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePaymentAmount(int amount){
        if (amount != LOTTO_PRICE){
            throw new IllegalArgumentException();
        }
    }


}
