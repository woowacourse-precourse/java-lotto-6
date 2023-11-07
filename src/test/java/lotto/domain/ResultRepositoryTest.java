package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultRepositoryTest {
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndResult")
    @DisplayName("구매한 로또의 등수를 판정한다.")
    void checkRank(List<Integer> numbers, Rank resultRank) {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(new ArrayList<>(numbers));
        ResultRepository resultRepository = new ResultRepository(winningLotto, lotto);
        assertThat(resultRepository.getRank()).isEqualTo(resultRank);
    }

    private static Stream<Arguments> provideLottoNumbersAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.First),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.Second),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), Rank.Third),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), Rank.None)
        );
    }
}
