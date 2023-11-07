package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoModelTest {
    @DisplayName("로또 모델 테스트")
    @Test
    void testLottoPlaying() {
        LottoModel lottoModel = new LottoModel(
                List.of(
                        List.of(1, 2, 3, 40, 15, 16), // 3개 겹침
                        List.of(1, 2, 3, 4, 5, 6),    // 5개 겹침
                        List.of(1, 2, 3, 4, 5, 7),    // 모두 겹침
                        List.of(1, 2, 3, 4, 5, 10)    // 5개 + 보너스 넘버 겹침
                ),
                List.of(1, 2, 3, 4, 5, 7), 10
        );

        lottoModel.lottoPlaying();

        List<Integer> result = lottoModel.getResult();
        assertThat(result).containsExactly(1, 0, 1, 1, 1);
    }
}
