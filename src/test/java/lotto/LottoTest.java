package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Reward;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만인 경우 예외가 발생한다.")
    @Test
    void createLottoByNotEnoughSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위를 넘어간 숫자가 있으면 에외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 출력 시 콤마와 정해진 접두사와 접미사를 사용해 출력한다.")
    @Test
    void printLottoByTemplate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        System.out.print(lotto.getLottoPrintMessage());
        assertEquals("[1, 2, 3, 4, 5, 6]", outputMessage.toString());
    }

    @DisplayName("번호가 로또 안에 포함된 경우 확인 할 수 있다.")
    @Test
    void isNumberContainByExistNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int testNumber = 1;
        assertThat(lotto.isNumberContain(testNumber)).isTrue();
    }

    @DisplayName("번호가 로또 안에 포함되지 않은 경우 확인 할 수 있다.")
    @Test
    void isNumberContainByNonExistNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int testNumber = 7;
        assertThat(lotto.isNumberContain(testNumber)).isFalse();
    }

    @DisplayName("구매한 로또를 당첨 로또와 비교하여 당첨 등수와 당첨금액을 확인 할 수 있다.")
    @Test
    void getLottoResultByFirstResult() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto, new BonusNumber("7"));

        Reward reward = lotto.getLottoResult(winningLotto);
        assertThat(reward.name()).isEqualTo("FIRST");
        assertThat(reward.getRewardMoney()).isEqualTo(2_000_000_000);
    }
}