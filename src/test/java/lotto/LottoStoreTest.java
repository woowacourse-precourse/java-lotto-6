package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class LottoStoreTest {

    @DisplayName("로또를 사기 위한 금액이 숫자가 아니면 예외가 발생한다")
    @Test
    void validateMoneyInput() {
        //when
        LottoStore lottoStore = new LottoStore();

        //given
        String englishInMoney = "100a";
        String koreanInMoney = "100ㅁ";
        String specialSignInMoney = "100%";

        //then
        assertThatThrownBy(() -> lottoStore.validateMoneyInput(englishInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.")
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> lottoStore.validateMoneyInput(koreanInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.")
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> lottoStore.validateMoneyInput(specialSignInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또를 사기 위한 금액이 1000원 미만이면 예외가 발생한다")
    @Test
    void chargedMoneyLessThan1000() {
        //when
        LottoStore lottoStore = new LottoStore();

        //given
        String money = "0";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);

        //then
        assertThatThrownBy(() -> lottoStore.validateChargedMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 부터입니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또를 사기 위한 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    @Test
    void chargedMoneyNotDivideBy1000() {
        //when
        LottoStore lottoStore = new LottoStore();

        //given
        String money = "10001";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);

        //then
        assertThatThrownBy(() -> lottoStore.validateChargedMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위 입니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("올바른 금액 저장")
    @Test
    void chargeMoney() {
        //when
        LottoStore lottoStore = new LottoStore();

        //given
        String money = "13000";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);
        lottoStore.validateChargedMoney();

        //then
        long moneyExpected = Long.parseLong(money);
        assertThat(lottoStore.getChargedMoney()).isEqualTo(moneyExpected);
    }

    @DisplayName("로또 구매 금액 조회")
    @Test
    void checkChargedMoney() {
        //when
        LottoStore lottoStore = new LottoStore();

        //given
        String money = "13000";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);
        lottoStore.validateChargedMoney();

        long chargemoney = lottoStore.getChargedMoney();

        //then
        long moneyExpected = Long.parseLong(money);
        assertThat(chargemoney).isEqualTo(moneyExpected);
    }


}