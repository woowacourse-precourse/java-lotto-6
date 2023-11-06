package lotto;

import static org.junit.jupiter.api.Assertions.fail;

import lotto.model.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {
    @DisplayName("수량에 맞는 로또 생성")
    @ParameterizedTest
    @ValueSource(ints = {10000, 8000, 1000})
    void MakeLottoIfMoneyInput(int input) {
        LottoGame lottogame = new LottoGame(input);

        lottogame.createLotto();

        if (lottogame.getLottoGames().size() != lottogame.getLottoNumber()) {
            fail();
        }
    }
}
