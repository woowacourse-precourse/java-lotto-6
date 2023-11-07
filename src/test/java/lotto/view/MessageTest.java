package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageTest {
    private static final String NEW_LINE = System.lineSeparator(),
            PROMPT_MONEY = "구입금액을 입력해 주세요.",
            PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.",
            PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.",
            INVALID_MONEY_ERROR = "[ERROR] 구입금액은 1,000원 단위 양수입니다.",
            INVALID_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6자리 숫자입니다.",
            INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.";
    private PrintStream standardOut;
    private OutputStream captor;
    private Messenger messenger;
    private MessageBuilder messageBuilder;
    Message message;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        messenger = new WriterMessenger();
        messageBuilder = mock(MessageBuilder.class);
        message = new Message(messenger, messageBuilder);
    }

    @Test
    void print_로또발행() {
        String expected = "8개를 구매했습니다." + System.lineSeparator()
                + "[8, 21, 23, 41, 42, 43]" + System.lineSeparator()
                + "[3, 5, 11, 16, 32, 38]" + System.lineSeparator()
                + "[7, 11, 16, 35, 36, 44]" + System.lineSeparator()
                + "[1, 8, 11, 31, 41, 42]" + System.lineSeparator()
                + "[13, 14, 16, 38, 42, 45]" + System.lineSeparator()
                + "[7, 11, 30, 40, 42, 43]" + System.lineSeparator()
                + "[2, 13, 22, 32, 38, 45]" + System.lineSeparator()
                + "[1, 3, 5, 14, 22, 45]" + System.lineSeparator();

        Player player = mock(Player.class);
        when(messageBuilder.build(player)).thenReturn(expected);

        message.print(player);

        assertThat(captor.toString()).isEqualTo(expected + System.lineSeparator());
        verify(messageBuilder, times(1)).build(player);
    }

    @Test
    void print_당첨통계() {
        String expected = "당첨 통계" + System.lineSeparator()
                + "---" + System.lineSeparator()
                + "3개 일치 (5,000원) - 1개" + System.lineSeparator()
                + "4개 일치 (50,000원) - 0개" + System.lineSeparator()
                + "5개 일치 (1,500,000원) - 0개" + System.lineSeparator()
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" + System.lineSeparator()
                + "6개 일치 (2,000,000,000원) - 0개" + System.lineSeparator()
                + "총 수익률은 62.5%입니다.";

        Player player = mock(Player.class);
        LottoResult lottoResult = mock(LottoResult.class);
        when(messageBuilder.build(player, lottoResult)).thenReturn(expected);

        message.print(player, lottoResult);

        assertThat(captor.toString()).isEqualTo(expected + System.lineSeparator());
        verify(messageBuilder, times(1)).build(player, lottoResult);
    }

    @Test
    void newLine() {
        message.newLine();
        assertThat(captor.toString()).isEqualTo(NEW_LINE + System.lineSeparator());
    }

    @Test
    void promptMoney() {
        message.promptMoney();
        assertThat(captor.toString()).isEqualTo(PROMPT_MONEY + System.lineSeparator());
    }

    @Test
    void promptWinningNumbers() {
        message.promptWinningNumbers();
        assertThat(captor.toString()).isEqualTo(PROMPT_WINNING_NUMBERS + System.lineSeparator());
    }

    @Test
    void promptBonusNumber() {
        message.promptBonusNumber();
        assertThat(captor.toString()).isEqualTo(PROMPT_BONUS_NUMBER + System.lineSeparator());
    }

    @Test
    void invalidMoneyError() {
        message.invalidMoneyError();
        assertThat(captor.toString()).isEqualTo(INVALID_MONEY_ERROR + System.lineSeparator());
    }

    @Test
    void invalidWinningNumbersError() {
        message.invalidWinningNumbersError();
        assertThat(captor.toString()).isEqualTo(INVALID_WINNING_NUMBERS_ERROR + System.lineSeparator());
    }

    @Test
    void invalidBonusNumberError() {
        message.invalidBonusNumberError();
        assertThat(captor.toString()).isEqualTo(INVALID_BONUS_NUMBER_ERROR + System.lineSeparator());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}