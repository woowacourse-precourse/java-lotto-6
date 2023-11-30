package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.*;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.Condition;
import lotto.constant.Message;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Prize;
import lotto.domain.Procedure;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class LottoTest {
    Procedure procedure;
    Prize prize;
    @Mock
    InputView inputView = mock(InputView.class);
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    private final LottoController lottoController = new LottoController(lottoService, outputView, inputView);

    DecimalFormat commaWithThousand = new DecimalFormat("#,###");

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

    // 아래에 추가 테스트 작성 가능

    @Test
    void 정상_금액_입니다() {
        procedure = Procedure.PURCHASE_LOTTO;
        assertAll(
                () -> procedure.checkPossibleError(List.of(12_000)),
                () -> procedure.checkPossibleError(List.of(1000)),
                () -> procedure.checkPossibleError(List.of(143_000))
        );


    }

    @Test
    void 금액은_한_개만_넣어주세요() {
        procedure = Procedure.PURCHASE_LOTTO;
        assertAll(
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1, 2, 3)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NOT_ONE_NUMBER),
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(12_000, 1, 1, 1, 1, 1)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NOT_ONE_NUMBER)
        );

    }

    @Test
    void 금액은_0보다_커야_합니다() {
        procedure = Procedure.PURCHASE_LOTTO;
        assertThatThrownBy(() -> procedure.checkPossibleError(List.of(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_MONEY_CAN_NOT_BE_ZERO);
    }

    @Test
    void 금액은_1000원_단위여야_합니다() {
        procedure = Procedure.PURCHASE_LOTTO;
        assertAll(
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1200)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NOT_IN_THOUSANDS),
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(3451)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NOT_IN_THOUSANDS)
        );

    }

    @Test
    void 정상적인_당첨_번호입니다() {
        procedure = Procedure.DRAW_WINNING_NUMBERS;
        assertAll(
                () -> procedure.checkPossibleError(List.of(1, 2, 3, 4, 5, 6)),
                () -> procedure.checkPossibleError(List.of(1, 30, 45, 20, 16, 33)),
                () -> procedure.checkPossibleError(List.of(45, 2, 33, 20, 11, 19))
        );
    }


    @Test
    void 당첨번호는_6_자리여야_합니다() {
        procedure = Procedure.DRAW_WINNING_NUMBERS;
        assertAll(
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1, 2, 3)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NOT_SIX_WINNING_NUMBERS),
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(10_000)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NOT_SIX_WINNING_NUMBERS)
        );
    }

    @Test
    void 당첨번호는_1부터_45_사이의_수여야_한다() {
        procedure = Procedure.DRAW_WINNING_NUMBERS;
        assertAll(
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1, 23, 11, 30, 50, 40)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1, 22, 3, 16, 0, 44)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NUMBER_OUT_OF_RANGE)
        );
    }

    @Test
    void 당첨번호는_중복될_수_없습니다() {
        procedure = Procedure.DRAW_WINNING_NUMBERS;
        assertAll(
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1, 2, 3, 4, 5, 5)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_DUPLICATED_NUMBER),
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(1, 11, 11, 11, 11, 11)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_DUPLICATED_NUMBER)
        );
    }

    @Test
    void 정상_보너스_번호입니다() {
        procedure = Procedure.DRAW_BONUS_NUMBER;
        assertAll(
                () -> procedure.checkPossibleError(List.of(1)),
                () -> procedure.checkPossibleError(List.of(45)),
                () -> procedure.checkPossibleError(List.of(20))
        );
    }

    @Test
    void 보너스_번호도_1에서_45사이의_수입니다() {
        procedure = Procedure.DRAW_BONUS_NUMBER;
        assertAll(
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(0)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> procedure.checkPossibleError(List.of(46)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.ERROR_NUMBER_OUT_OF_RANGE)
        );
    }

    @Test
    void 정상_입력일_경우_리스트를_반환합니다() {
        String input = "1, 2, 3, 4, 5"; // given

        List<Integer> output = lottoService.parseInputToNumberCandidates(input); // when

        assertEquals(output, List.of(1, 2, 3, 4, 5)); // then

        input = "0, 1, 400, 2147483647";

        output = lottoService.parseInputToNumberCandidates(input);

        assertEquals(output, List.of(0, 1, 400, 2_147_483_647));


    }

    @Test
    void 부호없는_정수로_바꿀_수_없어요() {
        assertAll(
                () -> assertThatThrownBy(() -> lottoService.parseInputToNumberCandidates("-1"))
                        .isInstanceOf(NumberFormatException.class),
                () -> assertThatThrownBy(() -> lottoService.parseInputToNumberCandidates("숫자가 아니네요"))
                        .isInstanceOf(NumberFormatException.class),
                () -> assertThatThrownBy(() -> lottoService.parseInputToNumberCandidates("1, , 2"))
                        .isInstanceOf(NumberFormatException.class),
                () -> assertThatThrownBy(() -> lottoService.parseInputToNumberCandidates("1!,"))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Test
    void 상금의_인덱스를_계산합니다() {
        /* 순위 인덱스
        0 - 순위 밖
        1 - 5등
        2 - 4등
        3 - 3등
        4 - 2등
        5 - 1등
         */

        assertAll(
                () -> assertEquals(Prize.checkPrize(3, false), 1),
                () -> assertEquals(Prize.checkPrize(5, false), 3),
                () -> assertEquals(Prize.checkPrize(5, true), 4)
        );
    }

    @Test
    void 상금_정보를_주세요() {
        int rank_5 = 1, rank_3 = 3, rank_2 = 4, rank_1 = 5;

        assertAll(
                () -> assertThat(Prize.getPrizeInfo(rank_5)).contains(Message.FIFTH_PRIZE,
                        commaWithThousand.format(Condition.FIFTH_PRIZE_AMOUNT)),
                () -> assertThat(Prize.getPrizeInfo(rank_3)).contains(Message.THIRD_PRIZE,
                        commaWithThousand.format(Condition.THIRD_PRIZE_AMOUNT)),
                () -> assertThat(Prize.getPrizeInfo(rank_2)).contains(Message.SECOND_PRIZE,
                        commaWithThousand.format(Condition.SECOND_PRIZE_AMOUNT)),
                () -> assertThat(Prize.getPrizeInfo(rank_1)).contains(Message.FIRST_PRIZE,
                        commaWithThousand.format(Condition.FIRST_PRIZE_AMOUNT))
        );
    }

    @Test
    void 당첨_번호와_내_로또를_주면_등수를_계산합니다() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(Arrays.asList(10, 20, 40, 45, 30, 16)), // 1등
                new Lotto(Arrays.asList(10, 20, 40, 45, 30, 33)), // 2등
                new Lotto(Arrays.asList(10, 20, 40, 45, 30, 17)) // 3등
        );
        Lotto winningNumbers = new Lotto(Arrays.asList(10, 20, 40, 45, 30, 16));
        int bonusNumber = 33;

        LottoBuyer customer = new LottoBuyer(lottos, winningNumbers, bonusNumber, 3000);

        //when + then
        assertEquals(List.of(0, 0, 0, 1, 1, 1), customer.retrieveAllResult());

    }

    @Test
    void 당첨_번호와_내_로또를_주면_상금_내역을_줍니다() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(Arrays.asList(10, 20, 40, 45, 30, 16)), // 1등
                new Lotto(Arrays.asList(10, 20, 40, 45, 30, 33)), // 2등
                new Lotto(Arrays.asList(10, 20, 40, 45, 30, 17)) // 3등
        );
        Lotto winningNumbers = new Lotto(Arrays.asList(10, 20, 40, 45, 30, 16));
        int bonusNumber = 33;

        LottoBuyer customer = new LottoBuyer(lottos, winningNumbers, bonusNumber, 3000);

        List<Integer> myPrizes = customer.retrieveAllResult();
        //when + then
        assertThat(
                IntStream.range(1, Condition.SIX_WINNING_NUMBERS)
                        .mapToObj(idx -> Prize.getPrizeInfo(idx) + myPrizes.get(idx) + "개")
                        .toList())
                .contains(
                        Message.FIRST_PRIZE + "(" + commaWithThousand.format(Condition.FIRST_PRIZE_AMOUNT) + "원) - 1개",
                        Message.SECOND_PRIZE + "(" + commaWithThousand.format(Condition.SECOND_PRIZE_AMOUNT) + "원) - 1개",
                        Message.THIRD_PRIZE + "(" + commaWithThousand.format(Condition.THIRD_PRIZE_AMOUNT) + "원) - 1개"
                );

    }

    @Test
    void 구매한__로또를_보여주세요() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );

        //when
        String result = lottoService.ShowPurchasedLottoNumbers(lottos);

        assertThat(result).contains(
                "3개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]"
        );
    }

    @Test
    void 정제된_숫자_받기(){
        when(inputView.inputPurchaseAmount()).thenReturn("1000");
        when(inputView.drawWinningString()).thenReturn("1,2,3,4,5,6");
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () ->{
                assertEquals(
                        lottoController.inputMoney(),1000);
                assertEquals(lottoController.drawWinLotto().seeLottoNumber(), new Lotto(Arrays.asList(1,2,3,4,5,6)).seeLottoNumber());
        }

        );
    }

}