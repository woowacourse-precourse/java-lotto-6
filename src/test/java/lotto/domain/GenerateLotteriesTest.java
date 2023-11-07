package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateLotteriesTest {

    @Test
    void count수_만큼_로또_생성() {
        GenerateLotteries generateLotteries = new GenerateLotteries(5);
        int expect = generateLotteries.getLotteries().size();
        int result = 5;
        assertThat(expect).isEqualTo(result);
    }


}