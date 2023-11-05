package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> buyLotto (int inputMoney){
        List<List<Integer>>randomLottoNumbers = new ArrayList<>();
        for(int i = 0; i < inputMoney/1000; i++){
            randomLottoNumbers.add(getRandomLottoNumbers(inputMoney/1000));
        }
        return randomLottoNumbers;
    }

    public List<Integer> getRandomLottoNumbers(int numberOfLotto){
        return (List<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
