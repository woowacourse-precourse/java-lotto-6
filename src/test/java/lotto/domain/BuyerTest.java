package lotto.domain;

import lotto.domain.constants.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BuyerTest {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @DisplayName("구매금액에 따른 로또 갯수 확인")
    @Test
    void buyLottoSize() {
        int amount = 2000;
        int lottoCount = new Amount(amount).buyCount();

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto(lottoNumberGenerator.pickUniqueNumbers()));
        }

        Lottos lottos = new Lottos(lotto);
        Buyer buyer = new Buyer(lottos);

        Assertions.assertThat(buyer.lottoCount()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("로또 결과 확인")
    @MethodSource("buyLottos")
    void lottoResult(Lottos lottos, BonusNumber bonusNumber) {
        Buyer buyer = new Buyer(lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonusNumber);

        Map<LottoRank, Integer> result = buyer.lottoResult(winningLotto);

        Assertions.assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoRank.SECOND)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoRank.FIFTH)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoRank.LOSE)).isEqualTo(1);
    }


    static Stream<Arguments> buyLottos() {
        return Stream.of(
                Arguments.arguments(new Lottos(
                                new ArrayList<>(
                                        Arrays.asList(
                                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                                new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                                                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                                                new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                                                new Lotto(List.of(1, 2, 7, 9, 10, 11))
                                        )
                                )
                        )
                , new BonusNumber(9))
        );
    }
}
