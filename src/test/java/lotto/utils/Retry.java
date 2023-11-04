package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

public class Retry {
    public void performInput(Callable callable) {
        boolean isValid = false;
        while(!isValid) {
            try {
                callable.performInput();
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    int i = 0;
    @Test
    void asd() {
        performInput(() -> {
            if(i != 10) {
                i++;
                throw new IllegalArgumentException();
            }
        });
        assertThat(i).isEqualTo(10);
    }
}
