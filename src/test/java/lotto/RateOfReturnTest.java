package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class RateOfReturnTest {
    @Test
    void calcRateOfReturnTest() {
        assertThat(RateOfReturn.calcRateOfReturn(Arrays.asList(0,0,1,2,0), 400000)).isEqualTo(400.0);
    }
}