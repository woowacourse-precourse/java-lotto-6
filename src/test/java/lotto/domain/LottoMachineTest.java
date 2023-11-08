package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    private LottoMachine lottoMachine;
    private Player player;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("로또를 구매하면 금액만큼의 갯수를 얻는다")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "5000,5", "8000,8", "10000,10"})
    void buy_lotto(int money, int expected) {
        lottoMachine = new LottoMachine(money);

        int lottoCount = lottoMachine.calculatePurchaseCount();

        assertThat(lottoCount).isEqualTo(expected);
    }

    @DisplayName("로또 구매를 1,000원 단위로 구매하지 않으면 에러")
    @ParameterizedTest
    @ValueSource(ints = {600, 1200, 2500, 3800})
    void error_buy_lotto(int money) {
        assertThatThrownBy(() -> new LottoMachine(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
    }

    @DisplayName("1~45범위 6개의 중복되지 않는 숫자를 생성")
    @Test
    void generate_lotto() {
        List<Integer> lotto = lottoMachine.generateLotto();

        assertThat(lotto.size()).isEqualTo(6);
        assertThat(lotto).doesNotHaveDuplicates();
    }

    @DisplayName("로또 구매 금액만큼 로또를 생성")
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 5000, 8000})
    void generatePlayerLotto(int money) {
        lottoMachine = new LottoMachine(money);
        player = lottoMachine.generatePlayerLotto();

        assertThat(player.getLottos().size()).isEqualTo(money/1000);
    }
}