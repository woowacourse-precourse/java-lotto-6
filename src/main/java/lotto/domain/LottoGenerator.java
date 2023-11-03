package lotto.domain;

import lotto.exception.LottoNumberException;

public interface LottoGenerator {
    Lotto generate() throws LottoNumberException;

    Lottos generate(int count) throws LottoNumberException;

}
