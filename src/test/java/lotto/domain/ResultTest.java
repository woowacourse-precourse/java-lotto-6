package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("당첨 결과를 세팅하고 등수를 저장한 배열을 반환")
    @Test
    void getResult() {
        Result result = new Result();
        List<Prize> prizes = List.of(Prize.FIFTH,Prize.FIRST,Prize.THIRD);
        result.setResult(prizes);
        int[] expected = new int[]{1,0,1,0,1};

        assertThat(result.getResult()).isEqualTo(expected);
    }

}