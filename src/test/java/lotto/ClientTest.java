package lotto;

import lotto.domain.Client;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;


public class ClientTest {
    @DisplayName("입력된 구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputWrongUnitMoney(){
        //given
        int example = 3300;

        //when
        Throwable result = catchThrowable(()->{
            new Client(example);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또수익률 계산 정상작동확인")
    @Test
    void checkCalculateEarningRate(){
        //given
        Client client = new Client(95000);
        client.getResult().put(Prize.FORTH,1);
        client.getResult().put(Prize.FIFTH,1);

        //when
        double result = client.getEarningRate();

        //then
        assertThat(result).isEqualTo(57.9);
    }
}
