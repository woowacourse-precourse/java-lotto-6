package lotto.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    public void 로또번호_중복되면_예외발생() throws Exception {
        //given
        List<Integer> numbers = List.of(1, 1, 1, 1, 1, 1);

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> Validator.validateDuplicatedLottoNumbers(numbers);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액이_천원단위가_아니라면_예외발생() throws Exception {
        //given
        int price = 1;

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> Validator.validateBuyCash(price);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }
}