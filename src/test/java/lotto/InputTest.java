package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static lotto.Input.*;
import static lotto.Input.input_bonus;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @AfterEach
    void reset_input(){
        Console.close();
    }

    void setInputValues(String s_input) {
        ByteArrayInputStream in = new ByteArrayInputStream(s_input.getBytes());
        System.setIn(in);
    }


    @DisplayName("당첨 번호에 1보다 작거나 45보다 큰 숫자를 넣으면 예외가 발생한다.")
    @ValueSource(strings = {"0,2,3,4,5,46"})
    @ParameterizedTest
    void Lower1OrBigger45(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> input_winner())
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구입 금액이 천원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"4500"})
    @ParameterizedTest
    void divide_1000(String input) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> input_price());
    }

    @DisplayName("보너스 번호가 당첨 번호에 있는 번호면 예외가 발생한다.")
    @ValueSource(strings = {"2"})
    @ParameterizedTest
    void bonus_num_dup_test(String input) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성

        winner = List.of(1,2,3,4,5,6);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> input_bonus())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한.")
    @ValueSource(strings = {"46"})
    @ParameterizedTest
    void bonus_num_range_test(String input) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        winner = List.of(1,2,3,4,5,6);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> input_bonus())
                .isInstanceOf(IllegalArgumentException.class);
    }



    // 아래에 추가 테스트 작성 가능
}

