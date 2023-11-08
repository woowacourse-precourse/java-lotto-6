package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @CsvSource({"3,0,FIFTH", "4,0,FOURTH", "5,0,THIRD", "5,1,SECOND", "6,0,FIRST"})
    void getResult(int hitsCnt, int bonusCnt, Result result) {
        assertThat(Result.getResult(new HitsNumber(hitsCnt, bonusCnt)))
                .isEqualTo(result);
    }
}