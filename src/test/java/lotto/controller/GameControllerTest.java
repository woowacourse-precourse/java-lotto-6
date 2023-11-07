package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        gameService = new GameService();
        gameController = new GameController(inputView, outputView, gameService);
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

        //then
        assertThatThrownBy(() -> gameController.startGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 미만이면 예외를 발생시킨다.")
    @Test
    public void startGame_구입금액_1000원_미만_예외_발생(){
        //given
        String input = "999";

        //when
        provideInput(input);

        //then
        assertThatThrownBy(() -> gameController.startGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 단위가 아니면 예외를 발생시킨다.")
    @Test
    public void startGame_구입금액_1000원_단위_아닌_예외_발생(){
        //given
        String input = "1001";

        //when
        provideInput(input);

        //then
        assertThatThrownBy(() -> gameController.startGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

}