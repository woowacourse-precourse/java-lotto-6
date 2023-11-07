package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("보너스 번호가 숫자가 아닌 값을 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "a1"})
    void check_bonus_number_nmeric(String bonusNumber) {
        System.setIn(createUserInput(bonusNumber));
        assertThatThrownBy(InputView::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 입력해야합니다.");
    }

    @DisplayName("보너스 번호에 1~45 사이가 아닌 숫자를 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void check_bonus_number_range(int bonusNumber) {
        assertThatThrownBy(() -> BonusNumber.from(bonusNumber, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자는 1~45 사이의 숫자여야합니다.");
    }

    @DisplayName("보너스 번호에 당첨번호와 중복인 숫자를 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void check_bonus_duplicates(int bonusNumber) {
        assertThatThrownBy(() -> BonusNumber.from(bonusNumber, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
