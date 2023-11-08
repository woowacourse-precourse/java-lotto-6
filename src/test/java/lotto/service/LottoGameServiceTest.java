package lotto.service;

import lotto.domain.*;
import lotto.utility.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;
import static lotto.configuration.RandomNumberConfig.COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameServiceTest {
    private LottoGameService lottoGameService = new LottoGameServiceImpl();

    @DisplayName("입력 받은 구매 금액의 문자열 값을 정수값을 가지는 object type으로 포장할 수 있다.")
    @ParameterizedTest
    @CsvSource({"1000", "30000", "500000"})
    void parsePurchaseAmount(int purchaseAmount) {
        // given, when
        PurchaseAmount parsedPurchaseAmount = lottoGameService.parsePurchaseAmount(String.valueOf(purchaseAmount));

        // then
        assertThat(parsedPurchaseAmount.getPurchaseAmount()).isEqualTo(purchaseAmount);
    }

    @DisplayName("구입금액에서 로또 가격을 나눈 만큼의 로또 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000", "3000", "10000", "600000", "7000000"})
    void computeLottoCount(String purchaseAmount) {
        // given
        PurchaseAmount parsedPurchaseAmount = new PurchaseAmount(TypeConverter.convertStringToInt(purchaseAmount));

        // when
        LottoCount lottoCount = lottoGameService.computeLottoCount(parsedPurchaseAmount);

        //then
        assertThat(lottoCount.getLottoCount()).isEqualTo(parsedPurchaseAmount.getPurchaseAmount() / LOTTO_PRICE);
    }

    @DisplayName("설정된 개수만큼의 임의의 숫자를 가진 로또를, 구매한 로또 개수만큼 생성한다.")
    @ParameterizedTest
    @CsvSource({"1000", "3000", "10000", "600000", "7000000"})
    void generateLottos(int purchaseAmount) {
        // given
        LottoCount lottoCount = LottoCount.from(purchaseAmount);

        // given, when
        Lottos lottos = lottoGameService.generateLottos(lottoCount);

        // then
        assertThat(lottos.size()).isEqualTo(lottoCount.getLottoCount());

        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            assertThat(lottos.get(i).getNumbers()).hasSize(COUNT);
        }
    }

    @DisplayName("입력 받은 당첨 번호들의 문자열 값을 정수 리스트를 가지는 object type으로 포장할 수 있다.")
    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5,6'", "'40,41,42,43,44,45'", "'1,7,19,28,37,45'"})
    void parseWinningNumbers(String winningNumberInput) {
        // given
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : winningNumberInput.split(",")) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        // when
        WinningNumbers parsedWinningNumbers = lottoGameService.parseWinningNumbers(winningNumberInput);

        // then
        assertThat(parsedWinningNumbers.getWinningNumbers()).hasSize(COUNT)
                .containsExactly(winningNumbers.get(0), winningNumbers.get(1), winningNumbers.get(2),
                        winningNumbers.get(3), winningNumbers.get(4), winningNumbers.get(5));
    }

    @DisplayName("입력 받은 보너스 번호의 문자열 값을 정수값을 가지는 object type으로 포장할 수 있다.")
    @ParameterizedTest
    @CsvSource({"1", "21", "45"})
    void parseBonusNumber(int bonusNumber) {
        // given, when
        BonusNumber parsedBonusNumber = lottoGameService.parseBonusNumber(String.valueOf(bonusNumber));

        // then
        assertThat(parsedBonusNumber.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("로또 번호와 일치하는 개수에 따라 당첨 횟수를 계산하고, 당첨 횟수를 담은 객체를 반환한다.")
    @Test
    void countMatchingNumbers() {
        // given
        Lottos lottos = new Lottos();
        addLottoToLottos(lottos);
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 4, 5, 17, 37, 45));
        BonusNumber bonusNumber = new BonusNumber(3);

        // when
        Winnings winnings = lottoGameService.countMatchingNumbers(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(winnings.getWinningCount().getCount(3)).isEqualTo(2);
        assertThat(winnings.getWinningCount().getCount(4)).isEqualTo(1);
        assertThat(winnings.getWinningCount().getCount(5)).isEqualTo(1);
        assertThat(winnings.getWinningCount().getCount(7)).isEqualTo(2);
        assertThat(winnings.getWinningCount().getCount(6)).isEqualTo(3);
    }

    private void addLottoToLottos(Lottos lottos) {
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(List.of(4, 12, 17, 32, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 4, 5, 17, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 7, 19, 28, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 3, 5, 17, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 4, 5, 17, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 5, 10, 17, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(3, 4, 5, 17, 37, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 4, 5, 17, 37, 45))));
    }
}
