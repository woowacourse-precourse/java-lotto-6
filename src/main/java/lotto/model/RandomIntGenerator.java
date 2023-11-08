package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.LottoInformation.BUY_PRICE;
import static lotto.model.LottoInformation.COUNT_DIVISION;

public class RandomIntGenerator {
    private static final List<List<Integer>> numbers = new ArrayList<>();

    public RandomIntGenerator(){
    }
    public  void makeLottoNumber(int count){
        BUY_PRICE.setValue(count);
      IntStream.range(0, count/COUNT_DIVISION.getValue())
              .forEach(i -> numbers.add(makeRandomNumber()));
//        System.out.println(numbers);



    }

    private List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public List<List<Integer>> getLottoNumber() {
        return numbers;
    }

}
