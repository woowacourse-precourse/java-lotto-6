package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)));
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void saveBonusNumberTest(int input){
        assertThatThrownBy(()->winningLotto.saveBonusNumber(LottoNumber.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 넘버는 당첨 번호와 중복되어선 안됩니다");
    }
}