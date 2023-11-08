package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LotteryOfficeTest {

    @DisplayName("당첨결과가 옳게 반환되는지 확인한다")
    @ParameterizedTest
    @MethodSource("provideWinningsAndCount")
    void createWinningResult(
            List<Lotto> issuedLotto,
            WinningNumbers winningNumbers,
            Map<Rankings,Integer> expected) {

        LotteryOffice lotteryOffice = new LotteryOffice(issuedLotto, winningNumbers);

        assertThat(lotteryOffice.getWinningsAndCounts()).isEqualTo(expected);
    }

    static Stream<Arguments> provideWinningsAndCount() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,7)),
                                new Lotto(List.of(1,2,3,4,5,8)),
                                new Lotto(List.of(1,2,3,4,7,8)),
                                new Lotto(List.of(1,2,3,7,8,9))),
                        new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)),7),
                        Map.of(
                                Rankings.FIRST_PLACE, 1,
                                Rankings.SECOND_PLACE,1,
                                Rankings.THIRD_PLACE, 1,
                                Rankings.FOURTH_PLACE, 1,
                                Rankings.FIFTH_PLACE, 1)
                )
        );
    }
}