package lotto.input;

import static lotto.exception.ErrorType.AmountMinimumException;
import static lotto.exception.ErrorType.AmountUnitException;
import static lotto.exception.ErrorType.InputMoneyNotDigitException;
import static lotto.exception.ErrorType.InputMoneyOverflowException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.MoneyManagement;
import lotto.exception.ErrorType;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AskAmountTest {

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우에 AmountUnitException 타입 오류 발생")
    void notUnitTest(){
        //given
        String amount = "5001";

        //when & then
        LottoException lottoException = assertThrows(LottoException.class,
                () -> MoneyManagement.from(amount));

        ErrorType exceptionType = lottoException.getExceptionType();
        assertThat(exceptionType).isEqualTo(AmountUnitException);
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 이하일 때 AmountMinimumException 타입 오류 발생")
    void minimumTest(){
        //given
        String amount = "501";

        //when & then
        LottoException lottoException = assertThrows(LottoException.class,
                () -> MoneyManagement.from(amount));

        ErrorType exceptionType = lottoException.getExceptionType();
        assertThat(exceptionType).isEqualTo(AmountMinimumException);
    }


    @Test
    @DisplayName("로또 구입 금액에 숫자가 아닌 입력 값이 들어올 때 InputMoneyNotDigitException 타입 오류 발생")
    void notDigit(){
        //given
        String amount = "lotto!";

        //when & then
        LottoException lottoException = assertThrows(LottoException.class,
                () -> MoneyManagement.from(amount));

        ErrorType exceptionType = lottoException.getExceptionType();
        assertThat(exceptionType).isEqualTo(InputMoneyNotDigitException);
    }

    @Test
    @DisplayName("로또 구입 금액이 Integer.MaxValue보다 클 때")
    void overflow(){
        //given
        String amount = "2147483648";

        //when & then
        LottoException lottoException = assertThrows(LottoException.class,
                () -> MoneyManagement.from(amount));

        ErrorType exceptionType = lottoException.getExceptionType();
        assertThat(exceptionType).isEqualTo(InputMoneyOverflowException);
    }
}
