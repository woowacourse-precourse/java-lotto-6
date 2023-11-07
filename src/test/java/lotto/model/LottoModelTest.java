package lotto.model;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class LottoModelTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void testCreateLotto() {
        Lotto lotto = Lotto.createLotto();
        assertNotNull(lotto);
        assertNotNull(lotto.getNumbers());
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    @DisplayName("로또 번호가 중복이면 예외가 발생한다.")
    void testCreateLottoByDuplicatedNumber() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 번호 범위 외 숫자가 존재하면 예외가 발생한다.")
    void testCreateLottoByNumberOutOfRange() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50))) // 50은 범위 밖의 숫자
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 6개 미만일 때 예외가 발생한다.")
    void testCreateLottoByInsufficientNumbers() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5))) // 5개의 번호
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 7개 이상일 때 예외가 발생한다.")
    void testCreateLottoByExcessiveNumbers() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))) // 7개의 번호
                .isInstanceOf(IllegalArgumentException.class);
    }
}