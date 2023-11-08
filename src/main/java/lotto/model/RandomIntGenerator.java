package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.constants.ErrorMessage.ISNOTINTEGER;
import static lotto.model.constants.LottoInformation.BUY_PRICE;
import static lotto.model.constants.LottoInformation.COUNT_DIVISION;

public class RandomIntGenerator {
    private static final List<List<Integer>> numbers = new ArrayList<>();
    private static final LottoController lottoController = new LottoController();
    public RandomIntGenerator(){
    }
    public  void makeLottoNumber(Integer count){
        BUY_PRICE.setValue(count);
      IntStream.range(0,  count/COUNT_DIVISION.getValue())
              .forEach(i -> numbers.add(makeRandomNumber()));
    }

    public void isStr() {
        while(true){
            try{
                int number = lottoController.checkCount();
                makeLottoNumber(number);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(ISNOTINTEGER.getMessage());
            }
        }

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
