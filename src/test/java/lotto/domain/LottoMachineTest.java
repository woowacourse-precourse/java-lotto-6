package lotto.domain;

import lotto.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine(new AutoLottoCreateModel());

    @Test
    @DisplayName("구입 금액이 1000로 나누어떨어지지 않으면 예외가 발생한다.")
    void 구입_금액_단위_틀림() {
        assertThatThrownBy(()
                -> lottoMachine.generateForPrice(3500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.Domain.WRONG_PRICE.getText().formatted(1000));
    }

    @Test
    @DisplayName("구입 금액이 1000로 나누어 떨어지면 예외가 발생하지 않는다.")
    void 구입_금액_단위_정상() {
        lottoMachine.generateForPrice(4000);
    }

    @Test
    @DisplayName("4000원이면 Lotto는 4개여야 한다.")
    void 구입_크기_4() {
        //given
        int price = 4000;
        //when
        BuyLotto lottoGroup = lottoMachine.generateForPrice(price);
        //then
        assertThat(lottoGroup.lotto()).hasSize(4);
    }

    @Test
    @DisplayName("generate하면 BuyLotto 클래스를 반환해야한다.")
    void 생성시_BuyLotto_반환() {
        //given
        int price = 4000;
        //when, then
        assertThat(lottoMachine.generateForPrice(price)).isInstanceOf(BuyLotto.class);
    }
}