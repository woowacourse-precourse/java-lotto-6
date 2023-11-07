package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRepositoryTest {
    @DisplayName("Lotto 저장 로직")
    @Test
    void saveLotto(){
        List<Lotto> lottos = new ArrayList<>();
        Lotto lottoElement = new Lotto(List.of(1,2,3,4,5,6));
        lottos.add(lottoElement);
        LottoRepository testRepository = new LottoRepository(lottos);
        assertThat(testRepository.getLottoRepository().get(0)).isEqualTo(lottoElement);
    }
}
