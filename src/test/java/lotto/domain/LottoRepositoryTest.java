package lotto.domain;

import java.util.List;
import lotto.service.LottoFactoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRepositoryTest {

    LottoRepository lottoRepository = LottoRepository.getInstance();
    LottoFactoryService lottoFactoryService = new LottoFactoryService();
    @DisplayName("로또가 잘 저장되었는지 확인")
    @Test
    void lottoSaveTest() {
        //given
        Lotto lotto = lottoFactoryService.createRandomLotto();
        //when
        lottoRepository.save(lotto);
        List<Lotto> lottos = lottoRepository.showAllLottos();
        //then

        Assertions.assertThat(lottos).contains(lotto);

    }


}
