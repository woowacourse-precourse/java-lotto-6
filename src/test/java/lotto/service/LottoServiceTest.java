package lotto.service;

import lotto.Lotto;
import lotto.LottoResult;
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

    @Test
    @DisplayName("성공적으로 로또를 비교 해야 한다.")
    public void 성공적으로_로또를_비교_해야_한다() {
        final String expectedResult = String.format(
                "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개\n" +
                        "총 수익률은 %.1f%%입니다.",
                1,
                0,
                0,
                0,
                0,
                500.0F
        );

        LottoRepository lottoRepository = mock(LottoRepository.class);
        LottoService lottoService = new LottoService(lottoRepository);
        Lotto lotto = new Lotto(List.of(1, 3, 5, 11, 22, 33));

        when(lottoRepository.findAll()).thenReturn(List.of(lotto));
        LottoResult lottoResult = lottoService.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lottoResult.toString()).isEqualTo(expectedResult);
    }

}
