package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createInputNonInteger() {
        String inputInteger = "1234";
        String inputString = "string";

        // 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkUserInputIsInteger(inputInteger));

        // 문자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkUserInputIsInteger(inputString))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력값이 나눌값으로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createInputNotDivided() {
        Integer userInputCorrect = 123000;
        Integer userInputWrong = 1230;
        Integer divided = 1000;

        // 나누어 떨어지는 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkUserInputIsDivided(userInputCorrect, divided));

        // 나누어 떨어지지 않는 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkUserInputIsDivided(userInputWrong, divided))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력값이 숫자 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createInputOutOfRanged() {
        Integer userInputCorrect = 12;
        Integer userInputWrong = 46;
        Integer userInputWrong2 = -3;
        String userInputWrong3 = "10000000000";
        Integer minRange = 1;
        Integer maxRange = 45;

        // 범위 안의 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkUserInputOutOfRange(userInputCorrect, minRange, maxRange));

        // 범위 밖의 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkUserInputOutOfRange(userInputWrong, minRange, maxRange))
                .isInstanceOf(IllegalArgumentException.class);

        // 범위 밖의 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkUserInputOutOfRange(userInputWrong2, minRange, maxRange))
                .isInstanceOf(IllegalArgumentException.class);

        // 10자리 초과한 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkUserInputIsOverflow(userInputWrong3))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("리스트에 중복값이 있으면 예외가 발생한다.")
    @Test
    void createInputDuplicatedList() {
        List<Integer> targetListNonDuplicated = new ArrayList<>(List.of(1,2,3,4,5));
        List<Integer> targetListDuplicated = new ArrayList<>(List.of(1,2,3,4,3));

        // 중복값이 없을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkUserInputDuplicated(targetListNonDuplicated));

        // 중복값이 있을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkUserInputDuplicated(targetListDuplicated))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
