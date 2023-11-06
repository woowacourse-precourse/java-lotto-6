package lotto.io;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IOOperationTest {

    @Test
    void 가격이_1000원_단위로_나누어_떨어지지_않을_시_예외_리턴() {
        assertThatThrownBy(() -> {
            IOOperation.priceCorrect(10001);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_6개의_중복_발견_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> {
            IOOperation.winningNotDuplicated(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호들과_보너스_번호_중복_발견_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 5;

        assertThatThrownBy(() -> {
            IOOperation.winningAndBonusNotDuplicated(winningNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_입력_시_로또_개수_리턴() {
        assertThat(IOOperation.numberOfLotto(12000)).isEqualTo(12);
    }

    @Test
    void 당첨_번호_6개_및_보너스_번호_범위_초과_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        Integer bonusNumber = 50;

        assertThatThrownBy(() -> {
            IOOperation.numbersInRange(winningNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
