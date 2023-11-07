package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultAnalyzerTest {
    @DisplayName("당첨 번호와 몇 개 일치하는지 확인")
    @ParameterizedTest(name = "당첨 번호: {0}, 구매한 로또 번호: {1}, 예상 일치 개수: {2}")
    @MethodSource("matchCase")
    public void 당첨_번호_일치_확인(List<Integer> winningNumbers, List<Integer> purchasedNumbers, int expectedMatchCount) {
        // given
        LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
        LottoPaper purchasedLottoPaper = new LottoPaper(purchasedNumbers);

        // when
        int matchCount = lottoResultAnalyzer.calculateMatchCount(purchasedLottoPaper, winningNumbers);

        // then
        assertEquals(expectedMatchCount, matchCount);
    }

    @DisplayName("당첨 번호 일치 개수를 로또 용지에 단일 입력 확인")
    @ParameterizedTest(name = "당첨 번호: {0}, 구매한 로또 번호: {1}, 예상 일치 개수: {2}")
    @MethodSource("matchCase")
    public void 당첨_번호_일치_개수_단일_입력(List<Integer> winningNumbers, List<Integer> purchasedNumbers, int expectedMatchCount) {
        // given
        LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
        LottoPaper purchasedLottoPaper = new LottoPaper(purchasedNumbers);

        // when
        lottoResultAnalyzer.writeResultToLottoPaper(purchasedLottoPaper, winningNumbers);

        // then
        assertEquals(expectedMatchCount, purchasedLottoPaper.getMatchingCount());
    }

    @DisplayName("당첨 번호 일치 개수를 로또 용지에 복수 입력 확인")
    @ParameterizedTest(name = "당첨 번호: {0}, 구매한 로또 번호: {1}, 예상 일치 개수: {2}")
    @MethodSource("matchCase")
    public void 당첨_번호_일치_개수_복수_입력(List<Integer> winningNumbers, List<Integer> purchasedNumbers, int expectedMatchCount) {
        // given
        List<LottoPaper> purchasedLottoPapers = new ArrayList<>();
        LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
        purchasedLottoPapers.add(new LottoPaper(purchasedNumbers));
        purchasedLottoPapers.add(new LottoPaper(purchasedNumbers));

        // when
        lottoResultAnalyzer.writeResultToLottoPapers(purchasedLottoPapers, winningNumbers);

        // then
        assertThat(purchasedLottoPapers)
                .allMatch(paper -> paper.getMatchingCount() == expectedMatchCount);
    }

    static Stream<Arguments> matchCase() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(4, 5, 6, 7, 8, 9),
                        3
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(10, 11, 12, 13, 14, 15),
                        0
                )
        );
    }
}
