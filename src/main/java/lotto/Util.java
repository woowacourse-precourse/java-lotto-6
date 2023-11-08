package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {
    private final static int LOTTO_UNIT_PRICE = 1000;
    int countPurchasedLotto(int totalPrice){
        int count = totalPrice/LOTTO_UNIT_PRICE;
        return count;
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
