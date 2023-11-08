package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.repository.LottoRepository;
import lotto.util.enumerator.LottoRank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    @AfterEach
    void cleanUp() {
        LottoRepository.clear();
    }

    @DisplayName("당첨 로또와 로또를 비교하고, 당첨 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateLotties")
    void compareWinningLottoWithLotto(List<Integer> lotto, List<Integer> winning, int bonus) {
        // given
        Lotto issuedLotto = new Lotto(lotto);
        LottoRepository.add(issuedLotto);
        WinningLotto issuedWinningLotto = new WinningLotto(new WinningNumber(winning), new BonusNumber(bonus));

        // when
        List<LottoRank> rankResults = issuedWinningLotto.compare();
        LottoResult lottoResult = new LottoResult(rankResults);

        // then
        Assertions.assertEquals(LottoRank.FOURTH, lottoResult.getRankResults().get(0));
    }

    static Stream<Arguments> generateLotties() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9, 45), Arrays.asList(1, 2, 3, 5, 7, 11), 44),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 12, 40), Arrays.asList(1, 2, 3, 4, 12, 40), 10)
        );
    }
}