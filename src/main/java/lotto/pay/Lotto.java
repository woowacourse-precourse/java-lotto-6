package lotto.pay;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.number.LottoNumber;

public class Lotto {
    private final List<LottoNumber> numbers = new ArrayList<>();
    private static final int NUMBER_MAX_VALUE = 45;
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static Lotto auto(){
        return new Lotto(pickAutoNumbers());
    }

    public static Lotto raffle(List<LottoNumber> numbers){
        return new Lotto(numbers);
    }

    private Lotto(List<LottoNumber> numbers) {
        validateNumberSize(numbers);
        this.numbers.addAll(numbers);
    }

    private void validateNumberSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }


    private static List<LottoNumber> pickAutoNumbers(){
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE, LOTTO_NUMBERS_SIZE)
                .stream().map(LottoNumber::fromAutoLotto)
                .collect(Collectors.toList());
    }
}
