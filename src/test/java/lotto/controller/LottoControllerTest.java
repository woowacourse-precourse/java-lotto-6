package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    LottoController lottoController;

    @BeforeEach
    void setup() {
        this.lottoController = new LottoController();
    }

    @DisplayName("로또를 구입할 때 잘못된 값을 넣으면 예외 발생: 단위")
    @Test
    void buyLottoThrowCase1() throws NoSuchMethodException {
        final String money = "1100";
        run(money);
        Method method = getAccessibleMethod("buyLotto");

        assertThatThrownBy(() -> {
            method.invoke(lottoController);
        })
                .isInstanceOf(InvocationTargetException.class);
    }

    @DisplayName("로또를 구입할 때 잘못된 값을 넣으면 예외 발생: 음수")
    @Test
    void buyLottoThrowCase2() throws NoSuchMethodException {
        final String money = "-1000";
        run(money);
        Method method = getAccessibleMethod("buyLotto");

        assertThatThrownBy(() -> {
            method.invoke(lottoController);
        })
                .isInstanceOf(InvocationTargetException.class);
    }

    @DisplayName("로또를 구입할 때 잘못된 값을 넣으면 예외 발생: 음수")
    @Test
    void buyLottoThrowCase3() throws NoSuchMethodException {
        final String money = "0";
        run(money);
        Method method = getAccessibleMethod("buyLotto");

        assertThatThrownBy(() -> {
            method.invoke(lottoController);
        })
                .isInstanceOf(InvocationTargetException.class);
    }

    @DisplayName("로또를 구입하고, 로또를 반환받는다.")
    @Test
    void buyLottoSuccess() {
        // TODO: 개발 완료 후 진행
    }


    private Method getAccessibleMethod(String methodName, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Method method = lottoController.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return method;
    }

    @Override
    public void runMain() {
    }
}