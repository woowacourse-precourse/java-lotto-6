package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void beforeEach() {
        Lotto lotto1 = LottoGenerator.createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoGenerator.createLotto(List.of(4, 5, 6, 7, 8, 9));
        lottos = new Lottos(List.of(lotto1, lotto2));
    }

    @DisplayName("로또 목록 문자열로 가져오기 테스트")
    @Test
    void getLottosNumbersToString() {
        String result = "[1, 2, 3, 4, 5, 6]\n[4, 5, 6, 7, 8, 9]\n";

        assertThat(lottos.getLottosNumbers()).isEqualTo(result);
    }
}