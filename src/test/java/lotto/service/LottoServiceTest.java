package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWithBonus;
import lotto.util.generator.LottoGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoServiceTest {
    private static Lotto lotto = LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

    private static Stream<Arguments> userLottoAndGeneratedLotto() {
        return Stream.of(
                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)), LottoResult.SIX),

                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 10)),
                        LottoResult.FIVE_AND_BONUS),

                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 45)), LottoResult.FIVE),

                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 3, 4, 44, 45)), LottoResult.FOUR),

                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 3, 43, 44, 45)), LottoResult.THREE)

        );
    }

    @ParameterizedTest(name = "결과 : {3}")
    @MethodSource("userLottoAndGeneratedLotto")
    void 비교하기(Lotto userLotto, Bonus userBonus, Lotto generatedLotto, LottoResult result) {
        LottoWithBonus user = LottoWithBonus.of(userLotto, userBonus);

        LottoResult lottoResult = LottoService.compareLottoWithBonus(user, generatedLotto);

        assertThat(lottoResult).isEqualTo(result);
    }

    private static Stream<Arguments> generateNonLottoResult() {
        return Stream.of(
                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 2, 42, 43, 44, 45)), LottoResult.TWO),

                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(1, 41, 42, 43, 44, 45)), LottoResult.ONE),

                Arguments.of(lotto, Bonus.from(10, lotto),
                        LottoGenerator.generateLotto(() -> Arrays.asList(40, 41, 42, 43, 44, 45)), LottoResult.ZERO)
        );
    }

    @ParameterizedTest(name = "결과 : {3}")
    @MethodSource("generateNonLottoResult")
    void 당첨_통계에_포함되지_못하는_경우(Lotto userLotto, Bonus userBonus, Lotto generatedLotto, LottoResult result) {
        LottoWithBonus user = LottoWithBonus.of(userLotto, userBonus);

        LottoResult lottoResult = LottoService.compareLottoWithBonus(user, generatedLotto);

        assertThat(lottoResult).isEqualTo(result);
    }

}
