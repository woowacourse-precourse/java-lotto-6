package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckerTest {
    @Test
    void 가격이_1000원_단위로_나누어_떨어지지_않을_시_예외_리턴() {
        assertThatThrownBy(() -> {
            Checker.priceCorrect(10001);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_6개의_중복_발견_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> {
            Checker.winningNotDuplicated(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호들과_보너스_번호_중복_발견_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 5;

        assertThatThrownBy(() -> {
            Checker.winningAndBonusNotDuplicated(winningNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_6개_범위_초과_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> {
            Checker.winningInRange(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_범위_초과_시_예외_리턴() {
        Integer bonusNumber = 99;

        assertThatThrownBy(() -> {
            Checker.bonusInRange(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
