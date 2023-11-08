package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoGeneratorService {
    List<Lotto> myLottos(String inputPrice);
}
