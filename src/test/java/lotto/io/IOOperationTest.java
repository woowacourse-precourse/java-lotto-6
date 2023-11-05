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
            IOOperation.isPriceCorrect(10001);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가격이_1000원_단위로_나누어_떨어질_시_true_리턴() {
        assertThat(IOOperation.isPriceCorrect(20000)).isTrue();
    }

    @Test
    void 당첨_번호_6개의_중복_발견_시_예외_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> {
            IOOperation.isWinningNumberNotDuplicated(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_6개_중복_없을_시_true_리턴() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(IOOperation.isWinningNumberNotDuplicated(winningNumbers)).isTrue();
    }

    @Test
    void 금액_입력_시_로또_개수_리턴() {
        assertThat(IOOperation.numberOfLotto(12000)).isEqualTo(12);
    }
}
