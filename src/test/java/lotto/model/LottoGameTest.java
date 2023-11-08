package lotto.model;

import lotto.constant.LottoValue;
import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 게임 테스트")
class LottoGameTest {
    LottoGame lottoGame = new LottoGame();

    @ParameterizedTest(name = "[{index}] 가격 만큼 로또 장 수 발행 : {0}")
    @ValueSource(ints = {1000, 5000, 100000, 1000000})
    void 가격_만큼_로또_장_수_발행(int num) {
        // given
        Price price = new Price(num);

        // when
        UserLottos userLottos = lottoGame.generateAllLottos(price);

        // then
        assertThat(userLottos.getLottos().size()).isEqualTo(price.getPrice() / LottoValue.PRICE_PER_PIECE.getValue());
    }

    @DisplayName("{index} 당첨 통계 계산")
    @Test
    void 당첨_통계_계산() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        UserLottos userLottos = new UserLottos(Arrays.asList(lotto1, lotto2, lotto3));

        Lotto winnig = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(7);
        LottoWinning lottoWinning = new LottoWinning(winnig, bonus);

        // when
        Map<Integer, Integer> rankMap = lottoGame.calcWinningStatistics(userLottos, lottoWinning);

        // then
        assertThat(rankMap.get(1)).isEqualTo(1);
        assertThat(rankMap.get(2)).isEqualTo(1);
        assertThat(rankMap.get(4)).isEqualTo(1);
    }

}