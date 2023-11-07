package lotto.service;

import lotto.LottoRank;
import lotto.domain.Lotto;

import lotto.model.LottoResultModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @DisplayName("당첨번호를 검증한다.")
    void inputWinningNumberValidation_정상케이스() {
        String input = "1,2,3,4,5,6";
        boolean result = lottoGameService.inputWinningNumberValidation(input);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("당첨번호를 검증한다.")
    void inputWinningNumberValidation_예외케이스() {
        String input = "1,이,34,오,6";
        boolean result = lottoGameService.inputWinningNumberValidation(input);
        assertThat(result).isFalse();
    }


    @Test
    @DisplayName("입력받은 보너스번호가 숫자인지 검증한다.")
    void inputBonusNumberValidation_정상케이스() {
        String input = "7";
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        boolean result = lottoGameService.inputBonusNumberValidation(winningNumber,input);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력받은 보너스번호가 숫자인지 검증한다.")
    void inputBonusNumberValidation_예외케이스() {
        String input = "46";
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        boolean result = lottoGameService.inputBonusNumberValidation(winningNumber,input);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("입력받은 금액으로 로또 수량을 계산한다.")
    void lottoQuantity() {
        int lottoQuantity = lottoGameService.lottoQuantity(14000);
        assertThat(lottoQuantity).isEqualTo(14);
    }

    @Test
    @DisplayName("구매한 로또의 결과를 반환한다.")
    void lottoWinningResult() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lottos.add(lotto);

        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(4,5,6,7,8,9));

        int bonusNumber = 10;
        List<LottoRank> lottoRanks = lottoGameService.lottoWinningResult(lottos, winningNumber, bonusNumber);

        assertThat(lottoRanks).hasSize(1);
        assertThat(lottoRanks.get(0).getRank()).isEqualTo(5);
        assertThat(lottoRanks.get(0).getMatchCount()).contains(3L);
        assertThat(lottoRanks.get(0).getWinningMoney()).isEqualTo("5000");
    }

    @Test
    @DisplayName("로또의 결과로 총 수익률을 계산한다.")
    void totalReturnRateCalculation() {
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIRST);
        BigDecimal totalReturnRate = lottoGameService.totalReturnRateCalculation(lottoRanks);
        assertThat(totalReturnRate).isEqualTo("200000000.0");
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