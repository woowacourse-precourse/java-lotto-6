package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public interface LottoGeneratorService {
    List<Lotto> myLottos(String inputPrice);
}
