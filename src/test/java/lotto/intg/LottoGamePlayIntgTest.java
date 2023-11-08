package lotto.intg;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import lotto.service.play.GamePlay;
import lotto.service.play.LottoGamePlay;
import lotto.util.exception.ErrorMessage;
import lotto.util.message.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGamePlayIntgTest {
    private GamePlay gamePlay;


    @BeforeEach
    void init(){
        gamePlay = new LottoGamePlay();
    }

    @AfterEach
    void finished() {
        Console.close();
    }

    @DisplayName("로또 성공 케이스")
    @Test
    void lottoNormalCase(){
        //given
        System.setIn(createUserInput("8000\n1,2,3,4,5,6\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        gamePlay.play();

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(Message.RATE.toString());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void NotDistinctLottoNumbers(){
        //given
        System.setIn(createUserInput("8000\n1,2,2,4,5,6\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.SHOULD_BE_DISTINCT.toString());

    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void overSixLottoNumbers(){
        //given
        System.setIn(createUserInput("8000\n1,2,3,4,5,6,7\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_SIX_NUMBER.toString());

    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void lowerThanOneLottoNumber(){
        //given
        System.setIn(createUserInput("8000\n-1,2,3,4,5,6\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());

    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void BiggerThanFortyFiveLottoNumber(){
        //given
        System.setIn(createUserInput("8000\n46,2,3,4,5,6\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        System.setOut(new PrintStream(baos));

        //when
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }

    @DisplayName("천원보다 아래의 금액은 예외가 발생한다.")
    @Test
    void lowerThanThousandBuyMoneys(){
        //given
        System.setIn(createUserInput("800\n1,2,3,4,5,6\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_THOUSAND.toString());
    }

    @DisplayName("천원으로 나누어 떨어지지 않는 금액은 예외가 발생한다.")
    @Test
    void cantDivideWithThousandBuyMoneys(){
        //given
        System.setIn(createUserInput("3800\n1,2,3,4,5,6\n7\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_THOUSAND.toString());
    }

    @DisplayName("천원으로 나누어 떨어지지 않는 금액은 예외가 발생한다.")
    @Test
    void bonusNumberInWinningNumbers(){
        //given
        System.setIn(createUserInput("8000\n1,2,3,4,5,6\n6\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.SHOULD_NOT_SAME_WITH_WINNING_NUMBERS.toString());
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void biggerThenFortyFiveBonusNumber(){
        //given
        System.setIn(createUserInput("8000\n1,2,3,4,5,6\n46\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void lowerThenOneBonusNumber(){
        //given
        System.setIn(createUserInput("8000\n1,2,3,4,5,6\n0\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        // 예외 처리하고 다시 물으면 NoSuchElementException 발생
        assertThatThrownBy(() -> gamePlay.play())
                .isInstanceOf(NoSuchElementException.class);

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }


    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
