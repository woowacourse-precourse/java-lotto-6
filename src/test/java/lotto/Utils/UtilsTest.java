package lotto.Utils;

import static lotto.Utils.Utils.calculatePercentage;
import static lotto.Utils.Utils.getSortedList;
import static lotto.Utils.Utils.splitWithComma;
import static lotto.Utils.Utils.stringToInteger;
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

    @Test
    @DisplayName("수익률을 계산하는 메서드를 테스트합니다.")
    void calculateProfitTest() {
        int money = 5000;
        int totalIncome = 5000;
        double result = calculatePercentage(totalIncome, money);
        double answer = 100.0;

        assertThat(result).isEqualTo(answer);

    }
}
