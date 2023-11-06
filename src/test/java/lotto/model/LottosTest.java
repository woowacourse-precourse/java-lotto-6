package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottosTest {


    @Test
    void 구매금액이_나누어떨어지는가(){
        assertThatThrownBy(() ->{
            Lottos lottos = new Lottos("1001");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_0이아닌가(){
        assertThatThrownBy(() ->{
            Lottos lottos = new Lottos("0");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
