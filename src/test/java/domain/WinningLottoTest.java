package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.InvalidLottoNumberRangeException;
import exception.InvalidLottoSizeException;
import exception.NumberDuplicateException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("6개 넘는 값이 입력될 시 예외 발생")
    @Test
    void createLottoOverSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @DisplayName("1 ~ 45 밖의 숫자가 입력될 시 예외 발생")
    @Test
    void createLottoWithWrongRangeNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 45, 33, 70)))
                .isInstanceOf(InvalidLottoNumberRangeException.class);
    }

    @DisplayName("보너스 넘버가 중복될 경우 예외 발생")
    @Test
    void createWinningLottoWithDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(NumberDuplicateException.class);
    }
}
