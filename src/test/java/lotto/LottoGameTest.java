package lotto;

import static lotto.Constant.BUY_UNIT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {
    @DisplayName("로또 구매금액에 따른 구매개수를 반환해주는 기능.")
    @ParameterizedTest
    @ValueSource(longs = {1000,5000,0,100000,18000})
    void 로또_구매_개수(long buyCash){
        LottoGame lottoGame=new LottoGame();
        long expected=buyCash/BUY_UNIT;

        assertThat(lottoGame.getLottoAmount(buyCash)).isEqualTo(expected);
    }
}
