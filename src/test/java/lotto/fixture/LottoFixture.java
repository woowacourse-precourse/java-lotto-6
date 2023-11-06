package lotto.fixture;

import java.util.List;
import lotto.model.Lotto;

public class LottoFixture {

    public static Lotto create(final List<Integer> lotto) {
        return Lotto.fromNumbers(lotto);
    }

    public static Lotto create(final String lottoNumbers){
        return Lotto.fromInput(lottoNumbers);
    }
}
