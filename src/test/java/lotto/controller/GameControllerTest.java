package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Error;
import lotto.domain.Rank;
import lotto.service.GameService;
import lotto.view.OutputView;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private GameService gameService;
    private GameController gameController;

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    void runException(Runnable runnable) {
        try {
            runnable.run();
        } catch (final NoSuchElementException ignore) {
        }
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        gameService = new GameService();
        gameController = new GameController(gameService);
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setOut(originalOut);
        System.setIn(systemIn);
        Console.close();
    }

    @DisplayName("구입금액을 입력받아 발행된 로또 번호를 출력한다.")
    @Test
    public void startGame_구입금액_입력받아_발행된_로또번호_출력(){
        //given
        String input = "2000";
        List<Integer> lotto1 = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());
        List<Integer> lotto2 = Arrays.stream(new int[]{7,8,9,10,11,12}).boxed().collect(Collectors.toList());


        //when
        provideInput(input);
        assertRandomUniqueNumbersInRangeTest(() -> gameController.startGame(), lotto1,lotto2);

        //then
        assertThat(outContent.toString()).contains(lotto1.toString());
        assertThat(outContent.toString()).contains(lotto2.toString());
    }

    @DisplayName("숫자가 아닌 구입금액을 입력하면 예외를 발생시킨다.")
    @Test
    public void startGame_구입금액_숫자_변화_불가_예외_발생(){
        //given
        String input = "2000원";

        //when
        provideInput(input);
        runException(() -> gameController.startGame());

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_NUMBER_INPUT);
    }

    @DisplayName("구입금액이 1000원 미만이면 예외를 발생시킨다.")
    @Test
    public void startGame_구입금액_1000원_미만_예외_발생(){
        //given
        String input = "999";

        //when
        provideInput(input);
        runException(() -> gameController.startGame());

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_LOTTO_MONEY);
    }

    @DisplayName("구입금액이 1000원 단위가 아니면 예외를 발생시킨다.")
    @Test
    public void startGame_구입금액_1000원_단위_아닌_예외_발생(){
        //given
        String input = "1001";

        //when
        provideInput(input);
        runException(() -> gameController.startGame());

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_LOTTO_MONEY_UNIT);
    }

    @DisplayName("당첨 번호와 보너스 번호를 입력받아 당첨 통계를 계산한다.")
    @Test
    public void playGame_당첨번호_보너스번호_입력받아_당첨통계_계산(){
        //given
        String lottoMoneyInput = "2000\n";
        List<Integer> lotto1 = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());
        List<Integer> lotto2 = Arrays.stream(new int[]{7,8,9,10,11,12}).boxed().collect(Collectors.toList());

        //when
        String lottoNumbersInput = "1,2,3,4,5,6\n7";
        provideInput(lottoMoneyInput + lottoNumbersInput);
        assertRandomUniqueNumbersInRangeTest(() -> {
            gameController.startGame();
            gameController.playGame();
            }, lotto1,lotto2);

        //then
        Map<Rank, Integer> rankCountMap = gameService.getRankCountMap();
        assertThat(rankCountMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCountMap.get(Rank.SECOND)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.FIFTH)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.NONE)).isEqualTo(1);
    }

    @DisplayName("숫자가 아닌 당첨번호를 입력하면 예외를 발생시킨다.")
    @Test
    public void playGame_당첨번호_숫자_변화_불가_예외_발생() {
        //given
        String lottoMoneyInput = "2000\n";
        String lottoNumbersInput = "a,b,c,d,e,f,g\n7";

        //when
        provideInput(lottoMoneyInput + lottoNumbersInput);
        runException(() -> {
            gameController.startGame();
            gameController.playGame();
        });

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_NUMBER_INPUT);
    }

    @DisplayName("6개의 당첨번호를 입력하지 않으면 예외를 발생시킨다.")
    @Test
    public void playGame_당첨번호_6개_입력_아닌_예외_발생(){
        //given
        String lottoMoneyInput = "2000\n";
        String lottoNumbersInput = "1,2,3,4,5\n7";

        //when
        provideInput(lottoMoneyInput + lottoNumbersInput);
        runException(() -> {
            gameController.startGame();
            gameController.playGame();
        });

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_LOTTO_NUMBER_SIZE);
    }

    @DisplayName("당첨번호가 1~45 사이의 숫자가 아니면 예외를 발생시킨다.")
    @Test
    public void playGame_당첨번호_1_45_아닌_예외_발생(){
        //given
        String lottoMoneyInput = "2000\n";
        String lottoNumbersInput = "1,2,3,4,5,46\n7";

        //when
        provideInput(lottoMoneyInput + lottoNumbersInput);
        runException(() -> {
            gameController.startGame();
            gameController.playGame();
        });

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("숫자가 아닌 보너스번호를 입력하면 예외를 발생시킨다.")
    @Test
    public void playGame_보너스번호_숫자_변화_불가_예외_발생(){
        //given
        String lottoMoneyInput = "2000\n";
        String lottoNumbersInput = "1,2,3,4,5,6\na";

        //when
        provideInput(lottoMoneyInput + lottoNumbersInput);
        runException(() -> {
            gameController.startGame();
            gameController.playGame();
        });

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_NUMBER_INPUT);
    }

    @DisplayName("보너스번호가 1~45 사이의 숫자가 아니면 예외를 발생시킨다.")
    @Test
    public void playGame_보너스번호_1_45_아닌_예외_발생(){
        //given
        String lottoMoneyInput = "2000\n";
        String lottoNumbersInput = "1,2,3,4,5,6\n46";

        //when
        provideInput(lottoMoneyInput + lottoNumbersInput);
        runException(() -> {
            gameController.startGame();
            gameController.playGame();
        });

        //then
        assertThat(outContent.toString()).contains(Error.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("당첨 통계와 수익률을 계산하여 출력한다.")
    @Test
    public void endGame_당첨_통계와_수익률_계산(){
        //given
        String lottoMoneyInput = "2000\n";
        List<Integer> lotto1 = List.of(1,2,3,4,5,6);
        List<Integer> lotto2 = List.of(4,5,6,7,8,9);
        String lottoNumbersInput = "1,2,3,4,5,6\n7";
        provideInput(lottoMoneyInput + lottoNumbersInput);

        //when
        assertRandomUniqueNumbersInRangeTest(() -> {
            gameController.startGame();
            gameController.playGame();
            gameController.endGame();
        }, lotto1,lotto2);

        //then
        Map<Rank, Integer> rankCountMap = gameService.getRankCountMap();
        assertThat(rankCountMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCountMap.get(Rank.SECOND)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankCountMap.get(Rank.FIFTH)).isEqualTo(1);

        int totalWinningMoney = Rank.FIRST.getWinningMoney() + Rank.FIFTH.getWinningMoney();
        assertThat(gameService.calculateProfitRate()).isEqualTo((double) totalWinningMoney / 2000 * 100);
    }

    @DisplayName("당첨 통계와 수익률을 계산하여 출력한다.")
    @Test
    public void endGame_당첨_통계와_수익률_출력(){
        //given
        String lottoMoneyInput = "2000\n";
        List<Integer> lotto1 = List.of(1,2,3,4,5,6);
        List<Integer> lotto2 = List.of(4,5,6,7,8,9);
        String lottoNumbersInput = "1,2,3,4,5,6\n7";
        provideInput(lottoMoneyInput + lottoNumbersInput);

        //when
        assertRandomUniqueNumbersInRangeTest(() -> {
            gameController.startGame();
            gameController.playGame();
            gameController.endGame();
        }, lotto1,lotto2);

        //then
        assertThat(outContent.toString())
                .contains(String.format(
                        OutputView.OUTPUT_WINNING_MONEY_FORMAT,
                        Rank.FIRST.getMatchCount(),
                        String.format("%,d", Rank.FIRST.getWinningMoney()),
                        1))
                .contains(String.format(
                        OutputView.OUTPUT_WINNING_MONEY_FORMAT,
                        Rank.FIFTH.getMatchCount(),
                        String.format("%,d", Rank.FIFTH.getWinningMoney()),
                        1));

        assertThat(outContent.toString())
                .contains(String.format(OutputView.OUTPUT_PROFIT_RATE_MESSAGE, gameService.calculateProfitRate()));
    }

}