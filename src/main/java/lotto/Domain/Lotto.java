package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        dupulicationCheck(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    public static void bonusdupulicationCheck(List<Integer> answerNumbers, int bonusNumber) {
        if (answerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }


    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void dupulicationCheck(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if(numbers.get(i).equals(numbers.get(i+1))){
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> createLottoRandomNumber() {
        final List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
