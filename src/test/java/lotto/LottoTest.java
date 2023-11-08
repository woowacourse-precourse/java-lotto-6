package lotto;


import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.User.returnPercent;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;

class LottoTest extends NsTest{

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }




    @DisplayName("사용자가 로또 금액에 1000원 단위를 입력하지 않으면 예외 발생")
    @Test
    void creatLottoInputByNumber() {

        assertSimpleTest(() -> {
            runException("5100");
            assertThat(output()).contains("[ERROR]");
        });
        Console.close();
    }

    @DisplayName("입력받은 보너스 번호가 범위에 적합하지 않을 시 예외 발생")
    @Test
    void checkNumberRangeTest() {
        int number = 46;
        assertThrows(IllegalArgumentException.class, () -> User.checkNumberRange(number));
    }

    @DisplayName("수익과 지출한 돈의 퍼센트 계산이 잘 되는지 확인")
    @Test
    void returnPercentTest() {
        int profit = 5000;
        int expense = 8000;
        double temp = returnPercent(profit,expense);
        String result = String.valueOf(temp);
        assertThat(result).contains("62.5");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}