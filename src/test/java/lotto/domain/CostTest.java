package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CostTest {

    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp(){
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }


    @DisplayName("금액으로 수량을 계산한다.")
    @Test
    void getQuantity(){
        //given
        Cost cost = new Cost(13000);

        //when
        int quantity = cost.getQuantity();

        //then
        assertThat(quantity).isEqualTo(13);
    }

    @DisplayName("주어진 금액익 1000단위가 아니면 예외가 발생한다")
    @Test
    void createCostWithNotThousandUnit(){
        //given
        int cost = 1200;

        //when //then
        assertThatThrownBy(() -> new Cost(cost))
                .isInstanceOf(IllegalArgumentException.class);
    }

}