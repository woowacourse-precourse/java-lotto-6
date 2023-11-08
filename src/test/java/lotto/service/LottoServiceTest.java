package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    static LottoService lottoService;
    @DisplayName("로또 번호가 콤마로 구분되어있지 않은 경우 예외가 발생한다.")
    @Test
    void createLottoByNotCommaSplitter() {
        //given
        String inputValue = "1.2.3.4.5.6";
        lottoService = new LottoService();

        //when
        lottoService.setPurchaseNum(inputValue);

        //then
        assertThatThrownBy(() -> lottoService.setLottoNumberList())
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoService.setBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 작성한 로또 번호와 보너스 번호 중에서 중복이 있는 경우 예외가 발생한다.")
    @Test
    void createLottoBySpace() {
        //given
        String lottoNum = "1,2,4,13,24,35";
        String bonusNum = "2";
        LottoService lottoService = new LottoService();

        //when
        lottoService.setPurchaseNum(lottoNum);
        lottoService.setBonusNum(bonusNum);

        //then
        assertThatThrownBy(lottoService::setBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }


}
