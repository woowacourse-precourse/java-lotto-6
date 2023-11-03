package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.utils.FixedNumberGenerator;
import lotto.utils.NumberGenerator;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    @DisplayName("로또 구매 수량 검증 테스트")
    @Test
    void buyLottoTest() {
        LottoService lottoService = new LottoService();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int lottoQuantity = 3;

        List<Lotto> lottos = lottoService.buyLottos(randomNumberGenerator, lottoQuantity);

        assertThat(lottos.size()).isEqualTo(lottoQuantity);
    }

    @DisplayName("1등 당첨 검증 테스트")
    @ParameterizedTest
    @MethodSource("fixedNumberGenerator")
    void winnerNumberMatchTest(List<Integer> fixedGeneratedNumbers) {
        LottoService lottoService = new LottoService();
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(fixedGeneratedNumbers);
        int lottoQuantity = 1;
        List<Lotto> lottos = lottoService.buyLottos(fixedNumberGenerator, lottoQuantity);

        List<Integer> winnerNumbers = fixedNumberGenerator().findFirst().get();
        int bonusNumber = 7;

        List<Result> results = lottoService.matchLotto(lottos, winnerNumbers, bonusNumber);

        for (Result result : results) {
            assertThat(result.getRank()).isEqualTo(Rank.FIRST);
        }
    }

    @DisplayName("2등 당첨 검증 테스트")
    @ParameterizedTest
    @MethodSource("fixedNumberGenerator")
    void secondRankTest(List<Integer> fixedGeneratedNumbers) {
        LottoService lottoService = new LottoService();
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(fixedGeneratedNumbers);
        int lottoQuantity = 1;
        List<Lotto> lottos = lottoService.buyLottos(fixedNumberGenerator, lottoQuantity);

        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 10);
        int bonusNumber = 6;

        List<Result> results = lottoService.matchLotto(lottos, winnerNumbers, bonusNumber);

        for (Result result : results) {
            assertThat(result.getRank()).isEqualTo(Rank.SECOND);
        }

    }

    static Stream<List<Integer>> fixedNumberGenerator() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

}