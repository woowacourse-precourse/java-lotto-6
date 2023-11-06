package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PriceInputTest extends TestFunc {
    LottoInput lottoInput = new LottoInput();
    private static final String ERROR_MESSAGE = "[ERROR]";
    PlayLotto playLotto = new PlayLotto();

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void LottoPriceDivisionByThousand() {
        assertSimpleTest(() -> {
            runPriceException("999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 0이하의 수거나 빈칸이나 문자같은 옳지않은 형식의 값은 들어올 수 없다.")
    @Test
    void LottoPriceWrongFormat() {
        assertSimpleTest(() -> {
            runPriceException("abcd");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void LottoPriceWrongFormat2() {
        assertSimpleTest(() -> {
            runPriceException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void LottoPriceWrongFormat3() {
        assertSimpleTest(() -> {
            runPriceException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void LottoPriceWrongFormat4() {
        assertSimpleTest(() -> {
            runPriceException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    public void runPrice() {
        lottoInput.getLottoPrice(new String[]{});
    }

    public void runWinning() {
        lottoInput.getWinningNum(new String[]{});
    }
    public void runBonus() {
        lottoInput.getBonusNum(new String[]{});
    }
    public void runBonus2(List<Integer> a1 , int a){
        playLotto.CheckWinningAndBonus(a1, a);
    }

}

