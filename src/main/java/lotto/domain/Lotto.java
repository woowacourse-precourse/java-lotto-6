package lotto.domain;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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
    
    public List<Integer> getNumbers() {
    	return numbers;
    }

    public void generateLottoNumbers() {
    	List<Integer> generateNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    	Collections.sort(generateNumbers); // 오름차순 정리
    	numbers.clear();
    	numbers.addAll(generateNumbers);
    }
    
  
}
