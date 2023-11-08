package lotto;

import util.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.NumberValidator.isValidNumber;

public class LottoGenerator {

    public static final int LIMIT_NUMBER_COUNT = 6;
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_PRICE = 1000;
    private static final LottoGenerator lottoGenerator = new LottoGenerator();

    private LottoGenerator(){}

    public static LottoGenerator getInstance() {
        return lottoGenerator;
    }

    public int getMaxPurchasableCount(int money){
        return money/LOTTO_PRICE;
    }
    private Lotto issueLotto(List<Integer> numbers){
        isValidNumber(numbers);
        return new Lotto(numbers);
    }

    public List<Lotto> issueLottos(int time){
        return Stream.generate(
                ()-> issueLotto(
                        orderList(generateRandomNumberList())
                ))
                .limit(time)
                .collect(Collectors.toList());
    }

    public List<Integer> orderList(List<Integer> numbers){
        List<Integer> orderNumbers = new ArrayList<>(numbers);
        Collections.sort(orderNumbers);
        return orderNumbers;
    }

    public List<Integer> generateRandomNumberList(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, LIMIT_NUMBER_COUNT);
    }
}
