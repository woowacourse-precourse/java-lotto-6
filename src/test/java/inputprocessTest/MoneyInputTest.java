package inputprocessTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyInputTest {

    @DisplayName("구입금액 확인(정수/1000원 단위확인) 메소드 호출")
    @Test
    void moneyInputCheck() {
        // 실제로 moneyInput은 입력을 받은 문자열이다.
        String moneyInput = "8000t";
        checkint(moneyInput);

        String moneyInput2 = "8001";
        moneyAbleDivision(moneyInput2);

        String moneyInput3 = "8000";
        howMuchLottoGet(moneyInput3);
    }

    @DisplayName("정수값에 따라 몇개의 로또를 구매할 수 있는가??")
    @Test
    private void howMuchLottoGet(String moneyInput3) {
        int money = Integer.parseInt(moneyInput3);
        int getLotto = money / 1000;

        assertThat(getLotto).isEqualTo(8);
    }

    @DisplayName("문자열이 정수인지 확인하기 위한 메소드")
    @Test
    public boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @DisplayName("정수가 아닌 입력이 발생했을 시, IllegalArgumentException() 발생")
    @Test
    private void checkint(String moneyInput) {
        assertThatThrownBy(() ->{
            if( !isInteger(moneyInput) ) {
                throw new IllegalArgumentException("금액은 양의 정수로 입력해주세요.");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 양의 정수로 입력해주세요.");
    }

    @DisplayName("1000원 단위로 나눠지지 않는 입력 발생 시, IllegalArgumentException() 발생")
    @Test
    private void moneyAbleDivision(String moneyInput2) {
        int money = Integer.parseInt(moneyInput2);
        assertThatThrownBy(() ->{
            if( money % 1000 != 0) {
                throw new IllegalArgumentException("1000원 단위의 금액을 입력해주세요.");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 단위의 금액을 입력해주세요.");
    }
}
