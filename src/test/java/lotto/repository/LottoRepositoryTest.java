package lotto.repository;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LottoRepositoryTest {

    @Nested
    @DisplayName("저장 테스트")
    class SaveTest {

        @Test
        @DisplayName("성공적으로 단일 Lotto를 저장해야 한다")
        public void 성공적으로_단일_Lotto를_저장해야_한다() {
            LottoRepository lottoRepository = new LottoRepository();
            Lotto lotto = mock(Lotto.class);
            Lotto otherLotto = mock(Lotto.class);

            lottoRepository.save(lotto);
            lottoRepository.save(otherLotto);
            List<Lotto> lottos = lottoRepository.findAll();

            assertThat(lottos).hasSize(2);

            lottoRepository.clear();
        }

        @Test
        @DisplayName("성공적으로 다수의 Lotto를 저장해야 한다")
        public void 성공적으로_다수의_Lotto를_저장해야_한다() {
            LottoRepository lottoRepository = new LottoRepository();
            Lotto lotto = mock(Lotto.class);
            Lotto otherLotto = mock(Lotto.class);

            lottoRepository.saveAll(List.of(lotto, otherLotto));
            List<Lotto> lottos = lottoRepository.findAll();

            assertThat(lottos).hasSize(2);

            lottoRepository.clear();
        }

    }

    @Nested
    @DisplayName("조회 테스트")
    class FindTest {

        @Test
        @DisplayName("성공적으로 저장된 모든 로또들을 조회 해야 한다")
        public void 성공적으로_저장된_모든_로또들을_조회_해야_한다() {
            LottoRepository lottoRepository = new LottoRepository();
            Lotto lotto = mock(Lotto.class);
            Lotto otherLotto = mock(Lotto.class);

            lottoRepository.saveAll(List.of(lotto, otherLotto));
            List<Lotto> lottos = lottoRepository.findAll();

            assertThat(lottos).hasSize(2);
            assertThat(lottos).containsExactly(lotto, otherLotto);

            lottoRepository.clear();
        }
    }

}
