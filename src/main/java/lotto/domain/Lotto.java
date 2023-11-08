package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static int START_NUMBER = 1;
    private static int LAST_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicates(numbers);
        checkLottoNumberInBound(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 6개가 아닙니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void checkForDuplicates(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 리스트에 중복된 숫자가 있습니다.");
            }
        }
    }

    private void checkLottoNumberInBound(List<Integer> oneLotto){
        for (int oneLottoNumber : oneLotto) {
            if (oneLottoNumber < START_NUMBER || oneLottoNumber > LAST_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
