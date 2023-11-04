//package lotto.view;
//
//import camp.nextstep.edu.missionutils.Console;
//import lotto.message.ErrorMessage;
//import lotto.view.input.LottoNumberInputView;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.io.ByteArrayInputStream;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//class LottoNumberInputViewTest {
//
//    private LottoNumberInputView lottoNumberInputView = new LottoNumberInputView(1000);
//
//    @AfterEach
//    void tearDown(){
//        Console.close();
//    }
//
//    @Test
//    @DisplayName("사용자에게 구입할 Lotto 금액은 1000원 단위이다.")
//    public void requestLottoPurchaseAmount() {
//        // given
//        String input = "98000";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        // when
//        int amount = lottoNumberInputView.requestLottoPurchaseAmount();
//        // then
//        boolean isResult = amount % 1000 == 0;
//        assertThat(isResult).isTrue();
//    }
//
//    @Test
//    @DisplayName("Lotto의 금액이 1000원 단위가 아니면 예외가 발생한다.")
//    public void checkIsMultipleOfDenomination() {
//        //given
//        String input = "9200";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        // when // then
//        assertThatThrownBy(() -> lottoNumberInputView.requestLottoPurchaseAmount())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
//    }
//
//    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
//    @DisplayName("Lotto의 금액이 0보다 크지 않으면 예외가 발생한다.")
//    @ValueSource(strings = {"0","-1000","-1500"})
//    public void checkIsValidLottoAmount(String input) {
//        // given
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        // when // then
//        assertThatThrownBy(() -> lottoNumberInputView.requestLottoPurchaseAmount())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
//    }
//
//    @Test
//    @DisplayName("사용자는 로또 당첨번호를 입력할 수 있다.")
//    public void requestWinningLottoNumbers() {
//        //given
//        String input = "1,2,3,4,5,6";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        // when
//        List<Integer> lottoNumbers = lottoNumberInputView.requestWinningLottoNumbers();
//        // then
//        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
//    }
//
////    @Test
////    @DisplayName("보너스 로또 번호를 입력할 수 있다.")
////    public void requestBonusLottoNumber() {
////        //given
////        String input = "45";
////        System.setIn(new ByteArrayInputStream(input.getBytes()));
////        // when
////        int bonusLottoNumber = lottoBuyInputView.requestBonusLottoNumber();
////        // then
////        assertThat(bonusLottoNumber).isBetween(1, 45);
////        assertThat(bonusLottoNumber).isEqualTo(45);
////    }
//
//}