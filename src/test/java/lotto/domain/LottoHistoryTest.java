package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoHistoryTest {

    LottoHistory history = new LottoHistory();

    @DisplayName("로또를 로또저장소에 저장한 후 발행 내역을 출력한다.")
    @Test
    void createLottoAndLottoStoreHistory() {
        Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto.createLotto(List.of(1, 2, 3, 20, 23, 27));

        String lottoHistory = history.getLottoHistory();

        assertThat(lottoHistory).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"+
                        "[1, 2, 3, 20, 23, 27]\n"
        );
    }

}