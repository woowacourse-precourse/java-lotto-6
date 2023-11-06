package lotto.view;

import lotto.Lotto;
import lotto.global.LottoOutputMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static lotto.global.LottoOutputMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoOutputViewTest {

    private LottoOutputView lottoOutputView;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        lottoOutputView = new LottoOutputView();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void clear() {
        output.reset();
    }

    @Test
    @DisplayName("생성된 로또 출력 테스트")
    public void 생성된_로또_출력_테스트() {
        LottoOutputView lottoOutputView = new LottoOutputView();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto, otherLotto));

        StringBuffer expectedResult = new StringBuffer();
        expectedResult.append("\n")
                .append(lottos.size())
                .append(PURCHASED_LOTTO_COUNT.getMessage())
                .append("\n");

        for (Lotto l : lottos) {
            expectedResult.append(l)
                    .append("\n");
        }

        lottoOutputView.presentLottoList(List.of(lotto, otherLotto));

        assertThat(output.toString()).isEqualTo(expectedResult.toString());
    }

}
