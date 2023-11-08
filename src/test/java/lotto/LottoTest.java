package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.dto.LottoDto;
import lotto.model.domain.Lotto;
import lotto.model.repository.LottoRepository;
import lotto.model.service.LottoService;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void createLottoByOutofBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 65)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
