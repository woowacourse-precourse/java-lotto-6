package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.");
        }
    }


    List<Integer> generateSixRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    void sortRandomNumber(List<Integer> notSortedNumbers){
        Collections.sort(notSortedNumbers);
    }

    List<List<Integer>> makeLottoNumbersCollection(int count){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for(int i=0; i < count; i++){
            List<Integer> randomNumbers = generateSixRandomNumber();
            lottoNumbers.add(randomNumbers);
        }
        for(List<Integer> notSortedNumbers: lottoNumbers){
             sortRandomNumber(notSortedNumbers);
        }
        return lottoNumbers;
    }

}
