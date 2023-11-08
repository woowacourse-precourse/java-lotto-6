package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력기 테스트")
class InputReaderTest {
    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        inputReader = new InputReader();
        Console.close();
    }

    @DisplayName("구입 금액 입력 테스트")
    @Test
    void testReadPurchaseAmount() {
        System.setIn(new ByteArrayInputStream("10000\n".getBytes()));
        PurchaseAmount purchaseAmount = inputReader.readPurchaseAmount();
        assertThat(purchaseAmount.calculateAffordableCountOfLotto()).isEqualTo(10);
    }

    @DisplayName("당첨 번호 입력 테스트")
    @Test
    void testReadLotto() {
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6\n".getBytes()));
        Lotto lotto = inputReader.readLotto();
        assertThat(lotto.mapToSortedIntegers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Test
    void testReadBonusNumber() {
        System.setIn(new ByteArrayInputStream("7\n".getBytes()));
        LottoNumber bonusNumber = inputReader.readBonusNumber();
        assertThat(bonusNumber.getValue()).isEqualTo(7);
    }
}