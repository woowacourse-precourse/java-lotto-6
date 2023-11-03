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
                .hasMessage("숫자만 입력해주세요.");

        assertThatThrownBy(() -> lottoStore.validateMoneyInput(koreanInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");

        assertThatThrownBy(() -> lottoStore.validateMoneyInput(specialSignInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }
}