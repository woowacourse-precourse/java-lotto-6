package mytest;

import lotto.service.BonusLotto;
import lotto.service.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoWinningNumberTest {
    @ParameterizedTest
    @MethodSource({"winningNumber"})
    @DisplayName("당첨번호 정상입력 테스트")
    void winningNumberTest(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        assertDoesNotThrow(() -> {
            Lotto lotto = new Lotto(winningNumbers);
            int bonus = 18;
            lotto.isContainNumber(bonus);
            BonusLotto bonusLotto = new BonusLotto(18);
        });
    }
    private static Stream<Arguments> winningNumber() {
        return Stream.of(
                Arguments.arguments("1,45,2,15,3,8"),
                Arguments.arguments("1,2,3,4,5,6"),
                Arguments.arguments("40,41,42,43,44,45")
        );
    }
    @ParameterizedTest
    @MethodSource({"winningNumberDuplicate"})
    @DisplayName("당첨번호 중복입력 예외처리")
    void winningNumberDuplicateTest(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(winningNumbers);
        });
    }
    private static Stream<Arguments> winningNumberDuplicate() {
        return Stream.of(
                Arguments.arguments("1,45,45,15,3,8"),
                Arguments.arguments("1,3,3,4,5,6"),
                Arguments.arguments("40,41,42,43,45,45"),
                Arguments.arguments("1,11,17,6,37,6")
                );
    }

    @ParameterizedTest
    @MethodSource({"bonusNumberDuplicate"})
    @DisplayName("보너스번호 중복입력 예외처리")
    void bonusNumberDuplicateTest(int bonusInput) {
        String winningNumber = "1,17,45,15,3,8";
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        assertThrows(IllegalStateException.class, () -> {
            Lotto lotto = new Lotto(winningNumbers);
            lotto.isContainNumber(bonusInput);

            BonusLotto bonusLotto = new BonusLotto(bonusInput);
        });
    }
    private static Stream<Arguments> bonusNumberDuplicate() {
        return Stream.of(
                Arguments.arguments(1),
                Arguments.arguments(45),
                Arguments.arguments(8),
                Arguments.arguments(3)
        );
    }

    @ParameterizedTest
    @MethodSource({"winningNumberRange"})
    @DisplayName("당첨번호 범위 예외처리")
    void winningNumberRangeTest(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(winningNumbers);
        });
    }
    private static Stream<Arguments> winningNumberRange() {
        return Stream.of(
                Arguments.arguments("1,17,46,15,3,8"),
                Arguments.arguments("0,3,24,4,5,6"),
                Arguments.arguments("40,-1,42,43,11,45"),
                Arguments.arguments("1,11,17,18,37,55")
        );
    }

    @ParameterizedTest
    @MethodSource({"bonusNumberRange"})
    @DisplayName("보너스번호 범위 예외처리")
    void winningNumberRangeTest(int bonusInput) {
        String winningNumber = "1,17,44,15,3,8";
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(winningNumbers);
            lotto.isContainNumber(bonusInput);
            BonusLotto bonusLotto = new BonusLotto(bonusInput);
        });
    }
    private static Stream<Arguments> bonusNumberRange() {
        return Stream.of(
                Arguments.arguments(-1),
                Arguments.arguments(0),
                Arguments.arguments(46),
                Arguments.arguments(55)
        );
    }

    @ParameterizedTest
    @MethodSource({"winningNumber6s"})
    @DisplayName("당첨번호 6개가 아닐 시 예외처리")
    void winningNumber6sTest(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(winningNumbers);
        });
    }
    private static Stream<Arguments> winningNumber6s() {
        return Stream.of(
                Arguments.arguments("1,17,45,15,3,8,9"),
                Arguments.arguments("33,3,24,4,5"),
                Arguments.arguments("40,42,43,11,45,12,39,1"),
                Arguments.arguments("1")

                );
    }
}
