package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성한 로또 번호가 지정된 형식대로 출력되야 한다..")
    @Test
    void checkPrintNumber() {
        assertSimpleTest(() -> {
                    assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers().contains("[1, 2, 3, 4, 5, 6]"));
                }
        );
    }

    @DisplayName("생성한 로또 번호의 리스트를 그대로 반환해야 한다.")
    @Test
    void checkGetNumber() {
        assertSimpleTest(() -> {
                    assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers().contains(List.of(1, 2, 3, 4, 5, 6)));
                }
        );
    }

}