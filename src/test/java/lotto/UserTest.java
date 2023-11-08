package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.User.LOTTO_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;


class UserTest {

    private  User user;

    @BeforeEach
    public void setUp() {
        this.user = new User();
    }

    @DisplayName("inputAmount 성공")
    @Test
    void inputAmount_success() {
        int allLottoPay = 3000;
        int haveSeveralLotto = allLottoPay/LOTTO_PRICE;
        int result = user.inputAmount(allLottoPay);

        assertThat(result).isEqualTo(haveSeveralLotto);
    }

    @DisplayName("로또 구입 금액이 천원 단위가 아닐 경우 예외 발생")
    @Test
    void inputAmount_fail_1() {
        int allLottoPay = 8500;
        assertThatThrownBy(() -> user.inputAmount(allLottoPay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액이 맞지 않습니다.");
    }

    @DisplayName("로또 구입 금액이 숫자가 아닐 경우 예외 발생")
    @Test
    void inputAmount_fail_2() {
        String allLottoPay = "8000;";
        assertThrows(IllegalArgumentException.class, () -> {
            user.inputAmount(Integer.parseInt(allLottoPay));
        });
    }

    @DisplayName("구매한 로또 개수 일치, 유효한 로또 번호 확인, 번호 6개 확인")
    @Test
    void saveLottos_success() {
        int allLottoPay = 5000;
        user.inputAmount(allLottoPay);
        List<Lotto> lottos = user.saveLottos();

        assertThat(lottos).hasSize(allLottoPay / Price.LOTTO.getLottoPrice());
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers())
                    .hasSize(6)
                    .doesNotHaveDuplicates()
                    .allMatch(number -> number >= 1 && number <= 45);
        }
    }

}