package lotto.fixture;

import java.util.List;
import lotto.model.Lotto;

public class LottoFixture {

    public static Lotto createLotto(final List<Integer> lotto) {
        return Lotto.fromNumbers(lotto);
    }

    public static Lotto createLotto(final String lottoNumbers){
        return Lotto.fromInput(lottoNumbers);
    }
}
