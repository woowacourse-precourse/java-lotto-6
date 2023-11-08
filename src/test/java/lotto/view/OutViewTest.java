package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.RateOfReturn;
import lotto.domain.WinningResult;
import lotto.dto.LottoTicketsDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.controller.LottoGame.makeWinningStatisticsDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class OutViewTest {
    @DisplayName("발행한 로또 수량 및 번호를 출력하는 기능 테스트")
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

    @DisplayName("당첨 내용과 수익률 출력 테스트")
    public class WinningStatisticsOutputTest {

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
        @DisplayName("당첨 내용과 수익률 출력 테스트")
        void 당첨내용_수익률_테스트() {
            // given

            //1,2,3,4등 한번 씩 했다.
            WinningResult winningResult = new WinningResult();
            winningResult.addNumberOfPrizeFromIndex(1);
            winningResult.addNumberOfPrizeFromIndex(2);
            winningResult.addNumberOfPrizeFromIndex(3);
            winningResult.addNumberOfPrizeFromIndex(4);

            RateOfReturn rateOfReturn = new RateOfReturn(50.0f); //수익률은 50프로

            // when
            OutputView.printWinningStatistics(makeWinningStatisticsDTO(winningResult, rateOfReturn.getRateOfReturn()));
            // then

            assertThat(outputMessage.toString()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 50.0%입니다."
            );
        }
    }
}
