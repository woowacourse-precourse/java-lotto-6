package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.enums.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 통계 결과 테스트")
    @Test
    void testGeneratePrizeResults() {
        EnumMap<LottoPrize, Integer> prizes = new EnumMap<>(LottoPrize.class);
        prizes.put(LottoPrize.FIRST, 1);
        prizes.put(LottoPrize.FOURTH, 2);
        String result = LottoGameResult.generatePrizeResults(prizes);

        String firstPrize = "6개 일치 (2,000,000,000원) - 1개";
        String foruthPrize = "4개 일치 (50,000원) - 2개";

        assertTrue(result.contains(firstPrize));
        assertTrue(result.contains(foruthPrize));
    }
}