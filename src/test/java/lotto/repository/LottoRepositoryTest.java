package lotto.repository;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LottoRepositoryTest {

    private LottoRepository lottoRepository;
    private Lotto lotto;
    private Lotto otherLotto;

    @BeforeEach
    void setUp() {
        lottoRepository = new LottoRepository();
        lotto = mock(Lotto.class);
        otherLotto = mock(Lotto.class);
    }

    @AfterEach
    void clear() {
        lottoRepository.clear();
    }

    @Nested
    @DisplayName("저장 테스트")
    class SaveTest {

        @Test
        @DisplayName("성공적으로 단일 Lotto를 저장해야 한다")
        public void 성공적으로_단일_Lotto를_저장해야_한다() {
            lottoRepository.save(lotto);
            lottoRepository.save(otherLotto);
            List<Lotto> lottos = lottoRepository.findAll();

            assertThat(lottos).hasSize(2);

            lottoRepository.clear();
        }

        @Test
        @DisplayName("성공적으로 다수의 Lotto를 저장해야 한다")
        public void 성공적으로_다수의_Lotto를_저장해야_한다() {
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
            lottoRepository.saveAll(List.of(lotto, otherLotto));
            List<Lotto> lottos = lottoRepository.findAll();

            assertThat(lottos).hasSize(2);
            assertThat(lottos).containsExactly(lotto, otherLotto);

            lottoRepository.clear();
        }
    }

    @Nested
    @DisplayName("삭제 테스트")
    class clearTest {

        @Test
        @DisplayName("성공적으로 데이터베이스를 삭제 해야 한다")
        public void 성공적으로_데이터베이스를_삭제_해야_한다() {
            lottoRepository.saveAll(List.of(lotto, otherLotto));
            lottoRepository.clear();
            List<Lotto> lottos = lottoRepository.findAll();

            assertThat(lottos).isEmpty();
        }
    }

}
