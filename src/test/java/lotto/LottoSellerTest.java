package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoSeller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class LottoSellerTest {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void notNumberAmountInput() {
        String userInput = "1000원";
        LottoSeller lottoSeller = new LottoSeller();
        assertThatThrownBy(() -> lottoSeller.getAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEADER + " 숫자만 입력해주세요.");
    }

    @DisplayName("입력한 구매 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void notDividedByLottoPrice() {
        String userInput = "1500";
        LottoSeller lottoSeller = new LottoSeller();
        assertThatThrownBy(() -> lottoSeller.getAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEADER + " " + LOTTO_PRICE + " 단위로만 입력하세요.");
    }

    @DisplayName("자동 생성한 로또에는 잘못된 번호가 없다.")
    @Test
    void checkValidAutoLottos() {
        LottoSeller lottoSeller = new LottoSeller();
        String validUserInput = "100000";
        int validAmount = lottoSeller.getAmount(validUserInput);
        assertThatCode(() -> lottoSeller.makeLottoPaper(validAmount)).doesNotThrowAnyException();
    }

    @DisplayName("구매 금액에 맞는 갯수의 자동 로또(로또 규칙에 맞는 번호를 가짐)를 생성한다.")
    @Test
    void giveLottosValidCountToUser() {
        String validUserInput = "2000";
        int validAmount = Integer.parseInt(validUserInput);
        LottoSeller lottoSeller = new LottoSeller();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .thenReturn(
                            List.of(1, 2, 3, 4, 5, 6),
                            List.of(7, 8, 9, 10, 11, 12)
                    );
            lottoSeller.getAmount(validUserInput);
            List<Lotto> lottos = lottoSeller.giveLotto();
            assertThat(lottos.size()).isEqualTo(validAmount / LOTTO_PRICE);
            assertThat(lottos.get(0).showNumbers()).isEqualTo(lotto1.showNumbers());
            assertThat(lottos.get(1).showNumbers()).isEqualTo(lotto2.showNumbers());
        }
    }
}
