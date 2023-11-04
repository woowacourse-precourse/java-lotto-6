package lotto;

import lotto.domain.Lotto;
import lotto.dto.LottoTicketsDTO;
import lotto.view.OutputView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketOutputTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("발행한 로또 수량 및 로또 번호를 형식에 맞게 출력하는 지 테스트한다.")
    void 발행_로또_수량_및_번호_테스트() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(lotto1);
        lottoTickets.add(lotto2);
        LottoTicketsDTO lottoTicketsDTO = new LottoTicketsDTO(lottoTickets.size(), lottoTickets);
        // when
        // then

        OutputView.printLottoTickets(lottoTicketsDTO);
        assertThat(outputMessage.toString()).contains(
                "2개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]"
        );
    }
}
