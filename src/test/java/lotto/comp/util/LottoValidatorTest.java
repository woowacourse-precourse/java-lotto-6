package lotto.comp.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.Lotto;
import lotto.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    LottoValidator lottoValidator;

    @BeforeEach
    void beforeEach() {
        lottoValidator = new LottoValidator();
    }

    @DisplayName("입력한 돈이 유요한지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {8000, 14000})
    void validateMoney(int money) {
        assertDoesNotThrow(() -> {
            lottoValidator.validateMoneyValue(money);
        });
    }

    @DisplayName("[예외]입력한 돈이 유요한지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1001000, 100, 1431})
    void validateMoney_exception(int money) {
        assertThatThrownBy(() -> {
            lottoValidator.validateMoneyValue(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 10, 32})
    void validLottoNumRange(int number) {
        assertDoesNotThrow(() -> {
            lottoValidator.validLottoNumRange(number);
        });
    }

    @DisplayName("[예외} 로또 숫자 범위 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, -4, 46})
    void validLottoNumRange_exception(int number) {
        assertThatThrownBy(() -> {
            lottoValidator.validLottoNumRange(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버 유효성")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 10, 32})
    void validateBonusNumber(int number) {
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> {
            lottoValidator.validateBonusNumber(7, lottoNumbers);
        });
    }

    @DisplayName("[예외} 로또 숫자 범위 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 46, -1, 6})
    void validateBonusNumber_exception(int number) {
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> {
            lottoValidator.validateBonusNumber(number, lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
