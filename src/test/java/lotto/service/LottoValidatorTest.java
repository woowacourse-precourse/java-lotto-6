package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    LottoValidator lottoValidator = new LottoValidator();

    @DisplayName("로또 구매 금액이 1000원의 배수가 아닐 시 예외가 발생한다.")
    @Test
    void isValidAmount() {
        //given
        int buyPrice = 5000;


    }

    @DisplayName("1~45사이의 서로 다른 6개의 숫자배열을 입력하지 않으면 예외가 발생한다.")
    @Test
    void isValidLottoNumbers() {
        //given
        int[] lottoNumber1 = new int[]{1, 2, 3, 4};
        int[] lottoNumber2 = new int[]{1, 1, 3, 4, 5, 6};
        int[] lottoNumber3 = new int[]{0, 1, 3, 4, 5, 57};
        int[] lottoNumber4 = new int[]{1, 2, 3, 4, 5, 6};

        //when * then
        assertFalse(lottoValidator.isValidLottoNumbers(lottoNumber1));
        assertFalse(lottoValidator.isValidLottoNumbers(lottoNumber2));
        assertFalse(lottoValidator.isValidLottoNumbers(lottoNumber3));
        assertTrue(lottoValidator.isValidLottoNumbers(lottoNumber4));
    }
}
