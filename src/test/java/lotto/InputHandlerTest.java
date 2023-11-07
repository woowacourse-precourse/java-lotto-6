package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class InputHandlerTest {
    @DisplayName("split 메서드로 주어진 값을 구분한다.")
    @Test
    void splitLottoNumbers() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

//    @DisplayName("올바르지 않은 숫자 형식을 입력했을 때 예외가 발생한다.")
//    @Test
//    void inputInvalidNumberFormat() {
//
//    }
}
