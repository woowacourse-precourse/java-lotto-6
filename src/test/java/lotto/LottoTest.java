package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import lotto.constant.StateType;
import lotto.dto.LottoDto;
import lotto.model.domain.Lotto;
import lotto.model.repository.LottoRepository;
import lotto.model.service.LottoService;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void createLottoByOutofBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 65)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 맞는 개수의 로또를 할당한다.")
    @Test
    void createLottoByPurchaseAmountTest() {
        LottoService lottoService = new LottoService(new LottoRepository());
        LottoDto lottoDto = new LottoDto();

        lottoDto.setLottoPurchaseAmount("14000");
        lottoService.createLottos(lottoDto);

        assertThat(lottoService.getLottos().getAllLotto().size()).isEqualTo(14);
    }

    @DisplayName("정확한 수익률을 계산해야한다.")
    @Test
    void calculateProfitRateTest() {
        //given
        LottoRepository lottoRepository = new LottoRepository();
        LottoService lottoService = new LottoService(lottoRepository);
        LottoDto lottoDto = new LottoDto();

        //when
        lottoDto.setLottoPurchaseAmount("3000");
        lottoDto.setWinningNumbers("1,2,3,4,5,6");
        lottoDto.setBonusNumber("10");
        lottoService.createGame(lottoDto);

        lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 10)); // five match with bonus
        lottoRepository.saveLottos(List.of(13, 14, 15, 16, 17, 18)); // No match
        lottoRepository.saveLottos(List.of(1, 2, 3, 11, 12, 13)); // three match
        lottoService.compareLottosWithWinningNumbers();

        //then

        assertThat(String.format("%.1f", lottoService.getProfitRate())).isEqualTo("1000166.7");
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하고 결과를 저장한다.")
    @Test
    void compareLottosWithWinningNumbersTest() {
        //given
        LottoRepository lottoRepository = new LottoRepository();
        LottoService lottoService = new LottoService(lottoRepository);
        //when
        lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 6)); // SIX_MATCH
        lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 8)); // FIVE_MATCH_BONUS
        lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 7)); // FIVE_MATCH_NO_BONUS
        lottoRepository.saveLottos(List.of(1, 2, 3, 4, 8, 9));  // FOUR_MATCH
        lottoRepository.saveLottos(List.of(1, 2, 3, 7, 8, 9)); // THREE_MATCH
        lottoRepository.saveLottos(List.of(1, 2, 7, 8, 9, 10)); // NO_PRIZE

        lottoRepository.saveGame(List.of(1, 2, 3, 4, 5, 6), 8);
        lottoService.compareLottosWithWinningNumbers();
        HashMap<StateType, Integer> result = lottoService.getResult();
        //then;

        assertThat(result.get(StateType.SIX_MATCH)).isEqualTo(1);
        assertThat(result.get(StateType.FIVE_MATCH_BONUS)).isEqualTo(1);
        assertThat(result.get(StateType.FIVE_MATCH_NO_BONUS)).isEqualTo(1);
        assertThat(result.get(StateType.FOUR_MATCH)).isEqualTo(1);
        assertThat(result.get(StateType.THREE_MATCH)).isEqualTo(1);
    }

    @Nested
    class OutputViewTest {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;

        @BeforeEach
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void restoreStreams() {
            System.setOut(originalOut);
        }

        @DisplayName("생성된 로또 개수를 정상적으로 출력한다.")
        @Test
        void outputLottoCountTest() {
            LottoService lottoService = new LottoService(new LottoRepository());
            LottoDto lottoDto = new LottoDto();

            lottoDto.setLottoPurchaseAmount("14000");
            lottoService.createLottos(lottoDto);

            OutputView.outputLottoCount(lottoService.getLottos().getAllLotto());
            String output = outContent.toString();
            assertThat(output).contains("14개를 구매했습니다.");
        }

        @DisplayName("생성된 로또 번호를 정상적으로 출력한다.")
        @Test
        void outputLottoNumbersTest() {
            LottoRepository lottoRepository = new LottoRepository();

            lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 6));
            lottoRepository.saveLottos(List.of(2, 3, 4, 5, 6, 7));

            OutputView.outputAllLottoNumbers(lottoRepository.findLottos());

            String output = outContent.toString();
            assertThat(output).contains("[1, 2, 3, 4, 5, 6]", "[2, 3, 4, 5, 6, 7]");
        }

        @DisplayName("당첨 통계를 정확하게 출력한다.")
        @Test
        void outputResultTest() {
            //given
            LottoRepository lottoRepository = new LottoRepository();
            LottoService lottoService = new LottoService(lottoRepository);
            //when
            lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 6)); // SIX_MATCH
            lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 8)); // FIVE_MATCH_BONUS
            lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 7)); // FIVE_MATCH_NO_BONUS
            lottoRepository.saveLottos(List.of(1, 2, 3, 4, 8, 9));  // FOUR_MATCH
            lottoRepository.saveLottos(List.of(1, 2, 3, 7, 8, 9)); // THREE_MATCH
            lottoRepository.saveLottos(List.of(1, 2, 7, 8, 9, 10)); // NO_PRIZE

            lottoRepository.saveGame(List.of(1, 2, 3, 4, 5, 6), 8);
            lottoService.compareLottosWithWinningNumbers();
            OutputView.outputResult(lottoService.getResult());

            //then;
            String output = outContent.toString();
            assertThat(output).contains("3개 일치 (5,000원) - 1개"
                    , "4개 일치 (50,000원) - 1개"
                    , "5개 일치 (1,500,000원) - 1개"
                    , "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개"
                    , "6개 일치 (2,000,000,000원) - 1개");
        }

        @DisplayName("계산한 수익률을 출력한다.")
        @Test
        void outputProfitRateTest() {
            //given
            LottoRepository lottoRepository = new LottoRepository();
            LottoService lottoService = new LottoService(lottoRepository);
            LottoDto lottoDto = new LottoDto();

            //when
            lottoDto.setLottoPurchaseAmount("3000");
            lottoDto.setWinningNumbers("1,2,3,4,5,6");
            lottoDto.setBonusNumber("10");
            lottoService.createGame(lottoDto);

            lottoRepository.saveLottos(List.of(1, 2, 3, 4, 5, 10)); // five match with bonus
            lottoRepository.saveLottos(List.of(13, 14, 15, 16, 17, 18)); // No match
            lottoRepository.saveLottos(List.of(1, 2, 3, 11, 12, 13)); // three match
            lottoService.compareLottosWithWinningNumbers();
            OutputView.outputProfitRate(lottoService.getProfitRate());

            //then
            String output = outContent.toString();
            assertThat(output).contains("총 수익률은 1000166.7%입니다.");
        }
    }
}
