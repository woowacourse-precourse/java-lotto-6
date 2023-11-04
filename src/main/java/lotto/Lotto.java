package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        dupulicationCheck(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void dupulicationCheck(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if(numbers.get(i).equals(numbers.get(i+1))){
                throw new IllegalArgumentException();
            }
        }
    }

    private void createLottoRandomNumber() {
        final List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        
    }
}
