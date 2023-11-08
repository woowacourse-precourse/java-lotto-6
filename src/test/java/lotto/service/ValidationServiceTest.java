package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.mockStatic;

class ValidationServiceTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationService();
    }

    @DisplayName("성공 케이스")
    @Nested
    class SuccessTest{

        @Test
        void validationBuyMoneyTest() {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                console.when(Console::readLine).thenReturn("8000");

                int result = validationService.validationBuyMoney();

                assertEquals(8, result); // 입력값인 8000을 1000으로 나누면 8이어야 합니다.
            }
        }

        @Test
        void validationSuccessLottoTest() {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                console.when(Console::readLine).thenReturn("1,2,3,4,5,6");

                List<Integer> result = validationService.validationSuccessLotto();

                assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
            }
        }

        @Test
        void validationBonusLottoTest() {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                console.when(Console::readLine).thenReturn("7");

                int result = validationService.validationBonusLotto(List.of(1, 2, 3, 4, 5, 6));

                assertThat(result).isEqualTo(7);
            }
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}