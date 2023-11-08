package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int CORRECT_LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        if(hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException();
        }

        if(hasInvalidNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto createLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Lotto> buyLotto(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<count; i++) {
            lottos.add(Lotto.createLotto());
        }
        return lottos;
    }

    public boolean hasDuplicatedNumbers(List<Integer> numbers){
        Long count = numbers.stream()
                .distinct()
                .count();

        return count != CORRECT_LOTTO_SIZE;
    }

    public boolean hasInvalidNumbers(List<Integer> numbers){
        Long count = numbers.stream()
                .filter(number -> 1 <= number && number <= 45)
                .count();

        return count != CORRECT_LOTTO_SIZE;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

}
