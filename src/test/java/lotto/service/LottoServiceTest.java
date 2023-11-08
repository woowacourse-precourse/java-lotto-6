package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    @DisplayName("구입 금액 입력 받기 성공")
    @Test
    public void inputMoneySuccess(){
        String input = "80000";
        assertThat(inputMoney(input)).isEqualTo(80000);
    }

    @DisplayName("구입 금액 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    public void inputMoneyNotNumber(){
        String input = "81100a";

        assertThatThrownBy(() -> inputMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 입력이 천원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    public void inputMoneyNotThousand(){
        String input = "81100";

        assertThatThrownBy(() -> inputMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private int inputMoney(String input){
        int money;
        try{
            money = Integer.parseInt(input);
            if(money % 1000 != 0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
        return money;
    }
}
