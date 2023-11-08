package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    Statistics statistics;
    List<Lotto> userLottos;
    Lotto winLotto;
    int bonusNumber;

    @BeforeEach
    void init() {
        Lotto userLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto userLotto3 = new Lotto(List.of(2, 3, 4, 5, 6, 8));
        Lotto userLotto4 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto userLotto5 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        userLottos = List.of(userLotto1, userLotto2, userLotto3, userLotto4, userLotto5);
        winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;

        statistics = new Statistics(userLottos, winLotto, bonusNumber);
    }

    @DisplayName("사용자 번호와 당첨 번호가 같은 개수 반환")
    @Test
    void countMatch() {
        long count = statistics.countMatch(userLottos.get(0).getNumbers());

        assertThat(count).isEqualByComparingTo(6L);
    }

    @DisplayName("사용자 번호와 당첨 번호 6개가 맞을 경우 1을 반환한다.")
    @Test
    void isSixMatch() {
        int result = statistics.isSixMatch(userLottos.get(0).getNumbers());

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("사용자 번호와 당첨 번호 5개와 보너스 번호가 맞을 경우 1을 반환한다.")
    @Test
    void isFiveBonusMatch() {
        int result = statistics.isFiveBonusMatch(userLottos.get(1).getNumbers());

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("사용자 번호와 당청 번호 5개가 맞고 보너스 번호는 맞지 않을 경우 1을 반환한다.")
    @Test
    void isFiveMatch() {
        int result = statistics.isFiveMatch(userLottos.get(2).getNumbers());

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("사용자 번호와 당청 번호 4개가 맞을 경우 1을 반환한다.")
    @Test
    void isFourMatch() {
        int result = statistics.isFourMatch(userLottos.get(3).getNumbers());

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("사용자 번호와 당청 번호 3개가 맞을 경우 1을 반환한다.")
    @Test
    void isThreeMatch() {
        int result = statistics.isThreeMatch(userLottos.get(4).getNumbers());

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("1등 당첨 횟수 확인")
    @Test
    void getSixNumberMatch() {
        int result = statistics.getSixNumberMatch();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("2등 당첨 횟수 확인")
    @Test
    void getFiveBonusNumberMatch() {
        int result = statistics.getFiveBonusNumberMatch();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("3등 당첨 횟수 확인")
    @Test
    void getFiveNumberMatch() {
        int result = statistics.getFiveNumberMatch();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("4등 당첨 횟수 확인")
    @Test
    void getFourNumberMatch() {
        int result = statistics.getFourNumberMatch();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("5등 당첨 횟수 확인")
    @Test
    void getThreeNumberMatch() {
        int result = statistics.getThreeNumberMatch();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("수익률 계산 확인")
    @Test
    void getRateOfReturn() {
        double result = statistics.getRateOfReturn(5000);

        assertThat(result).isEqualTo(4.06311E7);
    }
}