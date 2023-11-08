package lotto.input;

import static lotto.exception.ErrorType.InsideListDuplicatedException;
import static lotto.exception.ErrorType.InvalidNumberSizeException;
import static lotto.exception.ErrorType.OverValueException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateLottoTest {

    @Test
    @DisplayName("원소 중 겹치는 값이 있을 때 InsideListDuplicatedException 발생")
    void createDuplicatedListTest(){

        //given
        int duplicatedNumber = 5;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, duplicatedNumber);

        //when & then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", InsideListDuplicatedException);
    }

    @Test
    @DisplayName("원소 중 범위를 넘어가는 값이 있을 때 OverValueException 발생")
    void invalidNumberTest(){

        //given
        int invalidNumber = 100;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, invalidNumber);

        //when & then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", OverValueException);
    }

    @Test
    @DisplayName("원소가 6개가 아닐때 때 InsideListDuplicatedException 발생")
    void invalidSizeTest(){

        //given
        List<Integer> lottoNumbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> lottoNumbers2 = List.of(1, 2, 3, 4, 5, 6, 7);

        //when & then
        assertThatThrownBy(() -> new Lotto(lottoNumbers1))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", InvalidNumberSizeException);

        //when & then
        assertThatThrownBy(() -> new Lotto(lottoNumbers2))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", InvalidNumberSizeException);
    }
}
