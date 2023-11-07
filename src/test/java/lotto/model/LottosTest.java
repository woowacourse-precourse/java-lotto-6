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

    @DisplayName("가지고 있는 로또 전체와 당첨 로또를 비교하여 결과를 가져온다.")
    @Test
    void createLottosAndCompareWithWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(LottoGenerator.createLotto(List.of(3, 4, 5, 6, 7, 8)),
                new BonusNumber(9));

        String result = """
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 0개
                """;

        assertThat(lottos.compareLottos(winningLotto).getResult()).isEqualTo(result);
    }
}