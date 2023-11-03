package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ErrorHeadMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.MagicVariable.LOTTO_PRICE;

class LottoProcessTest {
    String ERROR_HEAD_MESSAGE = ErrorHeadMessage.ERROR_HEAD_MESSAGE;
    LottoProcess lottoProcess = new LottoProcess();

    @DisplayName("랜덤 번호 생성 확인")
    @Test
    void 랜덤_번호_생성_확인() {
        Assertions.assertNotNull(lottoProcess);
    }

    @DisplayName("로또 구매매금액에 맞는 갯수인지 확인")
    @Test
    void 로또_구매금액에_맞는_갯수인지_확인() {
        int money = 3000;
        assertThat(lottoProcess.purchaseLotto(money).size()).isEqualTo(money / LOTTO_PRICE.getNumber());
    }

    @DisplayName("구매 단위가 1000원이 아닌 경우 예외 확인")
    @Test
    void 구매_단위_1000원_아닌_경우_예외_확인() {
        int money = 3500;
        assertThatThrownBy(() -> lottoProcess.purchaseLotto(money))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_HEAD_MESSAGE);
    }
}