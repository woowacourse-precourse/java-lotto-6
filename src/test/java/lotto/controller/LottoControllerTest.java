package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {
    @DisplayName("구입 금액은 1,000 단위로 나눠져야 합니다.")
    @Test
    void buyLottoByChange(){
        LottoController lottoController = new LottoController();
        assertThatThrownBy(lottoController::buyLotto);
    }


}
