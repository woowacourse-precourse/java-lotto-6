package lotto.Domain;

import lotto.Domain.Constants.LottoRules;
import lotto.View.Constants.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        verifyLotto(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRules.TOTAL_BALL_NUMBERS.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    // TODO: 추가 기능 구현

    public void verifyLotto (final List<Integer> numbers){
        validate(numbers);
        verifyRange(numbers);
        verifySame(numbers);
    }

    public void verifyRange (final List<Integer> numbers) {
        if(!numbers.stream()
                .allMatch(x -> x >= LottoRules.MIN_LOTTO_BALL_RANGE.getNumber()
                        &&
                        x <= LottoRules.MAX_LOTTO_BALL_RANGE.getNumber()))
        {
            System.out.println(ErrorMessage.OUT_OF_NUMBER_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void verifySame(final List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            System.out.println(ErrorMessage.SAME_NUMBER_EXIST.getMessage());
            throw new IllegalArgumentException();
        }
    }

}
