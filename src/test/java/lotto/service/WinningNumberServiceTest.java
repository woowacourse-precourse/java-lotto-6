package lotto.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import lotto.constant.message.ExceptionMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResultCount;
import lotto.util.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberServiceTest {

    private WinningNumberService winningNumberService;
    private ValidationUtil validationUtil;
    private LottoPurchase lottoPurchase;
    private ResultService resultService;

    @BeforeEach
    void setUp() {
        winningNumberService = new WinningNumberService();
        validationUtil = new ValidationUtil();
        lottoPurchase = new LottoPurchase();
        resultService = new ResultService();
    }

    @Test
    @DisplayName("당첨 번호 및 보너스 번호 입력 및 로또 당첨 결과 계산 테스트")
    void testCalculateLottoWinningResult() {
        // Arrange
        winningNumberService.getInputWinningSixNumber("1,2,3,4,5,6"); // 당첨 번호 입력
        winningNumberService.getInputWinningNumber("7"); // 보너스 번호 입력

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 당첨 번호와 동일한 로또
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 보너스 번호 일치
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5개 일치
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)); // 4개 일치
        Lotto lotto5 = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)); // 당첨 번호와 전혀 다른 로또

        lottoPurchase.getUserLotto(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5));

        // Act
        winningNumberService.getLottoWinningResult(lottoPurchase, resultService);
        LottoResultCount lottoResultCount = resultService.getLottoResultCount();

        // Assert
        assertThat(lottoResultCount.getSixCount()).isEqualTo(1); // 1개 일치
        assertThat(lottoResultCount.getFiveCount()).isEqualTo(1); // 5개 일치 (보너스 번호 불일치)
        assertThat(lottoResultCount.getFourCount()).isEqualTo(1); // 4개 일치
        assertThat(lottoResultCount.getFiveWithBonusCount()).isEqualTo(1); // 5개 일치 (보너스 번호 일치)
        assertThat(lottoResultCount.getThreeCount()).isEqualTo(0); // 3개 일치
    }

    @Test
    @DisplayName("빈칸이 포함된 입력시 예외 발생")
    void shouldThrowArithmeticExceptionForInvalidPurchaseInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateBlank", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,,3,5,6");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    @Test
    @DisplayName("6개가 아닌 숫자들을 입력시 예외 발생")
    void shouldThrowCountFailInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateCount", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,3,5,6");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.COUNT_ERROR.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 값들 중 중복되는 숫자들 입력시 예외 발생")
    void shouldThrowDuplicateInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateDuplicate", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,3,3,4,5");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 값들 중 표기는 다르지만 중복되는 숫자들 입력시 예외 발생")
    void shouldThrowDuplicateSameMeanInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateDuplicate", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("01,001,0001,1,00001,000001");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 값이 숫자가 아닌 경우 예외 발생")
    void shouldThrowNoneNumberInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("isValidNumber", String.class);
        method.setAccessible(true);

        //when
        String winningNumber = "하나";

        // then
        try {
            method.invoke(validationUtil, winningNumber);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 값이 숫자가 범위 내의 숫자가 아닌 경우 예외 발생")
    void shouldThrowNoneRangeNumberInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("isValidNumber", String.class);
        method.setAccessible(true);

        //when
        String winningNumber = "46";

        // then
        try {
            method.invoke(validationUtil, winningNumber);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_RANGE.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 보너스값이 숫자가 아닌 경우 예외 발생")
    void shouldThrowNoneNumberBonusInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("isValidNumber", String.class);
        method.setAccessible(true);

        //when
        String bonus = "세븐";

        // then
        try {
            method.invoke(validationUtil, bonus);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 보너스 번호가 이미 당첨번호에 존재하는 경우 예외 발생")
    void shouldThrowExistedNumberInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("isExistedNumber", int.class, List.class);
        method.setAccessible(true);

        //when
        int bonus = 6;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // then
        try {
            method.invoke(validationUtil, bonus, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }
}