package lotto.controller;

import static lotto.util.TestUtil.ERROR_PREFACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoWinningNumbers;
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
    void buyLottoSuccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final int count = 5;
        run(String.valueOf(count * 1000));
        Method method = getAccessibleMethod("buyLotto");
        method.invoke(lottoController);

        assertThat(output()).contains(count + "개");
    }

    @DisplayName("1등 당첨 번호를 받아온다.")
    @Test
    void successGetLottoWinningNumbers()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoWinningNumbers");

        LottoWinningNumbers winningNumbers = (LottoWinningNumbers) method.invoke(lottoController);
        assertThat(winningNumbers).isNotNull();
    }

    @DisplayName("잘못된 값을 입력하면 다시 입력되면 오류를 발생한다.: 1,2,3")
    @Test
    void getLottoWinningNumbersThrowCase1()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3", "1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoWinningNumbers");

        method.invoke(lottoController);
        assertThat(output()).contains(ERROR_PREFACE);
    }

    @DisplayName("잘못된 값을 입력하면 다시 입력되면 오류를 발생한다.: 숫자 이외")
    @Test
    void getLottoWinningNumbersThrowCase2()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,w", "1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoWinningNumbers");

        method.invoke(lottoController);
        assertThat(output()).contains(ERROR_PREFACE);
    }

    @DisplayName("사용자로부터 보너스 번호를 받아오고 잘 저장된다.")
    @Test
    void getLottoBonusNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int number = 25;
        run(String.valueOf(number));
        Method method = getAccessibleMethod("getLottoBonusNumber");

        LottoBonusNumber outBonusNumber = (LottoBonusNumber) method.invoke(lottoController);

        assertThat(outBonusNumber.getBonusNumber()).isEqualTo(number);
    }

    @DisplayName("잘못된 번호는 오류를 반환하고 다시 받는다.: 문자") // 이외 케이스는 LottoBonusNumber에서 처리
    @Test
    void getLottoBonusNumberThrowCase()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("w", "25");
        Method method = getAccessibleMethod("getLottoBonusNumber");

        LottoBonusNumber bonusNumber = (LottoBonusNumber) method.invoke(lottoController);

        assertThat(output()).contains(ERROR_PREFACE);
        assertThat(bonusNumber)
                .isNotNull();
    }

    @DisplayName("사용자로부터 1등 번호와 보너스 번호를 받고 서비스에 넘긴다.")
    @Test
    void getLottoWinningAmount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,6", "25");
        Method method = getAccessibleMethod("getLottoBonusNumber");

        // 예외 없이 잘 끝난다.
        method.invoke(lottoController);
    }

    @DisplayName("잘못된 1등 번호를 입력하면 다시 받고 전달한다.") // 다양한 케이스는 각 메서드에서 테스트
    @Test
    void getLottoWinningAmountRetry1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,7", "1,2,3,4,5,6", "25");
        Method method = getAccessibleMethod("getLottoBonusNumber");

        // 예외 없이 잘 끝난다.
        method.invoke(lottoController);

        assertThat(output()).contains(ERROR_PREFACE);
    }

    @DisplayName("잘못된 보너스 번호를 입력하면 다시 받고 전달한다.") // 다양한 케이스는 각 메서드에서 테스트
    @Test
    void getLottoWinningAmountRetry2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,6", "-10", "25");
        Method method = getAccessibleMethod("getLottoBonusNumber");

        // 예외 없이 잘 끝난다.
        method.invoke(lottoController);

        assertThat(output()).contains(ERROR_PREFACE);
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