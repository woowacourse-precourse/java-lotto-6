package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @Test
    void 보너스번호_당첨번호_중복_예외처리_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(2);
        assertThat(lotto.contains(bonusNumber)).isTrue();
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateInput")
    void 당첨번호갯수_보너스포함여부_등수_계산_테스트(List<Integer> lottoNumbers, int bonus, String result) {
        Lotto winningLotto = new Lotto(lottoNumbers);
        BonusNumber bonusNumber = new BonusNumber(bonus);
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(winningNumber.calculateRank(lotto).name()).isEqualTo(result);
    }

    @Test
    void 등수_카운트_테스트() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        Rank rank = winningNumber.calculateRank(lotto);
        assertThat(rank.getCount()).isEqualTo(1);
    }

    private static Stream<Arguments> generateInput() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), 10, "FIRST"),
                Arguments.of(List.of(1,2,3,4,5,7), 6, "SECOND"),
                Arguments.of(List.of(1,2,3,4,5,7), 10, "THIRD"),
                Arguments.of(List.of(1,2,3,4,7,8), 10, "FOURTH"),
                Arguments.of(List.of(1,2,3,7,8,9), 10, "FIFTH"),
                Arguments.of(List.of(10,11,12,13,14,15), 16, "FAIL")
        );
    }
}
