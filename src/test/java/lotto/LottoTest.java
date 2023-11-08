package lotto;

import lotto.Model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.ErrorMessages.VALIDATE_1_TO_45;
import static lotto.ErrorMessages.VALIDATE_6_NUMS;
import static lotto.ErrorMessages.VALIDATE_DUPLICATE_LOTTO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        assertEquals(exception.getMessage(), VALIDATE_6_NUMS.getMessage());
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5)));
        assertEquals(exception2.getMessage(), VALIDATE_6_NUMS.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
        assertEquals(exception.getMessage(), VALIDATE_DUPLICATE_LOTTO.getMessage());
    }

    @DisplayName("1~45 사이가 아니라면 예외 처리한다.")
    @Test
    void creatLottoBy1to45(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 100)));
        assertEquals(exception.getMessage(), VALIDATE_1_TO_45.getMessage());
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(-1, 2, 3, 4, 5, 11)));
        assertEquals(exception2.getMessage(), VALIDATE_1_TO_45.getMessage());
    }

}