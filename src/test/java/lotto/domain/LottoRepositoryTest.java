package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRepositoryTest {
    private LottoRepository lottoRepository =new LottoRepository();
    @DisplayName("Lotto 저장 로직")
    @Test
    void saveLotto(){
        Lotto lottoElement = new Lotto(List.of(1,2,3,4,5,6));
        lottoRepository.addOne(lottoElement);
        assertThat(lottoRepository.getLottoRepository().get(0)).isEqualTo(lottoElement);
    }

    @Test
    public void testAddResult() {
        // Add some LottoPrize results
        lottoRepository.addResult(LottoPrize.FIRST);
        lottoRepository.addResult(LottoPrize.SECOND);

        // Check if the counts are updated correctly
        assertEquals(1, (int) lottoRepository.getLottoResult().get(LottoPrize.FIRST));
        assertEquals(1, (int) lottoRepository.getLottoResult().get(LottoPrize.SECOND));
    }
}
