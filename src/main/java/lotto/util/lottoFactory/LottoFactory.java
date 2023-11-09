package lotto.util.lottoFactory;

import lotto.Lotto;

import java.util.List;

public interface LottoFactory {
    Lotto generateLotto();
    Lotto generateLotto(List<Integer> numbers);
}
