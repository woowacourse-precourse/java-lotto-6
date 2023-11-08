package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    private Lotto winningNumbers;
    private static final int BONUS = 45;
    private static final int MONEY = 3000;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3", "1,2,7,8,9,10:2",
            "1,7,8,9,10,11:1", "7,8,9,10,11,12:0"}, delimiter = ':')
    void 로또_번호_비교(String numbers, int expectedCount) {
        int compare = winningNumbers.compare(
                Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
        assertThat(compare).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST_PLACE", "1,2,3,4,5,45:SECOND_PLACE", "1,2,3,4,5,7:THIRD_PLACE",
            "1,2,3,4,7,8:FOURTH_PLACE", "1,2,3,7,8,9:FIFTH_PLACE",
            "1,2,7,8,9,10:LAST_PLACE"}, delimiter = ':')
    void 로또_번호_비교_결과(String numbers, Rank expectedRank) {
        Rank rank = winningNumbers.compareResult(
                Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList()), BONUS);
        assertThat(rank).isEqualTo(expectedRank);
    }

    @Test
    void 로또_전체_비교_결과() {
        List<Integer> result = winningNumbers.allCompare(
                Arrays.asList(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 45)), BONUS);
        assertThat(result).isEqualTo(List.of(1, 1, 0, 0, 0, 0));
    }

    @Test
    void 수익률_계산() {
        String profit = Lotto.profitCalc(List.of(0, 0, 1, 0, 0, 0), MONEY);
        assertThat(profit).isEqualTo("50000.0");
    }
}