package lotto.broadcaster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BroardcasterTest {

    void provideRemoteInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("당첨 번호를 입력 받는다. 당첨 번호는 쉼표(,)를 기준으로 구분한다.")
    @Test
    void 당첨번호_입력() throws Exception {
        //given
        Broardcaster broadcaster = new Broardcaster();
        String input = "1,2,3,4,5,6";
        String[] expected = {"1", "2", "3", "4", "5", "6"};

        //when
        provideRemoteInput(input);
        String[] pickedNumbers = broadcaster.pickLotteryNumber();

        //then
        assertThat(pickedNumbers).isEqualTo(expected);
    }

}