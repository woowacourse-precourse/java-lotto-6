package lotto.domain;

import java.util.List;
import lotto.Application;
import lotto.UI.InputBonus;
import lotto.UI.InputNum;
import lotto.UI.InputPrice;
import lotto.UI.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DomainTest  extends NsTest {
    @DisplayName("숫자가 아니면 예외 발생")
    @Test
    void notNumber() {
        String inputNumber = "a,v,s,c";
        String[] numbers = inputNumber.split(",");
        assertThatThrownBy(() -> InputNum.checkLottoNumbersToInt(numbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputPrice.checkPriceToInt("1000won"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputBonus.checkBonusNumberToInt("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000 단위 숫자가 아니면 예외 발생")
    @Test
    void checkPriceUnit() {
        assertThatThrownBy(() -> InputPrice.checkPriceUnit(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1-45 사이의 숫자가 아니면 예외 발생")
    @Test
    void checkNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 50, 60, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputBonus.checkBonusNumberRange(48))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 길이가 6보다 크면 예외 발생")
    @Test
    void checkNumberSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호간의 중복된 숫자가 있으면 예외 발생")
    @Test
    void checkNumberDup() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 50, 60, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 쉼표로 구분 짓지 않으면 예외 발생")
    @Test
    void checkComma() {
        assertThatThrownBy(() -> InputNum.checkLottoNumberComma("1/2/3/4/5/6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputNum.checkLottoNumberComma("1-2-3-4-5-6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputNum.checkLottoNumberComma("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자와 당첨 번호가 중복되면 예외 발생")
    @Test
    void checkBonusDup() {
        assertThatThrownBy(() -> InputBonus.checkBonusNumberDup(1,List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("복권 구입에 따른 수익률 계산")
    @Test
    void checkReturn() {
        assertSimpleTest(() -> {
            Output.printRateOfReturn(50000.0, 5000);
            assertThat(output()).contains("1000.0%");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
