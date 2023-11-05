package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOutputViewTest {
    private final LottoOutputView lottoOutputView = new LottoOutputView();

    private static ByteArrayOutputStream outputMessage;
    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("로또 구매 결과 출력 테스트.")
    @Test
    void printLottoPurchaseResult() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(7,8,9,10,11,12));
        Lotto lotto3 = new Lotto(Arrays.asList(13,14,15,16,17,18));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoList.add(lotto3);

        lottoOutputView.printPublishedLottos(3, lottoList);

        assertThat("3개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[7, 8, 9, 10, 11, 12]\n"
                + "[13, 14, 15, 16, 17, 18]\n").isEqualTo(outputMessage.toString());
    }

}