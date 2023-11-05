package lotto.entity;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CostTest {

    public static final String errorPrefix="[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"999","12345",""," ","10 00","천원"})
    void Cost_생성_purchaseCost_예외_테스트(String purchaseCost){
        //when
        assertThatThrownBy(()->{
                new Cost(purchaseCost);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(errorPrefix);
    }
}
