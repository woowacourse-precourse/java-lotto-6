package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.number.LottoNumber;

public class Lotto {

    private final List<LottoNumber> numbers = new ArrayList<>();

    public static Lotto forUserLotto(List<LottoNumber> lottoNumbers){
        return new Lotto(lottoNumbers);
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
    @Override
    public String toString(){
        return this.numbers.toString();
    }

}
