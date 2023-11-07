package lotto.model;

import lotto.message.ExceotionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength();
        validateDuplicateLotto();
        this.numbers = numbers;
    }

    private void validateLottoLength(   ) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceotionMessage.NOT_6_NUMBER.getMessage());
        }
    }

    private void validateDuplicateLotto(){
        int length = numbers.size();

        Set<Integer> checkDuplicate = new HashSet<>(numbers);

        if(length != checkDuplicate.size()){
            throw new IllegalArgumentException(ExceotionMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
