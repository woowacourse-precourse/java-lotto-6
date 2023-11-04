package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoGeneratorService {
    public List<Lotto> myLottos(int price);
}
