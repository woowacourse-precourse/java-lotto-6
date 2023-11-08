package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeListTest {
    MakeList makeList;

    @BeforeEach
    void beforeEach() {
        makeList = new MakeList();
    }

    @Test
    void 문자열을정수형리스트로변환테스트() {
        //given
        String testStr = "1,2,3,4,5,6";
        List<Integer> compare = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> result;
        //when
        result = makeList.makeStringToIntegerList(testStr);
        //then
        Assertions.assertThat(result).isEqualTo(compare);
    }
}