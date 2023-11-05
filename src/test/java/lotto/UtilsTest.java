package lotto;

import static lotto.Utils.getSortedList;
import static lotto.Utils.splitWithComma;
import static lotto.Utils.stringToInteger;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    @DisplayName("리스트 정렬을 테스트합니다.")
    void getSortedListTest() {
        List<Integer> result = getSortedList(new ArrayList<>(List.of(6, 3, 4, 2, 5, 1)));

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("comma로 나누는 테스트입니다.")
    void splitWithCommaTest() {
        String target = "1,2,3,4,5,6";
        List<String> answer = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6"));
        List<String> result = splitWithComma(target);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("숫자인 String으로 된 List를 Integer로 바꾸는 테스트입니다.")
    void stringToIntegerTest() {
        ArrayList<String> target = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6"));
        ArrayList<Integer> result = stringToInteger(target);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
