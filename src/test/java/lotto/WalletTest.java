package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {

    @DisplayName("로또 구입 금액은 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void addBalance_multiplesOfThousand_exception() {

        Wallet wallet = new Wallet();

        int testMoney = 1_500;

        assertThatThrownBy(() -> wallet.addBalance(testMoney))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 구입 금액은 1,000 ~ 100,000 사이가 아니라면 예외가 발생한다.")
    @Test
    void addBalance_range_exception() {

        Wallet wallet = new Wallet();

        int testMoney = 101_000;

        assertThatThrownBy(() -> wallet.addBalance(testMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("addBalance 값 검증 테스트")
    @Test
    void validateAddBalance() {

        Wallet wallet = new Wallet();

        int testMoney = 50_000;

        wallet.addBalance(testMoney);

        assertThat(wallet.getBalance()).isEqualTo(testMoney);
    }

    @DisplayName("buyAllLotto 값 검증 테스트")
    @Test
    void validateBuyAllLotto() {

        Wallet wallet = new Wallet();

        int testMoney = 10_000;
        wallet.addBalance(testMoney);

        wallet.buyAllLotto();

        assertThat(wallet.getBalance()).isEqualTo(10_000);
        assertThat(wallet.getLottos().size()).isEqualTo(10);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void uyLottoByOverSize() {

        Wallet wallet = new Wallet();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));

        assertThatThrownBy(() -> wallet.buyLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void uyLottoByDuplicatedNumber() {

        Wallet wallet = new Wallet();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,1));

        assertThatThrownBy(() -> wallet.buyLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 사이가 아니라면 예외가 발생한다.")
    @Test
    void buyLottoByLottoNumberRange() {

        Wallet wallet = new Wallet();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(0,2,3,4,5,46));

        assertThatThrownBy(() -> wallet.buyLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("buyLotto 값 검증 테스트")
    @Test
    void validateBuyLotto() {
        Wallet wallet = new Wallet();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        wallet.buyLotto(numbers);

        List<Lotto> results = wallet.getLottos();
        assertThat(results.size()).isEqualTo(1);

        Lotto result = results.get(0);
        assertThat(result.getNumbers()).isEqualTo(numbers);
    }
}
