package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_TO_PICK = 6;

    public static List<Lotto> buyLottoTickets(int lottoPurchaseAmount){
        return IntStream.range(0, lottoPurchaseAmount)
                .mapToObj(i -> generateLottoNumbers())
                .toList();
    }

    public static Lotto generateLottoNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_TO_PICK)
                        .stream()
                        .sorted()
                        .toList();
        return new Lotto(numbers);
    }
}
