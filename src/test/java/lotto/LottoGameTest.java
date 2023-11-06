package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private static final int FIRST_NUM = 1;
    private static final int LAST_NUM = 6;

    @DisplayName("로또 번호 생성 시 중복 생기지 않는지 테스트")
    @Test
    void generatedNumberDuplicatedTest() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            LottoGame.drawNumber(new RandomNumGenerator(1, 6), lotto);
        }
        assertThat(lotto.stream().distinct().count()).isEqualTo(lotto.size());
    }

    @DisplayName("로또 발급 시 예외 발생하지 않는지 테스트")
    @Test
    void generatedLottoSizeTest() {
        LottoGame lottoGame = new LottoGame(1);
        lottoGame.makeLotto(new RandomNumGenerator(FIRST_NUM, LAST_NUM));
    }

    @DisplayName("로또 개수가 구매 개수와 같은지 테스트")
    @Test
    void generatedNumOfLottosTest() {
        LottoGame lottoGame = new LottoGame(5);
        assertThat(lottoGame.makeLottos().count()).isEqualTo(5);
    }
}