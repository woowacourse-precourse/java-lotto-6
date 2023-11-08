package lotto.domain.user;

import static lotto.option.GameOption.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {
    public static final int INPUT_MONEY = 8000;

    @DisplayName("money를 넣으면 올바른 lottoCount가 저장되는지 확인한다.")
    @Test
    void inputMoneyAndSaveLottoCount() {
        //given
        LottoCount lottoCount = LottoCount.from(INPUT_MONEY);
        int repeatCount = 0;
        //when
        while (lottoCount.isContinue()) {
            lottoCount.minusCount();
            repeatCount++;
        }
        //then
        assertThat(LOTTO_PRICE.getNumber() * repeatCount).isEqualTo(INPUT_MONEY);
    }
}
