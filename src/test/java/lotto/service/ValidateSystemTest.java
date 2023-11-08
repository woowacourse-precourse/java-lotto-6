package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateSystemTest {

    @DisplayName("구매금액이 1000단위로 안떨어질때 예외발생")
    @Test
    void validatePaymentAccount1() {
        //given
        ValidateSystem validateSystem = new ValidateSystem();
        int paymentAccount = 1200;

        //when & then
        assertThatThrownBy(() -> validateSystem.validatePaymentAccount(paymentAccount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 0원일 때 안떨어질때 예외발생")
    @Test
    void validatePaymentAccount2() {
        //given
        ValidateSystem validateSystem = new ValidateSystem();
        int paymentAccount = 0;

        //when & then
        assertThatThrownBy(() -> validateSystem.validatePaymentAccount(paymentAccount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 6자리를 넘었을 때 예외발생")
    @Test
    void validateLottoNumbers1() {
        //given
        ValidateSystem validateSystem = new ValidateSystem();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6);

        //when & then
        assertThatThrownBy(() -> validateSystem.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 6자리를 넘었을 때 예외발생")
    @Test
    void validateLottoNumbers2() {
        //given
        ValidateSystem validateSystem = new ValidateSystem();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6);

        //when & then
        assertThatThrownBy(() -> validateSystem.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 중복될때 예외발생")
    @Test
    void validateLottoNumbers3() {
        //given
        ValidateSystem validateSystem = new ValidateSystem();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        //when & then
        assertThatThrownBy(() -> validateSystem.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복될때 예외발생")
    @Test
    void validateBonusNumber() {
        //given
        ValidateSystem validateSystem = new ValidateSystem();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        //when & then
        assertThatThrownBy(() -> validateSystem.validateBonusNumber(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}