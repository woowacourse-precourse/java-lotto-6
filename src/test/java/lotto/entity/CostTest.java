package lotto.entity;

import static org.assertj.core.api.Assertions.*;

import lotto.property.MethodProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

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

    @Test
    void Cost_생성_유효한_값인_경우_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        String inputPurchaseCost = "8000";
        Long targetCost = Long.parseLong(inputPurchaseCost);

        //when
        Cost cost = new Cost(inputPurchaseCost);
        Long purchaseCost = cost.getFieldValue(MethodProperty.PURCHASE_COST);

        //then
        assertThat(purchaseCost).isEqualTo(targetCost);
    }
}
