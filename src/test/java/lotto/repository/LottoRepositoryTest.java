package lotto.repository;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoRepositoryTest {

    @BeforeEach
    void clear() {
        LottoRepository.getInstance().clear();
    }

    @DisplayName("로또 목록을 입력하면 저장한다.")
    @Test
    void Given_Lottos_When_SaveAll_Then_IsEqualCount() throws Exception {
        // Given
        LottoRepository instance = LottoRepository.getInstance();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        // When
        instance.saveAll(lottos);

        // Then
        int savedCount = instance.count();
        assertThat(savedCount).isEqualTo(lottos.size());
    }

    @DisplayName("저장된 로또 목록을 모두 반환한다.")
    @Test
    void getAllSavedLottos() throws Exception {
        // Given
        LottoRepository repository = LottoRepository.getInstance();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        repository.saveAll(lottos);

        // When
        List<Lotto> savedLottos = repository.getAll();

        // Then
        assertThat(savedLottos).isEqualTo(lottos);
    }
}
