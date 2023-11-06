package lotto.service;

import lotto.LottoException;
import lotto.model.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("입력받은 값이 숫자인지 검증한다.")
    void inputPurchaseAmountValidation_정상케이스() {
        String input = "14000";

        int inputPurchaseAmountValidation = lottoGameService.inputPurchaseAmountValidation(input);
        assertThat(inputPurchaseAmountValidation).isEqualTo(14000);

    }

    @Test
    @DisplayName("입력받은 값이 숫자가 아닌지 검증한다.")
    void inputPurchaseAmountValidation_예외케이스() {
        String input = "만사천원";

        assertThatThrownBy(() -> lottoGameService.inputPurchaseAmountValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoException.INPUT_NOT_DiGIT.getMessage());

    }

    @Test
    @DisplayName("입력받은 값이 1,000원 단위 인지 검증한다.")
    void isThousandUnits_정상케이스() {
        boolean thousandUnits = lottoGameService.isThousandUnits(14000);
        assertThat(thousandUnits).isTrue();
    }

    @Test
    @DisplayName("입력받은 값이 1,000원 단위 인지 검증한다.")
    void isThousandUnits_예외케이스() {
      assertThatThrownBy(() -> lottoGameService.isThousandUnits(14200))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining(LottoException.INPUT_NOT_THOUSAND_UNITS.getMessage());
    }

    @Test
    @DisplayName("입력받은 금액으로 로또 수량을 계산한다.")
    void lottoQuantity() {
        int lottoQuantity = lottoGameService.lottoQuantity(14000);
        assertThat(lottoQuantity).isEqualTo(14);
    }

    @Test
    @DisplayName("입력받은 값을 쉼표(,) 구분자로 나눈다.")
    void inputWinningNumberSplit_정상케이스() {
        String[] inputWinningNumberSplit = lottoGameService.inputWinningNumberSplit("1,2,3,4,5,6");
        assertThat(inputWinningNumberSplit).hasSize(6);
    }

    @Test
    @DisplayName("입력받은 값을 쉼표(,) 구분자로 나눈다.")
    void inputWinningNumberSplit_예외케이스() {
        assertThatThrownBy(() -> lottoGameService.inputWinningNumberSplit("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoException.INPUT_NOT_SPLIT.getMessage());
    }


    @Test
    @DisplayName("입력받은 당첨번호가 숫자인지 검증한다.")
    void inputWinningNumberValidation_정상케이스() {
        String[] inputWinningNumberSplit = {"1","2","3","4","5","6"};
        List<Integer> winningNumber= lottoGameService.inputWinningNumberValidation(inputWinningNumberSplit);
        assertThat(winningNumber).contains(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("입력받은 당첨번호가 숫자가 아니면 예외를 발생한다.")
    void inputWinningNumberValidation_예외케이스() {
        String[] inputWinningNumberSplit = {"일","이","삼","가","오","육"};
        assertThatThrownBy(() -> lottoGameService.inputWinningNumberValidation(inputWinningNumberSplit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoException.INPUT_NOT_DiGIT.getMessage());
    }

    @Test
    @DisplayName("입력받은 보너스번호가 숫자인지 검증한다.")
    void inputBonusNumberValidation_정상케이스() {
        String input = "5";
        int bonusNumber = lottoGameService.inputBonusNumberValidation(input);
        assertThat(bonusNumber).isEqualTo(5);
    }

    @Test
    @DisplayName("입력받은 보너스번호가 숫자가 아닌면 예외를 발생한다.")
    void inputBonusNumberValidation_예외케이스() {
        String input = "오";
        assertThatThrownBy(() -> lottoGameService.inputBonusNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoException.INPUT_NOT_DiGIT.getMessage());
    }

    @Test
    @DisplayName("입력받은 보너스번호가가 1~45 범위인지 검증한다.")
    void inputBonusNumberRangeValidation_정상케이스() {
        int input = 45;
        int rangeValidation = lottoGameService.inputBonusNumberRangeValidation(input);

        assertThat(rangeValidation).isEqualTo(input);
    }

    @Test
    @DisplayName("입력받은 보너스번호가가 1~45 범위인지 검증한다.")
    void inputBonusNumberRangeValidation_예외케이스() {
        int input = 46;
        assertThatThrownBy(() -> lottoGameService.inputBonusNumberRangeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoException.INPUT_NOT_RANGE.getMessage());
    }
}