package lotto.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {
    @Test
    @DisplayName("Lotto가 정상적으로 저장되는지 테스트")
    void lottoSaveTest(){
        LottoRepository lottoRepository = new LottoRepository();

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        List<Lotto> lottos = List.of(lotto1, lotto2);
        lottoRepository.save(lottos);

        List<Lotto> savingLottos = lottoRepository.getMyLotto();

        assertEquals(lottos.size(), savingLottos.size());
        assertEquals(lottos.get(0), savingLottos.get(0));
        assertEquals(lottos.get(1), savingLottos.get(1));
    }
}