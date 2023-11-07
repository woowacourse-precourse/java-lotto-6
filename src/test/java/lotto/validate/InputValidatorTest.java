package lotto.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.TestAbortedException;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

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
    @DisplayName("중복되는 당첨 번호들 입력 시 에러 메세지를 출력한다.")
    void duplicateWinningNumbersTest() {
        String winning = "1,2,2,3,4,5";
        assertAll(
                () -> assertThatThrownBy(() -> inputWinningFailureCase(winning))
                        .isInstanceOf(Throwable.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("로또 번호가 중복되었습니다.")
                )
        );
    }

    @Test
    @DisplayName("6개 이상의 숫자를 입력 받았을 시 에러 메세지를 출력한다.")
    void outOfRangeWinningTest() {
        String winning = "1,2,3,4,5,6,7";
        assertAll(
                () -> assertThatThrownBy(() -> inputWinningFailureCase(winning))
                        .isInstanceOf(Throwable.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("정확히 6개 숫자를 입력해주세요.")
                )
        );
     }


    @Test
    @DisplayName("숫자가 아닌 값이 당첨번호로 들어간다.")
    void InvalidWinningFormatTest() throws Exception{
        String winning = "1,2,3,4,5,+";
        assertAll(
                () -> assertThatThrownBy(() -> inputWinningFailureCase(winning))
                        .isInstanceOf(Throwable.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("'숫자' 그리고 ',' 만을 입력해주세요")
                )
        );
    }

    @Test
    @DisplayName(",로 끝나는 지만 6개의 숫자를 모두 채웠을 때도 정상 작동한다.")
    void exceptFormatCaseTest() throws Exception{
        //given
        String input = "1,2,3,4,5,6,";
        //when
        inputValidator.validateWinningInput(input);
     }

     @Test
     @DisplayName("당첨 번호가 6보다 작은 값이 입력 될시")
     void lessNumberOfElementTest() throws Exception{
         //given
         String winning = "1,2,3,4,5";
         assertAll(
                 () -> assertThatThrownBy(() -> inputWinningFailureCase(winning))
                         .isInstanceOf(Throwable.class),
                 () -> assertTrue(outputMessage
                         .toString()
                         .contains("정확히 6개 숫자를 입력해주세요.")
                 )
         );
      }

    @Test
    @DisplayName("구매 금액이 음수가 입력될시")
    void validatePurchaseAmount() {
        String purchase = "-123000";

        assertAll(
                () -> assertThatThrownBy(() -> inputPurchaseFailureCase(purchase))
                        .isInstanceOf(Throwable.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("0 이상의 숫자를 입력해주세요.")
                )
        );

    }

    @Test
    @DisplayName("구매 금액이 숫자가 아닌 값이 들어 올 경우")
    void invalidPurchaseInputFormatTest() {
        String purchase = "iAmSuperShy";
        assertAll(
                () -> assertThatThrownBy(() -> inputPurchaseFailureCase(purchase))
                        .isInstanceOf(Throwable.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("잘못된 입력입니다. 숫자를 입력해주세요(범위 1,000~1,000,000,000)")
                )
        );

    }
    @Test
    @DisplayName("1000으로 나누어 지지 않는 경우")
    void dividableInputFormatTest() {
        String purchase = "1234";
        assertAll(
                () -> assertThatThrownBy(() -> inputPurchaseFailureCase(purchase))
                        .isInstanceOf(Throwable.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("1,000 단위의 구매 가격을 입력해주세요.")
                )
        );

    }

    private void inputWinningFailureCase(String winning) {
        assertTimeoutPreemptively(Duration.ofMillis(10000), () -> inputValidator.validateWinningInput(winning));
    }

    private void inputPurchaseFailureCase(String purchase){
        assertTimeoutPreemptively(Duration.ofMillis(10000), () -> inputValidator.validatePurchaseAmount(purchase));

    }


}