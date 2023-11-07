package lotto.repository;

import lotto.domain.Lotto;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottoes = new ArrayList<>();

    public LottoDto createLotto() {
        Lotto createdLotto = new Lotto();
        save(createdLotto);
        return new LottoDto(createdLotto.getNumbers());
    }

    private void save(Lotto lotto) {
        lottoes.add(lotto);
    }
}
