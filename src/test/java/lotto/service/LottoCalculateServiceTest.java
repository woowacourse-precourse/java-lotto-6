package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.exception.NonVariableException;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoWinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculateServiceTest extends NsTest {

    LottoCalculateService lottoCalculateService;

    @BeforeEach
    void setup() {
        this.lottoCalculateService = new LottoCalculateService();
    }

    @DisplayName("1등 로또 번호가 저장된다.")
    @Test
    void successSaveRecentWinningNumbers() throws NoSuchFieldException, IllegalAccessException {
        // given
        String numbers = "1,2,3,4,5,6";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(numbers);
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumbers, "7");
        Field winningField = getAccessibleField("winningNumbers");
        Field bonusField = getAccessibleField("bonusNumber");

        // when
        lottoCalculateService.saveRecentWinningNumbers(lottoWinningNumbers, lottoBonusNumber);

        // then
        assertThat(winningField.get(lottoCalculateService)).isEqualTo(lottoWinningNumbers);
        assertThat(bonusField.get(lottoCalculateService)).isEqualTo(lottoBonusNumber);
    }

    @DisplayName("필요한 데이터가 없으면 예외가 발생한다.")
    @Test
    void readyCheckThrow() throws NoSuchMethodException {
        Method method = getAccessibleMethod("readyCheck");

        assertThatThrownBy(() -> method.invoke(lottoCalculateService))
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(NonVariableException.class);
    }

    private Field getAccessibleField(String variableName) throws NoSuchFieldException {
        Field field = lottoCalculateService.getClass().getDeclaredField(variableName);
        field.setAccessible(true);

        return field;
    }

    private Method getAccessibleMethod(String methodName, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Method method = lottoCalculateService.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return method;
    }

    @Override
    public void runMain() {
    }
}