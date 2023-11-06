package lotto.service;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LottoServiceTest {

    @Test
    @DisplayName("성공적으로 로또를 구매 해야 한다.")
    public void 성공적으로_로또를_구매_해야_한다() {
        LottoRepository lottoRepository = mock(LottoRepository.class);
        LottoService lottoService = new LottoService(lottoRepository);

        List<Lotto> lottos = lottoService.purchaseLotto(8000L);

        assertThat(lottos).hasSize(8);
        verify(lottoRepository, times(1)).saveAll(any());
    }

}
