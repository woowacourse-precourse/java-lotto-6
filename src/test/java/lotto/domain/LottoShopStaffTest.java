package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoShopStaff;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoShopStaffTest {
    @ParameterizedTest
    @DisplayName("로또 금액 지불 실패 테스트 - 구입할 수 없는 금액")
    @ValueSource(ints = {-10_000, -1_000, 0})
    void payOfLottoTicketsImpossiblePayAmountTest(int amount) {
        LottoShopStaff lottoShopStaff = new LottoShopStaff();
        assertThrows(IllegalArgumentException.class, () -> lottoShopStaff.payOfLottoTickets(amount));
    }

    @ParameterizedTest
    @DisplayName("로또 금액 지불 실패 테스트 - 구매 금액 단위 맞지 않음")
    @ValueSource(ints = {1, 11, 111, 1_111, 11_111})
    void payOfLottoTicketsNotCorrectPayAmountTest(int amount) {
        LottoShopStaff lottoShopStaff = new LottoShopStaff();
        assertThrows(IllegalArgumentException.class, () -> lottoShopStaff.payOfLottoTickets(amount));
    }
}
