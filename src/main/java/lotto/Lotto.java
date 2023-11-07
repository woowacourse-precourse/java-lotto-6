package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final static int LOTTO_UNIT_PRICE = 1000;
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

    int countPurchasedLotto(int totalPrice){
        int count = totalPrice/LOTTO_UNIT_PRICE;
        return count;
    }

    List<Integer> generateSixRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    List<Integer> sortRandomNumber(List<Integer> notSortedNumbers){
        Collections.sort(notSortedNumbers);
        return notSortedNumbers;
    }

    List<List<Integer>> makeLottoNumbersCollection(int count){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for(int i=0; i < count; i++){
            List<Integer> randomNumbers = generateSixRandomNumber();
            lottoNumbers.add(randomNumbers);
        }
        return lottoNumbers;
    }
}
