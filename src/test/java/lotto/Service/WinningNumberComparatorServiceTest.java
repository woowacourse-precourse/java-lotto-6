package lotto.Service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Domain.Lotto;
import lotto.Domain.PlayerPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class WinningNumberComparatorServiceTest {
    private WinningNumberComparatorService winningNumberComparatorService;

    @BeforeEach
    public void setUp() {
        winningNumberComparatorService = new WinningNumberComparatorService();
    }

    @DisplayName("로또 번호의 당첨 개수를 테스트한다.")
    @Test
    public void playerNumberDrawCount() {
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(2, 21, 30, 7, 8, 9);

        int count = winningNumberComparatorService.compareWinningAndPlayerNumbers(userNumbers, lottoNumbers);

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("보너스번호를 제외하고 로또 번호 5개가 일치하는지 테스트한다.")
    @Test
    public void LottoNumbersCompareFive() {
        int countContainsOfLotto = 5;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(9);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(26);

        boolean result = winningNumberComparatorService.checkSecondPrizeWinning(countContainsOfLotto, numbers, lotto);

        assertThat(result).isTrue();
    }

    @DisplayName("보너스번호를 제외하고 로또 번호 6개가 일치하는지 테스트한다.")
    @Test
    public void LottoNumbersCompareSix() {
        int countContainsOfLotto = 6;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(43);

        boolean result = winningNumberComparatorService.checkSecondPrizeWinning(countContainsOfLotto, numbers, lotto);

        assertThat(result).isFalse(); //2등이 아니기 때문에 False가 나와야 함.
    }

    @DisplayName("보너스 번호를 포함해 6개 일치할 경우를 테스트한다.")
    @Test
    public void BounsNumberOneAndLottoNumbersFive() {
        int countContainsOfLotto = 5;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //Lotto 클래스의 선언 방식에 따라 add를 사용
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(9);
        lottoNumbers.add(6);
        lottoNumbers.add(5);
        lottoNumbers.add(4);
        lottoNumbers.add(3);
        lottoNumbers.add(2);
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(1);

        boolean result = winningNumberComparatorService.compareBonusCase(countContainsOfLotto, numbers, lotto);

        assertThat(result).isTrue();
    }

    @DisplayName("보너스 번호 없이 0개 일치, 3개 일치, 4개 일치, 6개 일치의 결과가 나오는지 테스트한다.")
    @Test
    public void BasicLottoNumberCompare() {
        List<Integer> counts = List.of(0, 3, 4, 6);

        List<Boolean> results = new ArrayList<>();
        for (int count : counts) {
            results.add(winningNumberComparatorService.compareBasicCase(count));
        }

        assertThat(results).containsExactly(false, true, true, true);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    public void ROI() {
        PlayerPrice playerPrice = new PlayerPrice(20000);
        int totalPrice = 10000;

        String result = winningNumberComparatorService.extractROI(playerPrice, totalPrice);

        assertThat(result).isEqualTo("50.0");
    }
}
