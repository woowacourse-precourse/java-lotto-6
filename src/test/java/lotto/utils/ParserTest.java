package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParserTest {

    @Test
    public void 문자열정수리스트변환테스트(){
        Parser parser = new Parser();

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = parser.translatePlayerInputStringToInt("1,2,3,4,5");

        Assertions.assertThat(list1).isEqualTo(list2);
    }

    @Test
    public void 문자열정수변환테스트(){
        Parser parser = new Parser();

        int test = 123;
        int test2 = parser.stringToInteger("123");

        Assertions.assertThat(test).isEqualTo(test2);
    }
}
