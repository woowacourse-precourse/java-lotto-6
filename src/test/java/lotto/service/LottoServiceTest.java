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


}
