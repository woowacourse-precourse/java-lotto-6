package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        ResultRepository resultRepository = new ResultRepository();
        resultRepository.init();
        Calculator calculator = new Calculator();
        //given
        resultRepository.save(Rank.FIFTH);
        resultRepository.save(Rank.OUT);
        resultRepository.save(Rank.OUT);
        resultRepository.save(Rank.FIFTH);

        //when
        double rateOfReturn = calculator.getRateOfReturn();

        //then
        Assertions.assertThat(rateOfReturn).isCloseTo(250.0, Percentage.withPercentage(0.1));

    }

}