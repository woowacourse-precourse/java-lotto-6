package myTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.LottoSetting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoSettingTest {

    private LottoSetting lottoSetting;

    @BeforeEach
    void setUp() {
        lottoSetting = new LottoSetting();
    }

    @Test
    void 예외_테스트_입력받은_금액에_문자가_포함되어_있을_때() {
        String money = "10000원";
        assertThatThrownBy(() -> lottoSetting.moneyValidate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 숫자만 입력 가능합니다.");
    }

    @Test
    void 예외_테스트_입력받은_금액이_1000원_단위가_아닐_때() {
        String money = "5500";
        assertThatThrownBy(() -> lottoSetting.moneyValidate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 로또는 1000원 단위로 구매 할 수 있습니다.");
    }
}