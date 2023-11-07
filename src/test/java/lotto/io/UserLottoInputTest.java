package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.MatchDetail;
import lotto.domain.WinningNumbers;
import lotto.exception.InvalidMoneyInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserLottoInputTest {
    public void setupInputStream(String inputString) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(byteArrayInputStream);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100b", "1000 ", "10 a"})
    @DisplayName("올바르지 않은 돈 입력이 들어오면 예외를 발생한다.")
    public void invalidMoneyInput(String in) {
        setupInputStream(in);
        UserLottoInput input = new UserLottoInput();

        assertThatThrownBy(() -> input.getMoneyAmount())
                .isInstanceOf(InvalidMoneyInput.class);
    }

    @Test
    @DisplayName("입력을 통해 올바르게 당첨 로또를 받아낸다.")
    public void getWinningNumbers() {
        setupInputStream("1,2,3,4,5,6\n7");
        // given
        UserLottoInput input = new UserLottoInput();
        // when
        WinningNumbers winningNumbers = input.getWinningNumbers();
        // then
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoBall::new)
                .toList());
        MatchDetail match = winningNumbers.match(lotto);

        assertThat(match.matchedBonus()).isTrue();
        assertThat(match.matchedCount()).isEqualTo(5);
    }

    @AfterEach
    public void tearDown() {
        Console.close();
    }
}
