package lotto.service;

import lotto.config.WinningCriteria;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService;
    private List<Integer> winningNumbers;

    @BeforeEach
    void beforeEach() {
        lottoService = new LottoService();

    }

    @DisplayName("로또 구매시 구매 개수가 0이면 예외가 발생한다.")
    @Test
    void purchaseLottoIsZero() {

        int count = 0;

        assertThatThrownBy(() -> lottoService.repeatPurchase(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_FOUND_PURCHASE_LOTTO.getMessage());
    }

    @DisplayName("정해진 개수 만큼 로또가 구매되는지 테스트")
    @Test
    void purchaseSetNumberOfLottos() {

        int count = 10;

        lottoService.repeatPurchase(count);

        assertThat(lottoService.getPurchaseLottos().size()).isEqualTo(count);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        assertThatThrownBy(() -> lottoService.setWinningLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 미만 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderSize() {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        assertThatThrownBy(() -> lottoService.setWinningLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        assertThatThrownBy(() -> lottoService.setWinningLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호가 45를 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberNumberByOverRange() {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 46));

        assertThatThrownBy(() -> lottoService.setWinningLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());;
    }

    @DisplayName("당첨 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createWinningNumberNumberByUnderRange() {

        winningNumbers = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));

        assertThatThrownBy(() -> lottoService.setWinningLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderRange () {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoNumbers(winningNumbers);
        int bonusNumber = 0;

        assertThatThrownBy(() -> lottoService.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange () {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoNumbers(winningNumbers);
        int bonusNumber = 46;

        assertThatThrownBy(() -> lottoService.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateLottoNumbers () {

        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoNumbers(winningNumbers);
        int bonusNumber = 1;

        assertThatThrownBy(() -> lottoService.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호가 전부 일치하는 경우, 1등의 정보가 증가하는지 테스트")
    @Test
    void TestForFirstPrizeCountIncreases() {

        int count = 1;
        lottoService.repeatPurchase(count);
        winningNumbers = lottoService.getPurchaseLottos().get(0).getLotto();
        lottoService.setWinningLottoNumbers(winningNumbers);
        for(int number = 1; number <= 45; number++) {
            if(!winningNumbers.contains(number)) {
                lottoService.setBonusNumber(number);
                break;
            }
        }

        int first_prize_count = lottoService.calculateWinningDetails().getWinningDetails()
                .get(WinningCriteria.FIRST_PRIZE.getRank());
        assertThat(first_prize_count).isEqualTo(count);
    }

}
