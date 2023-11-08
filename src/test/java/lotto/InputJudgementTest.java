package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputJudgementTest {
     private static final String ERROR_MESSAGE = "[ERROR]";
     private static ByteArrayOutputStream outputMessage;
     private static InputJudgement inputJudgement = new InputJudgement();
     private static List<Integer> winningNumber = List.of(5, 12, 39, 44, 26, 10);

     @BeforeEach
     void setUpStreams() {
          outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
          System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
     }

     @AfterEach
     void restoresStreams() {
          System.setOut(System.out); // 원상복귀
     }

     @DisplayName("구매금액이 null일 때는 오류가 발생해야한다.")
     @Test
     void 구매금액이_null일_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable(null);
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액이 비어있을 때는 오류가 발생해야한다.")
     @Test
     void 구매금액이_비어있을_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액의 길이가 4 미만일 때는 오류가 발생해야한다.")
     @Test
     void 구매금액의_길이가_4_미만일_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액의 길이가 4 미만일 때는 오류가 발생해야한다.")
     @Test
     void 구매금액의_길이가_4_미만일_때_judgeInputPurchaseMoneyFormat_1(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("abc");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액의 길이가 4 미만일 때는 오류가 발생해야한다.")
     @Test
     void 구매금액의_길이가_4_미만일_때_judgeInputPurchaseMoneyFormat_2(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("abc");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액에 문자가 있을 때는 오류가 발생해야한다.")
     @Test
     void 구매금액에_문자가_포함되어_있을_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("1000a");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액이 1000원 미만일 때는 오류가 발생해야한다.")
     @Test
     void 구매금액이_1000원_미만일_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("0100");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액이 정수가 아닐 때는 오류가 발생해야한다.")
     @Test
     void 구매금액이_정수가_아닐_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("100.2");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액이 1000원으로 나누어 떨어지지 않을 때는 오류가 발생해야한다.")
     @Test
     void 구매금액이_1000원으로_나누어_떨어지지_않을_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("1002");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("구매금액이 1000원으로 나누어 떨어질 때는 결과값이 true여야한다.")
     @Test
     void 구매금액이_1000원으로_나누어_떨어질_때_judgeInputPurchaseMoneyFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("4000");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);

          assertThat(isEffectiveInputFormat).isEqualTo(true);
     }

     @DisplayName("당첨 숫자는 null이면 안 된다.")
     @Test
     void 당첨_숫자가_null일_때_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable(null);
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("당첨 숫자는 비어있으면 안 된다.")
     @Test
     void 당첨_숫자가_비어있을_때_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("컴마로 구분했을 때, 6개가 아니면 오류가 난다.")
     @Test
     void 컴마로_구분했을_때_6개여야_한다_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("1,2,5,4,3");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("컴마로 구분했을 때, 값이 숫자여야한다.")
     @Test
     void 컴마로_구분했을_때_값이_숫자여야_한다_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("1,2,5,4,a,90");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("컴마로 구분했을 때, 값이 1과 45 사이여야한다.")
     @Test
     void 컴마로_구분했을_때_값이_1과_45_사이여야_한다_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("1,2,5,4,9,90");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("컴마로 구분했을 때, 값이 중복되어 있으면 안 된다.")
     @Test
     void 컴마로_구분했을_때_값이_중복되면_안_된다_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("2,4,10,2,34,21");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("컴마로 구분했을 때, 값이 실수면 안 된다.")
     @Test
     void 컴마로_구분했을_때_값이_실수면_안_된다_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("2,4,10,2.1,34,21");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("컴마로 구분했을 때, 값이 1과 45 사이로 6개여야한다.")
     @Test
     void 컴마로_구분했을_때_값이_1과_45_사이로_6개여야_한다_judgeInputWinningNumberFormat(){
          Optional<String> inputPurchaseMoney = Optional.ofNullable("2,43,31,27,19,10");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputWinningNumberFormat(inputPurchaseMoney);

          assertThat(isEffectiveInputFormat).isEqualTo(true);
     }

     @DisplayName("보너스 번호는 null이면 안된다.")
     @Test
     void 보너스_번호는_null이면_안_된다_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable(null);
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("보너스 번호는 비어있으면 안된다.")
     @Test
     void 보너스_번호는_비어있으면_안_된다_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable("");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("보너스 번호는 정수여야한다 - 1.")
     @Test
     void 보너스_번호는_정수여야한다_1_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable("1.1");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("보너스 번호는 정수여야한다 - 2.")
     @Test
     void 보너스_번호는_정수여야한다_2_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable("ab");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("보너스 번호는 1부터 45 사이여야 한다.")
     @Test
     void 보너스_번호는_1부터_45_사이여야_한다_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable("47");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("보너스 번호는 당첨번호에 포함되면 안 된다.")
     @Test
     void 보너스_번호는_당첨번호에_포함되면_안_된다_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable("44");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(outputMessage.toString()).contains(ERROR_MESSAGE);
          assertThat(isEffectiveInputFormat).isEqualTo(false);
     }

     @DisplayName("보너스 번호는 당첨번호 당첨번호에 중복되지 않는 1부터 45 사이의 정수여야한다.")
     @Test
     void 보너스_번호는_유효해햐_한다_judgeInputBonusNumberFormat(){
          Optional<String> inputBonusNumber = Optional.ofNullable("7");
          boolean isEffectiveInputFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber ,winningNumber);

          assertThat(isEffectiveInputFormat).isEqualTo(true);
     }
}
