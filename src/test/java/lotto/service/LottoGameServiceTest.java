package lotto.service;

import lotto.LottoException;
import lotto.model.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoGameServiceTest {
    LottoGameService lottoGameService;

    @BeforeEach
    public void createLottoGameService(){
        lottoGameService = new LottoGameService();
    }

    @Test
    @DisplayName("입력받은 수량만큼 로또를 생성한다")
    void createLotto() {
        int quantity =5;
        List<Lotto> lotto = lottoGameService.createLotto(quantity);

        assertThat(lotto).hasSize(quantity);
    }

    @Test
    @DisplayName("당첨번호를 생성한다.")
    void createWinningNumber() {
        String winningNumber = "1,2,3,4,5,6";
        List<Integer> result = lottoGameService.createWinningNumber(winningNumber);

        assertThat(result).hasSize(6)
                .containsExactly(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("입력받은 구매금액을 검증한다.")
    void inputPurchaseAmountValidation_정상케이스() {
        String input = "14000";
        boolean result = lottoGameService.inputPurchaseAmountValidation(input);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력받은 구매금액을 검증한다.")
    void inputPurchaseAmountValidation_예외케이스() {
        String input = "14200";
        boolean result = lottoGameService.inputPurchaseAmountValidation(input);

        assertThat(result).isFalse();
    }

    @Test
    void inputWinningNumberValidation_정상케이스() {
        String input = "1,2,3,4,5,6";
        boolean result = lottoGameService.inputWinningNumberValidation(input);
        assertThat(result).isTrue();
    }

    @Test
    void inputWinningNumberValidation_예외케이스() {
        String input = "1,이,34,오,6";
        boolean result = lottoGameService.inputWinningNumberValidation(input);
        assertThat(result).isFalse();
    }


    @Test
    @DisplayName("입력받은 보너스번호가 숫자인지 검증한다.")
    void inputBonusNumberValidation_정상케이스() {
        String input = "5";
        boolean result = lottoGameService.inputBonusNumberValidation(input);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력받은 보너스번호가 숫자인지 검증한다.")
    void inputBonusNumberValidation_예외케이스() {
        String input = "46";
        boolean result = lottoGameService.inputBonusNumberValidation(input);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("입력받은 금액으로 로또 수량을 계산한다.")
    void lottoQuantity() {
        int lottoQuantity = lottoGameService.lottoQuantity(14000);
        assertThat(lottoQuantity).isEqualTo(14);
    }

    @Test
    void lottoWinningResultCalculation() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lottos.add(lotto);

        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(4,5,6,7,8,9));

        int bonusNumber = 10;
        Map<String, String> result = lottoGameService.lottoWinningResultCalculation(lottos,winningNumber,bonusNumber);

        assertThat(result).hasSize(6)
                .contains(
                        entry("총 수익률","500.0"),
                        entry("3개일치","1"),
                        entry("4개일치","0"),
                        entry("5개일치","0"),
                        entry("5개일치_보너스일치","0"),
                        entry("6개일치","0")
                )
        ;

    }

    //    @Test
//    @DisplayName("입력받은 값이 숫자인지 검증한다.")
//    void isDigit_정상케이스() {
//        String input = "14000";
//
//        Boolean result = lottoGameService.isDigit(input);
//
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    @DisplayName("입력받은 값이 숫자가 아닌지 검증한다.")
//    void isDigit_예외케이스() {
//        String input = "만사천원";
//
//        assertThatThrownBy(() -> lottoGameService.isDigit(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(LottoException.INPUT_NOT_DiGIT.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("입력받은 값이 1,000원 단위 인지 검증한다.")
//    void isThousandUnits_정상케이스() {
//        String input = "14000";
//        boolean result = lottoGameService.isThousandUnits(input);
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    @DisplayName("입력받은 값이 1,000원 단위 인지 검증한다.")
//    void isThousandUnits_예외케이스() {
//        String input = "14200";
//        assertThatThrownBy(() -> lottoGameService.isThousandUnits(input))
//              .isInstanceOf(IllegalArgumentException.class)
//              .hasMessageContaining(LottoException.INPUT_NOT_THOUSAND_UNITS.getMessage());
//    }


//    @Test
//    @DisplayName("입력받은 값을 쉼표(,) 구분자로 나눈다.")
//    void inputWinningNumberSplit_정상케이스() {
//        String[] inputWinningNumberSplit = lottoGameService.inputWinningNumberSplit("1,2,3,4,5,6");
//        assertThat(inputWinningNumberSplit).hasSize(6);
//    }
//
//    @Test
//    @DisplayName("입력받은 값을 쉼표(,) 구분자로 나눈다.")
//    void inputWinningNumberSplit_예외케이스() {
//        assertThatThrownBy(() -> lottoGameService.inputWinningNumberSplit("123456"))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(LottoException.INPUT_NOT_SPLIT.getMessage());
//    }

//    @Test
//    void isWinningNumberDigit_정상케이스() {
//        String[] inputWinningNumberSplit = {"1","2","3","4","5","6"};
//        boolean result = lottoGameService.isWinningNumberDigit(inputWinningNumberSplit);
//
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    void isWinningNumberDigit_예외케이스() {
//        String[] inputWinningNumberSplit = {"일","2","삼","4","오","6"};
//        assertThatThrownBy(() -> lottoGameService.isWinningNumberDigit(inputWinningNumberSplit))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(LottoException.INPUT_NOT_DiGIT.getMessage());
//    }



//    @Test
//    @DisplayName("입력받은 보너스번호가가 1~45 범위인지 검증한다.")
//    void isRange_정상케이스() {
//        int input = 45;
//        boolean result = lottoGameService.isRange(input, 1, 45);
//
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    @DisplayName("입력받은 보너스번호가가 1~45 범위인지 검증한다.")
//    void inputBonusNumberRangeValidation_예외케이스() {
//        int input = 46;
//        assertThatThrownBy(() -> lottoGameService.isRange(input,1,45))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(LottoException.INPUT_NOT_RANGE.getMessage());
//    }
}