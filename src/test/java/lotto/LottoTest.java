package lotto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        assertEquals(exception.getMessage(), "[ERROR] 6개의 숫자가 아닙니다. 다시 입력해주세요.");
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5)));
        assertEquals(exception2.getMessage(), "[ERROR] 6개의 숫자가 아닙니다. 다시 입력해주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
        assertEquals(exception.getMessage(), "[ERROR] 중복된 숫자가 있습니다. 다시 입력해주세요.");
    }

    @DisplayName("1~45 사이가 아니라면 예외 처리한다.")
    @Test
    void creatLottoBy1to45(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 100)));
        assertEquals(exception.getMessage(), "[ERROR] 로또 번호의 숫자 범위는 1~45사이 입니다. 다시 입력해주세요.");
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(-1, 2, 3, 4, 5, 11)));
        assertEquals(exception2.getMessage(), "[ERROR] 로또 번호의 숫자 범위는 1~45사이 입니다. 다시 입력해주세요.");
    }

}