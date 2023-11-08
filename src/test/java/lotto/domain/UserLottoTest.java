package lotto.domain;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserLottoTest {
    @DisplayName("사용자가 작성한 숫자 중에서 0이 작성된 경우 예외가 발생한다.")
    @Test
    void createLottoByZero() {
        //given
        String lottoNum = "0,1,2,3,4,5";
        String bonusNum = "0";
        LottoService lottoService = new LottoService();

        //when
        lottoService.setPurchaseNum(lottoNum);
        lottoService.setBonusNum(bonusNum);

        //then
        assertThatThrownBy(lottoService::setLottoNumberList)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(lottoService::setBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 작성한 숫자 중에서 공백이 작성된 경우 예외가 발생한다.")
    @Test
    void createLottoBySpace() {
        //given
        String lottoNum = " ,1,2,3,4,5";
        String bonusNum = " ";
        LottoService lottoService = new LottoService();

        //when
        lottoService.setPurchaseNum(lottoNum);
        lottoService.setBonusNum(bonusNum);

        //then
        assertThatThrownBy(lottoService::setLottoNumberList)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(lottoService::setBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    
}
