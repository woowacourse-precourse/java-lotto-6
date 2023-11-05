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

    public List<List<Integer>> buyLotto (String inputMoney){
        List<List<Integer>>randomLottoNumbers = new ArrayList<>();
        int numberOfLotto = Integer.parseInt(inputMoney)/1000;
        for(int i = 0; i < numberOfLotto; i++){
            randomLottoNumbers.add(getRandomLottoNumbers(numberOfLotto));
        }
        return randomLottoNumbers;
    }

    public List<Integer> getRandomLottoNumbers(int numberOfLotto){
        return (List<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
