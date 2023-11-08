package service;

import model.User;
import model.WinningNumber;
import org.junit.jupiter.api.Test;

import model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또번호 생성기 테스트")
    @Test
    void generateLottoNumber() {
        Lotto lotto = lottoService.generateLottoNumber();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 순위 계산 시스템 테스트")
    @Test
    void calculateRanking() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningLotto = new WinningNumber(List.of(1, 2, 3, 4, 5, 6),7);
        Map<String,Integer> rank = lottoService.calculateRanking(lotto, winningLotto);
        assertThat(rank.get("count")).isEqualTo(6);
        assertThat(rank.get("bonus")).isEqualTo(0);
    }

    @DisplayName("수익률 계산기 테스트")
    @Test
    void rateReturn() {
        String rate = lottoService.rateReturn(40000,1000);
        assertThat(rate).isEqualTo("4000.0");
    }
}