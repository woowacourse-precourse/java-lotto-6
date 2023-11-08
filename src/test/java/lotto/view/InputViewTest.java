package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.converter.InputConverter;
import lotto.model.Lotto;
import lotto.validator.LottoMoneyValidator;
import lotto.validator.LottoNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("로또 금액을 입력하면 검증 후 정수로 변환된다.")
    @Test
    void getLottoMoney() {
        String lottoMoney = "15000";
        LottoMoneyValidator.validate(lottoMoney);
        assertThat(InputConverter.convertLottoMoney(lottoMoney)).isEqualTo(15000);

    }

    @DisplayName("당첨 번호를 입력하면 검증 후 로또 객체로 변환된다.")
    @Test
    void getWinningLotto() {
        String winningLotto = "1,2,3,4,5,6";
        LottoNumberValidator.validate(winningLotto);
        Lotto lotto = InputConverter.convertWinningLotto(winningLotto);

        lotto.contains(1);
        lotto.contains(2);
        lotto.contains(3);
        lotto.contains(4);
        lotto.contains(5);
        lotto.contains(6);
    }

    @DisplayName("보너스 번호를 입력하면 검증 후 정수로 변환된다.")
    @Test
    void getBonusNumber() {
        String bonusNumber = "7";
        assertThat(InputConverter.convertBonusNumber(bonusNumber)).isEqualTo(7);
    }
}