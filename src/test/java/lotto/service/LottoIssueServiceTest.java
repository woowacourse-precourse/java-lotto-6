package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssueServiceTest {
    LottoIssueService service;

    @BeforeEach
    void init() {
        service = new LottoIssueService();
    }

    @Test
    @DisplayName("주어진 횟수가 유효하다면 그 크기만큼의 로또를 발행한다.")
    public void createLottosByValidCount() {
        Lottos lottos = service.issueLottos(10);
        assertThat(lottos.getIssuedLottos().size())
                .isEqualTo(10);
    }

    @Test
    @DisplayName("주어진 횟수가 음수이면 예외가 발생한다.")
    public void createLottosByInvalidCount() {
        assertThatThrownBy(() -> service.issueLottos(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}