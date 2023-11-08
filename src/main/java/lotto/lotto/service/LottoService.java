package lotto.lotto.service;

import lotto.lotto.dto.LottoDto;

import java.util.List;

public interface LottoService {

    void createLottos(int count);

    List<LottoDto> getLottos();

    List<Integer> generateNumbers();
}
