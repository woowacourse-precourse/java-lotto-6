package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {

    @Test
    @DisplayName("생성자로 초기화 된 보너스 번호를 출력한다.")
    void getBonusNumberTest() {
        //given
        LottoWinningNumber lotto = new LottoWinningNumber("1,2,4,5,6,7",1);
        //when
        int bonusNumber = lotto.getBonusNumber();
        //then
        assertThat(bonusNumber).isEqualTo(1);
    }



}