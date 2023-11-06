package lotto.repositoryTest;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.MemoryRandomLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class MemoryLottoRepositoryTest {
    private MemoryRandomLottoRepository memoryLottoRepository;

    @BeforeEach
    void setUp() {
        memoryLottoRepository = new MemoryRandomLottoRepository();
    }

    @DisplayName("메모리 저장소에 저장하고 불러오는 테스트")
    @Test
    void saveAndGetLottoListTest() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 3, 5, 7, 9, 11));

        //when
        memoryLottoRepository.save(lotto1);
        memoryLottoRepository.save(lotto2);
        List<Lotto> lottoList = memoryLottoRepository.getLottoList();

        //then
        assertThat(lottoList).contains(lotto1,lotto2);
    }
}
