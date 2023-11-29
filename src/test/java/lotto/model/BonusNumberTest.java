package lotto.model;

import static lotto.exception.ErrorInputException.ErrorMessage.BONUS_NUMBER_CAN_NOT_BE_DUPLICATE;
import static lotto.exception.ErrorInputException.ErrorMessage.BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    private List<Integer> lotto;

    @BeforeEach
    void setLotto() {
        lotto = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호와 로또 번호가 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void isDuplicate_Test(int bonusNumber) {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumber.createBonusNumber(lotto, bonusNumber));

        //then
        assertTrue(exception.getMessage().contains(BONUS_NUMBER_CAN_NOT_BE_DUPLICATE.getMessage()));
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void isBetweenOneAndFortyFive_Test(int bonusNumber) {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumber.createBonusNumber(lotto, bonusNumber));

        //then
        assertTrue(exception.getMessage().contains(BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE.getMessage()));
    }

    @DisplayName("보너스 번호 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10, 15, 40})
    void general_Create_BonusNumber(int bonusNumber) {
        //then
        assertDoesNotThrow(() -> BonusNumber.createBonusNumber(lotto, bonusNumber));
    }
}