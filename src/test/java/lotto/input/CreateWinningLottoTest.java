package lotto.input;

import static lotto.exception.ErrorType.BonusNumberDuplicatedException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateWinningLottoTest {

    @Test
    @DisplayName("당첨 번호 6개 중 하나와 보너스 번호가 겹칠 때 BonusNumberDuplicatedException 발생")
    void bonusNumberDuplicated(){

        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(lottoNumbers);
        Number bonusNumber = Number.from(6);

        //when & then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasFieldOrPropertyWithValue("exceptionType", BonusNumberDuplicatedException);
    }
}
