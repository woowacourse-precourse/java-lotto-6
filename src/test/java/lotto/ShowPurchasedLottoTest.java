package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowPurchasedLottoTest {

    @DisplayName("구매한 로또에 대해, 정확한 값이 나오는 지 테스트")
    @Test
    void TestShowPurchasedLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        List<Lotto> purchasedLottos = new ArrayList<>();

        purchasedLottos.add(lotto1);
        purchasedLottos.add(lotto2);
        purchasedLottos.add(lotto3);
        purchasedLottos.add(lotto4);

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        showPurchasedLottos(purchasedLottos);

        String expected_result =
                "4개를 구매했습니다.\n" +
                        "[1, 2, 3, 4, 5, 7]\n" +
                        "[1, 2, 3, 4, 5, 8]\n" +
                        "[1, 2, 3, 4, 5, 9]\n" +
                        "[1, 2, 3, 4, 5, 10]\n";

        assertEquals(expected_result, outputStreamCaptor.toString());

    }
}
