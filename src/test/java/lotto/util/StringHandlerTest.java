package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringHandlerTest {

    @DisplayName(",기준으로 분리된 문자열을 , 기준으로 정렬 된 List<Integer>로 변환한다.")
    @Test
    void stringToList() {
        String input = "3,2,1,4,5,6";
        List<Integer> expectationOutput = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> changedInput = StringHandler.separatedWith(input, ",");

        System.out.println(changedInput);
    }
}
