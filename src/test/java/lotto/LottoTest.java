package lotto;

import lotto.Domain.Lotto;
import static lotto.Constant.Const.*;

import lotto.Util.ExceptionTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;


class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() throws Exception {
        ExceptionTest exceptionTest = new ExceptionTest();
        Method method = exceptionTest.getClass().getDeclaredMethod("checkWinningCount", String[].class);
        method.setAccessible(true);

        //when
        String[] winningNums = {"1", "2", "3", "4", "5", "6", "7"};

        //then
        try {
            method.invoke(exceptionTest, new Object[]{winningNums});
        } catch (InvocationTargetException e) {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EXCEPTION_NUMBER_ERROR);
        }
    }


    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() throws Exception{
        ExceptionTest exceptionTest = new ExceptionTest();
        Method method = exceptionTest.getClass().getDeclaredMethod("checkDuplicate", String[].class);
        method.setAccessible(true);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(EXCEPTION_NUMBER_MULTIPLE_ERROR);
    }

    // 아래에 추가 테스트 작성 가능
}