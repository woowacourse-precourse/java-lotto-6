package lotto;

import exception.CustomException;
import lotto.domain.Lotto;
import lotto.service.LottoPurchase;
import lotto.service.LottoStatistics;
import lotto.service.RandomNumberGenerator;
import lotto.service.WinningNumberInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
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
    @DisplayName("로또가 출력되는 형식")
    @Test
    void testToStringLotto() {
        assertEquals(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString(), "[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("유저가 구매한 로또갯수와 발행된 로또 갯수 비교")
    @Test
    void testUserLottoBetweenPurchaseLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int userPurchase = 8;
        List<Lotto> lottos = randomNumberGenerator.generateRandomNumber(userPurchase);
        assertEquals(userPurchase, lottos.size());
    }

    @DisplayName("승률예상하기")
    @Test
    void testCalculateWinRate() {
        int userPurchase = 8;
        List<Lotto> userLottos = new ArrayList<>(List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))));

        Map<Lotto, Integer> winNumber = new HashMap<>();
        winNumber.put(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoStatistics lottoStatistics = new LottoStatistics();
        String winnRate = lottoStatistics.calculateWinRate(userPurchase, userLottos, winNumber);

        assertEquals(winnRate, "62.5");
    }

    @DisplayName("구입금액이 문자열일때 예외 발생")
    @Test
    void testPurchaseNumberString() throws NoSuchMethodException {
        try {
            LottoPurchase lottoPurchase = new LottoPurchase();
            String userPurchase = "money";
            Method method = LottoPurchase.class.getDeclaredMethod("validateNumber", String.class);
            method.setAccessible(true);
            method.invoke(lottoPurchase, userPurchase);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 숫자로 입력해 주세요");
        }

    }

    @DisplayName("구입금액이 맞게 입력되었을때")
    @Test
    void testPurchaseNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String userPurchase = "2000";
        Method method = LottoPurchase.class.getDeclaredMethod("validateNumber", String.class);
        method.setAccessible(true);
        assertThat(method.invoke(lottoPurchase, userPurchase)).isEqualTo(2000);
    }

    @DisplayName("구입금액과 상금으로 승률계산하기")
    @Test
    void testCalculateWinningPercentage() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoStatistics lottoStatistics = new LottoStatistics();
        int userPurchase = 2;
        long totalPrize = 200000000;
        Method method1 = LottoStatistics.class.getDeclaredMethod("calculateWinningPercentage", int.class, long.class);
        method1.setAccessible(true);
        assertThat(method1.invoke(lottoStatistics, userPurchase, totalPrize)).isEqualTo("10000000");
    }

    @DisplayName("당첨번호입력시 숫자를 입력하면 통과")
    @Test
    void testValidateString() throws NoSuchMethodException {
        String[] numbers = new String[]{
                "1", "2", "3", "4", "5", "6"
        };

        try {
            WinningNumberInput winningNumberInput = new WinningNumberInput();
            Method method = WinningNumberInput.class.getDeclaredMethod("isNumber", String[].class);
            method.setAccessible(true);
            method.invoke(winningNumberInput, (Object) numbers);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @DisplayName("당첨번호입력시 문자열을 입력하면 예외발생")
    @Test
    void testValidateNumber() throws NoSuchMethodException {
        String[] numbers = new String[]{
                "a", "2", "3", "4", "5", "6"
        };

        try {
            WinningNumberInput winningNumberInput = new WinningNumberInput();
            Method method = WinningNumberInput.class.getDeclaredMethod("isNumber", String[].class);
            method.setAccessible(true);
            method.invoke(winningNumberInput, (Object) numbers);
        } catch (CustomException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("[ERROR] 숫자로 입력해 주세요");
        }

    }
}