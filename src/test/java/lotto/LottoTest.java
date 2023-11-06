package lotto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능


    @Test
    void testValidateDivided() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation();
        Method method = validation.getClass().getDeclaredMethod("privateValidateDivided", int.class);
        method.setAccessible(true);
        try{
            method.invoke(validation, 12345);
        }catch(InvocationTargetException e){
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }

    }
}