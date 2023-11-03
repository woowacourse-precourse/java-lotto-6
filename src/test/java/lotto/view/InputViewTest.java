package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("당첨 번호를 문자열로 입력받으면 리스트로 반환한다.")
    @Test
    void inputWinningNumbers(){
        //given
        InputView inputView = new InputView();
        System.setIn(input("1,2,3,4,5,6"));

        //when
        List<String> numbers = inputView.inputWinningNumbers();

        //then
        assertThat(numbers).hasSize(6)
                .isEqualTo(Arrays.asList("1", "2", "3", "4", "5","6"));
    }

    InputStream input(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}