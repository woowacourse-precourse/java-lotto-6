package lotto.unitTest;

import lotto.service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {5000,8000})
    public void testCalculateRateOfReturn(int purchaseAmount){
        double rateOfReturn = (double) 10000 / purchaseAmount * 100;

        System.out.println(rateOfReturn);

    }
}
