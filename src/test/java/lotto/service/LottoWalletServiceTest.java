package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lotto.model.LottoWinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWalletServiceTest extends NsTest {
    
    LottoWalletService lottoWalletService;

    @BeforeEach
    void setup() {
        this.lottoWalletService = new LottoWalletService();
    }

    @DisplayName("1등 로또 번호가 저장된다.")
    @Test
    void successSaveRecentWinningNumbers() throws NoSuchFieldException, IllegalAccessException {
        // given
        String numbers = "1,2,3,4,5,6";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(numbers);
        Field field = getAccessibleField("winningNumbers");

        // when
        lottoWalletService.saveRecentWinningNumbers(lottoWinningNumbers);

        // then
        assertThat(field.get(lottoWalletService)).isEqualTo(lottoWinningNumbers);
    }

    private Field getAccessibleField(String variableName) throws NoSuchFieldException {
        Field field = lottoWalletService.getClass().getDeclaredField(variableName);
        field.setAccessible(true);

        return field;
    }

    private Method getAccessibleMethod(String methodName, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Method method = lottoWalletService.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return method;
    }

    @Override
    public void runMain() {
    }
}