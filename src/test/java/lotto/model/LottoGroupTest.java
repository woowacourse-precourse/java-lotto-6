package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGroupTest {

    @Test
    void 구매_가능한_개수만큼_로또를_생성한다() {
        NumberGenerator numberGenerator = (min, max, size) -> List.of(1, 2, 3, 4, 5, 6);
        PurchasableLottoCount purchasableLottoCount = PurchasableLottoCount.from(2);

        LottoGroup lottoGroup = LottoGroup.create(purchasableLottoCount, numberGenerator);

        assertThat(lottoGroup.getPurchasedLottos())
                .hasSize(2);
    }

    @Test
    void 로또_그룹에서는_동일한_번호들로_구성된_로또들을_가질_수_있다() {
        NumberGenerator numberGenerator = (min, max, size) -> List.of(1, 2, 3, 4, 5, 6);
        PurchasableLottoCount purchasableLottoCount = PurchasableLottoCount.from(3);
        LottoGroup expectedLottoGroup = new LottoGroup(List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 6))
        ));

        LottoGroup lottoGroup = LottoGroup.create(purchasableLottoCount, numberGenerator);

        assertThat(lottoGroup).usingRecursiveComparison()
                .isEqualTo(expectedLottoGroup);
    }

    @ParameterizedTest
    @MethodSource("totalPrizesDataProvider")
    void 로또_그룹에서_우승번호와_보너스번호와_각각_비교하여_전체_상품결과를_계산한다(
            WinningCombination winningCombination, LottoGroup lottoGroup, PrizeSummary expectedPrizeSummary) {
        PrizeSummary actualPrizeSummary = lottoGroup.generatePrizeSummary(winningCombination);

        assertThat(actualPrizeSummary).usingRecursiveComparison()
                .isEqualTo(expectedPrizeSummary);
    }

    @Test
    void 로또_그룹에서_우승자번호와_보너스번호를_각각_비교할여_상품을_계산할때는_로또_안의_로또번호_순서는_상관없다() {
        WinningCombination winningCombination = WinningCombination.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.from(7)
        );
        LottoGroup lottoGroup = createLottoGroup(
                Lotto.from(List.of(6, 5, 4, 3, 2, 1))
        );
        PrizeSummary expectedPrizeSummary = PrizeSummary.from(Map.of(
                LottoPrize.FIRST_PRIZE, 1L
        ));

        PrizeSummary actualPrizeSummary = lottoGroup.generatePrizeSummary(winningCombination);

        assertThat(actualPrizeSummary).usingRecursiveComparison()
                .isEqualTo(expectedPrizeSummary);
    }

    private LottoGroup createLottoGroup(Lotto... lottos) {
        return new LottoGroup(List.of(lottos));
    }

    @Test
    void 외부로부터_받은_로또_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        List<Lotto> modifiableLottos = new ArrayList<>(List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12)))
        );
        LottoGroup protectedLottoGroup = createLottoGroup(modifiableLottos);
        LottoGroup expectedLottoGroup = createLottoGroup(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12))
        );

        modifiableLottos.clear();

        assertThat(protectedLottoGroup).usingRecursiveComparison()
                .isEqualTo(expectedLottoGroup);
    }

    private LottoGroup createLottoGroup(List<Lotto> lottos) {
        return new LottoGroup(lottos);
    }

    @Test
    void 외부로_반환된_로또_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        LottoGroup protectedLottoGroup = createLottoGroup(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12))
        );
        List<Lotto> modifiableLottos = protectedLottoGroup.getPurchasedLottos();
        LottoGroup expectedLottoGroup = createLottoGroup(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12))
        );

        modifiableLottos.clear();

        assertThat(protectedLottoGroup).usingRecursiveComparison()
                .isEqualTo(expectedLottoGroup);
    }

    private static Stream<Arguments> totalPrizesDataProvider() {
        return Stream.of(
                Arguments.of(
                        WinningCombination.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.from(7)),
                        new LottoGroup(List.of(
                                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),
                                Lotto.from(List.of(1, 2, 3, 4, 5, 8)),
                                Lotto.from(List.of(1, 2, 3, 4, 8, 9)),
                                Lotto.from(List.of(1, 2, 3, 7, 8, 9)),
                                Lotto.from(List.of(8, 9, 10, 11, 12, 13))
                        )),
                        PrizeSummary.from(Map.of(
                                LottoPrize.FIRST_PRIZE, 1L,
                                LottoPrize.SECOND_PRIZE, 1L,
                                LottoPrize.THIRD_PRIZE, 1L,
                                LottoPrize.FOURTH_PRIZE, 1L,
                                LottoPrize.FIFTH_PRIZE, 1L,
                                LottoPrize.NOTHING, 1L
                        ))
                )
        );
    }
}
