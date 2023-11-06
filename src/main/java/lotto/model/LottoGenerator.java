package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.InputPriceValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final Integer START_INDEX = 0;
    private static final Integer DIVIDE_BY = 1000;
    public LottoGenerator() {
    }
    public static Lottos generate(String price) {
        InputPriceValidator.validatePrice(price);
        Integer priceInt = Integer.parseInt(price);
        List<LottoInfo> randomLottosList = getLottos(priceInt);
        return new Lottos(randomLottosList);
    }

    private static List<LottoInfo> getLottos(Integer priceInt) {
        return IntStream.range(START_INDEX, priceInt / DIVIDE_BY).mapToObj(i -> generateLotto()).collect(Collectors.toList());
    }


    private static LottoInfo generateLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE);
        return new LottoInfo(new Lotto(sortingNumbers(numbers)));
    }
    private static List<Integer> sortingNumbers(List<Integer> numbers){
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
