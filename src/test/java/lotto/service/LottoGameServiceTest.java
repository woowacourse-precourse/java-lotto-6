package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameServiceTest {
    LottoGameService lottoGameService;

    @BeforeEach
    void setUp() {
        lottoGameService = new LottoGameService();
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 문자가 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000a", " ", "20a0", "aA"})
    void containLottoPurchaseAmountNonDigit(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 0원일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "00", "000"})
    void inputZeroValue(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2500", "500"})
    void createPurchaseAmountNotDividedByThousand(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 구분된 숫자 6개가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1,2,3,4,5,6,", "1"})
    void createNotLottoFormat(String lottoNumbers) {
        assertThatThrownBy(() -> lottoGameService.validateInputNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45사이의 번호가 아닌 숫자를 포함할 경우 예외가 발생한다.")
    @Test
    void createLottoNumbersByWrongRange() {
        List<Integer> lottoNumbers = List.of(0, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> lottoGameService.validateWinningNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복된 숫자를 포함할 경우 예외가 발생한다.")
    @Test
    void ContainDuplicateDigits() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> lottoGameService.validateWinningNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 문자일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "25c"})
    void createBonusNumberNonDigit(String bonusNumber) {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoGameService.validateBonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45사이의 숫자가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void createBonusNumberByWrongRange(String bonusNumber) {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoGameService.validateBonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함될 때 예외가 발생한다.")
    @Test
    void createBonusNumberByWrongRange() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = String.valueOf(lottoNumbers.get(0));
        assertThatThrownBy(() -> lottoGameService.validateBonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 0개 일치")
    @Test
    void collectNumberIsZero() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(7, 8, 9, 10, 11, 12);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(0);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 1개 일치")
    @Test
    void collectNumberIsOne() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(6, 8, 9, 10, 11, 12);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 2개 일치")
    @Test
    void collectNumberIsTwo() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(5, 6, 9, 10, 11, 12);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(2);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 3개 일치")
    @Test
    void collectNumberIsThree() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(4, 5, 6, 10, 11, 12);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(3);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 4개 일치")
    @Test
    void collectNumberIsFour() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(3, 4, 5, 6, 11, 12);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(4);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 5개 일치")
    @Test
    void collectNumberIsFive() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(2, 3, 4, 5, 6, 12);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(5);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호 6개 일치")
    @Test
    void collectNumberIsSix() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);

        long collectNumberCount
                = lottoGameService.getCollectNumberCount(purchaseLotto, winningLotto);

        assertThat(collectNumberCount).isEqualTo(6);
    }

    @DisplayName("구매한 로또 번호와 보너스 번호 포함 여부")
    @Test
    void collectBonusNumber() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber1 = 1;
        int bonusNumber2 = 7;

        assertThat(lottoGameService.isContainBonusNumber(purchaseLotto, bonusNumber1))
                .isEqualTo(true);
        assertThat(lottoGameService.isContainBonusNumber(purchaseLotto, bonusNumber2))
                .isEqualTo(false);
    }

    @DisplayName("당첨 번호와 5개 일치, 보너스 번호 미포함일 경우 3등")
    @Test
    void collectNumberIsFiveAndNotContainBonusNumber() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 12);
        int bonusNumber = 13;

        assertThat(lottoGameService.determineWinningRank(purchaseLotto, winningLotto, bonusNumber))
                .isEqualTo(LottoRank.THIRD_PLACE);
    }

    @DisplayName("당첨 번호와 5개 일치, 보너스 번호 포함일 경우 2등")
    @Test
    void collectNumberIsFiveAndContainBonusNumber() {
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 12);
        int bonusNumber = 6;

        assertThat(lottoGameService.determineWinningRank(purchaseLotto, winningLotto, bonusNumber))
                .isEqualTo(LottoRank.SECOND_PLACE);
    }

    @DisplayName("구입 금액이 8,000원, 5등 당첨일 경우 수익률은 62.5%")
    @Test
    void createFifthPlaceAndCalculateProfitRate() {
        String purchaseAmount = "8000";
        List<Integer> purchaseLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(1, 2, 3, 10, 11, 12);
        int bonusNumber = 13;

        LottoRank rank = lottoGameService.determineWinningRank(purchaseLotto, winningLotto, bonusNumber);
        lottoGameService.updateWinningCount(rank);
        EnumMap<LottoRank, Integer> lottoRanking = lottoGameService.getLottoRakingMap();
        double profitRate = lottoGameService.calculateProfitRate(purchaseAmount, lottoRanking);

        assertThat(profitRate).isEqualTo(62.5);
    }
}