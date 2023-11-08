package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Lotto_WalletTest {
    // setter test
    @Test
    void setLottos() {
        Lotto_Wallet Wallet = new Lotto_Wallet();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> Wallet.setLottos(lotto));
    }

    @Test
    void check_All_Lotto() {
        Lotto_Wallet Wallet = new Lotto_Wallet();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Wallet.setLottos(lotto);
        assertDoesNotThrow(() -> Wallet.Check_All_Lotto(lotto, 7));
    }

    @Test
    void result_Print() {
        Lotto_Wallet Wallet = new Lotto_Wallet();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Wallet.setLottos(lotto);
        Wallet.Check_All_Lotto(lotto, 7);
        assertDoesNotThrow(() -> Wallet.Result_Print());
    }

    @Test
    void print_Return() {
        Lotto_Wallet Wallet = new Lotto_Wallet();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Wallet.setLottos(lotto);
        Wallet.Check_All_Lotto(lotto, 7);
        assertDoesNotThrow(() -> Wallet.print_Return(3));
    }
}