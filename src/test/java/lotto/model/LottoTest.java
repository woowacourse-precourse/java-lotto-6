package lotto.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 생성 시 형식을 지키지 않으면 예외 발생.")
    @Test
    void createLottoByIllegalFormat() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 발행한 로또 번호 중 같은 번호 개수를 테스트.")
    @Test
    void countMatchTest() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .countMatch(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        ).isEqualTo(6);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});}

}