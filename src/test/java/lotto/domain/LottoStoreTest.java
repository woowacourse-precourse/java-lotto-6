package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;


class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void beforeAction() {
        lottoStore = new LottoStore();
    }

    @DisplayName("숫자가 아닌값이 들어오면 예외발생")
    @Test
    void buyLottoTicketsTest() {
        assertThatThrownBy(() -> lottoStore.buyLottoTickets("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void makeLottoReceiptTest() {
        lottoStore.buyLottoTickets("8000");
        Lotto lotto = Lotto.createLotto("1,2,3,4,5,6");
        lottoStore.noticeWinningNumber(lotto, 7);
        System.out.println(lottoStore.makeLottoReceipt());
        String patternString = """
                3개 일치 \\(5,000원\\) - \\d개
                4개 일치 \\(50,000원\\) - \\d개
                5개 일치 \\(1,500,000원\\) - \\d개
                5개 일치, 보너스 볼 일치 \\(30,000,000원\\) - \\d개
                6개 일치 \\(2,000,000,000원\\) - \\d개
                총 수익률은 \\d+\\.\\d+%입니다.""";
        Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
        boolean matches = pattern.matcher(lottoStore.makeLottoReceipt()).matches();
        assertThat(matches).isTrue();


    }
}