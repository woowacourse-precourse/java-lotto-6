package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameScreenTest extends NsTest {
    @Test
    @DisplayName("로또 번호를 구입 횟수만큼 출력한다.")
    void print_created_lotto_numbers(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Test
    @DisplayName("입력된 문자열이 각각 숫자가 아니면 에러가 발생한다.")
    void is_input_win_number_digit(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,C,3,A,5,6", "1,2,3,4,5,6");
                    assertThat(output()).contains(
                      "[ERROR] 당첨 번호는 숫자로 입력해 주세요."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Test
    @DisplayName("입력된 문자열의 길이가 6이 아니면 에러가 발생한다.")
    void is_input_win_number_length_six(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6,7", "1,2,3,4,5,6");
                    assertThat(output()).contains(
                            "[ERROR] 당첨 번호는 6개여야 해요."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Test
    @DisplayName("입력된 문자열의 각 요소가 1~45 범위 안에 있지 않으면 에러가 발생한다.")
    void is_input_win_number_in_range(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,300,4,5,6", "1,0,3,4,5,6", "1,2,3,4,5,6");
                    assertThat(output()).contains(
                            "[ERROR] 각 번호는 1에서 45의 범위 안으로 입력해 주세요."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
