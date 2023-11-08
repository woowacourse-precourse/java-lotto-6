package lotto.input;

import static lotto.exception.ErrorType.InsideListDuplicatedException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("입력한 로또 원소 중 겹치는 값이 있을 때 InsideListDuplicatedException 발생")
    void createDuplicatedList(){

        //given
        int duplicatedNumber = 5;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, duplicatedNumber);

        //when & then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", InsideListDuplicatedException);
    }
}
