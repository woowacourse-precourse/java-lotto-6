package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinLottoTest {

    WinLotto winLotto;

    @BeforeEach
    void setUp() {
        winLotto = WinLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.getInstance(7));
    }

    @Test
    void create() {
        assertNotNull(winLotto);
    }

    @DisplayName("우승로또 번호는 보너스 번호와 중복될 수 없다.")
    @Test
    void createWithInvalidBonusNumber() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = LottoNumber.getInstance(1);

        assertThatThrownBy(() -> WinLotto.of(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("당첨 로또는 일반 로또와 비교하고 일치하는 갯수를 반환한다.")
    @MethodSource("lottoNumbersAsCount")
    void countMatchedNumber(Lotto lotto, Rank expected) {
        assertThat(winLotto.calculateRank(lotto)).isEqualTo(expected);
    }

    static Stream<Arguments> lottoNumbersAsCount() {
        return Stream.of(
                Arguments.arguments(Lotto.from(List.of(40, 41, 42, 43, 44, 45)), Rank.NOTHING),
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 40, 41, 42)), Rank.FIFTH),
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 4, 41, 42)), Rank.FOURTH),
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 4, 5, 42)), Rank.THIRD),
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST)
        );
    }

}
