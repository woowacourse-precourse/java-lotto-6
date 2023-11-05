package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @DisplayName("문자열을 정수형으로 바꾸고 반환한다.")
    @Test
    void stringToInteger() {
        String amount = "3000";
        int expected = 3000;

        int actual = Utils.stringToInteger(amount);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열을 리스트로 바꾸고 반환한다.")
    @Test
    void stringToList() {
        String prize = "1,2,3,4,5,6";
        List<Integer> expected = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};

        List<Integer> actual = Utils.stringToList(prize);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열을 쉼표(,)를 기준으로 나눈다.")
    @Test
    void stringToSplit() {
        String prize = "1,2,3,4,5,6";
        String[] expected = {"1", "2", "3", "4", "5", "6"};

        String[] actual = Utils.stringToSplit(prize);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("1부터 45사이의 숫자인지 확인한다.")
    @Test
    void is1And45() {
        int bonus = 45;

        boolean actual = Utils.is1And45(bonus);

        assertThat(actual).isTrue();
    }
}