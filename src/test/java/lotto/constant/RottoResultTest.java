package lotto.constant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RottoResultTest {

    @Test
    void print_RottoResult(){
        assertThat(RottoResult.TWO.printRottoResult()).isEqualTo("5개 일치 (%,d원) - ");
    }

}