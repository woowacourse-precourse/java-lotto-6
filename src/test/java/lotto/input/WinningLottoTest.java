package lotto.input;

import static lotto.exception.ErrorType.InsideListDuplicatedException;
import static lotto.exception.ErrorType.OverValueException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.ErrorType;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

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
    @DisplayName("원소 중 범위를 넘어가는 값이 있을 때 InsideListDuplicatedException 발생")
    void invalidNumberTest(){

        //given
        int invalidNumber = 100;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, invalidNumber);

        //when & then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", OverValueException);
    }
}
