package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import model.Bonus;
import model.Lotto;
import model.Money;
import model.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSizeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 넘은 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateLottoLimitationData")
    void createLottoByOverLimitationTest(List<Integer> test) {
        assertThatThrownBy(() -> new Lotto(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> generateLottoLimitationData() {
        return Stream.of(Arrays.asList(1, 2, 3, 4, 5, -1),
                Arrays.asList(1, 2, 3, 4, 5, 46),
                Arrays.asList(1, 2, 3, 4, 5, 0));
    }

    @DisplayName("금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createMoneyByUndividedTest() {
        assertThatThrownBy(() -> new Money("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 0 이하인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void createMoneyByNonPositiveTest(String test) {
        assertThatThrownBy(() -> new Money(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createMoneyByStringTest() {
        assertThatThrownBy(() -> new Money("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있는 경우 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumberTest() {
        assertThatThrownBy(() -> new Winning("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinningByStringTest() {
        assertThatThrownBy(() -> new Winning("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void createWinningByWrongSizeTest(String test) {
        assertThatThrownBy(() -> new Winning(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위를 넘은 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,-3"})
    void createWinningByOverLimitationTest(String test) {
        assertThatThrownBy(() -> new Winning(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusByStringTest() {
        Winning winning = new Winning("1,2,3,4,5,6");
        assertThatThrownBy(() -> new Bonus("1a", winning))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위를 넘은 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "46"})
    void createBonusByOverLimitationTest(String test) {
        Winning winning = new Winning("1,2,3,4,5,6");
        assertThatThrownBy(() -> new Bonus(test, winning))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumberTest() {
        Winning winning = new Winning("1,2,3,4,5,6");
        assertThatThrownBy(() -> new Bonus("1", winning))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또와 당첨 번호 및 보너스 번호와의 맞는 갯수 확인")
    @ParameterizedTest
    @MethodSource("generateLottoCheckData")
    void checkLottoMatchingTest(List<Integer> test, int testRank) {
        Lotto lotto = new Lotto(test);
        Winning winning = new Winning("1,2,3,4,5,6");
        Bonus bonus = new Bonus("7", winning);
        assertThat(lotto.getResult(winning, bonus)).isEqualTo(testRank);
    }

    static Stream<Arguments> generateLottoCheckData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 2),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), 5),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), 6));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateYieldTest() {
        Money money = new Money("10000");
        assertThat(money.getYield(678)).isEqualTo("6.8%");
    }
}