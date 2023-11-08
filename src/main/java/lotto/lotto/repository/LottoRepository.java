package lotto.lotto.repository;

import lotto.lotto.dto.LottoDto;

import java.util.List;

public interface LottoRepository {

    void saveLotto(List<Integer> numbers);

    LottoDto findOne(int idx);

    List<LottoDto> findAll();
}
