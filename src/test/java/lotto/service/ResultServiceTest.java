package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.constants.Ranks;
import lotto.domain.Bonus;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultServiceTest {

    private ResultService resultService;

    @BeforeEach
    void initTest() {
        resultService = new ResultService();
    }

    @ParameterizedTest
    @DisplayName("결과를 비교하여 가져올 수 있다.")
    @MethodSource("fetchValidatedBonusTestValue")
    void fetchValidatedBonusTest(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumbers, int costNumber,
                                 Ranks except) {
        List<Lotto> lottosCreator = new ArrayList<>();
        lottosCreator.add(new Lotto(numbers));
        Lottos lottos = new Lottos(lottosCreator);
        Cost cost = new Cost(costNumber);

        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Bonus bonus = new Bonus(bonusNumbers, winningLotto);
        Result result = resultService.creatResult(lottos, bonus, winningLotto);
        Assertions.assertThat(result.calculateProfitPercent(cost)).isEqualTo(except.getPrize() / cost.getCost() * 100);
    }

    private static Stream<Arguments> fetchValidatedBonusTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 9, 1000, Ranks.SIX_MATCH),
                Arguments.of(List.of(30, 41, 42, 43, 44, 29), List.of(30, 41, 42, 43, 44, 45), 29, 1000,
                        Ranks.FIVE_MATCH_BONUS)
        );
    }
}
