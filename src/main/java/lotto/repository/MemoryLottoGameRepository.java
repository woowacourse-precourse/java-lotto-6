package lotto.repository;


import lotto.domain.IndexModel;
import lotto.domain.entity.LottoGame;

public class MemoryLottoGameRepository extends MemoryRepository<LottoGame> {

    @Override
    public Long save(IndexModel object) {
        return null;
    }
}
