package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransformTest {

    @Test
    void 입력값_리스트로_분할_테스트() {
        //given
        String input = "1,2,3,4,5";
        List<Integer> result;
        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5);
        //when
        Transform transform = new Transform();
        result = transform.winningNumberToList(input);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}