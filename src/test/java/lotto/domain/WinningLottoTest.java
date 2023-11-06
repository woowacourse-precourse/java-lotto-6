package lotto.domain;

import lotto.domain.constants.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    public void setUp() {
        this.winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );
    }

    @ParameterizedTest
    @DisplayName("구입한 로또가 당첨 로또와 몇개 맞는지 테스트")
    @MethodSource("buyLottos")
    void buyLottoCompareWinningLotto(Lotto buyLotto, LottoRank lottoRank) {
        Assertions.assertThat(winningLotto.lottoResult(buyLotto)).isEqualTo(lottoRank);
    }

    static Stream<Arguments> buyLottos() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.FIRST),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRank.SECOND),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 9)), LottoRank.THIRD),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 9, 10)), LottoRank.FOURTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 9, 10, 11)), LottoRank.FIFTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 7, 9, 10, 11)), LottoRank.LOSE)
        );
    }
}
