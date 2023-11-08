package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utility.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Result Domain 테스트")
public class ResultTest {
    private Result result;

    @BeforeEach
    public void initTest() {
        result = new Result();
    }

    @Test
    @DisplayName("addCount() method 테스트")
    public void addCountTest() {
        // when
        result.addCount();

        // then
        assertThat(result.getCount()).isEqualTo(CONSTANT_ONE.getConstant());
    }

    @Test
    @DisplayName("getCount() method 테스트")
    public void getCountTest() {
        // when
        int count = result.getCount();

        // then
        assertThat(count).isEqualTo(CONSTANT_ZERO.getConstant());
    }
}
