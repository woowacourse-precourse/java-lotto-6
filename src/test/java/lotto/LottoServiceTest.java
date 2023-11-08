package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 결과 추출")
    @Test
    void getLotteryStatistics() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))));
        Lotto winningNumbers = new Lotto(new ArrayList<>(List.of(2, 3, 4, 5, 6, 7)));
        int bonusNumber = 1;

        LottoResult lottoResult = lottoService.lotteryStatistics(lottos, winningNumbers, bonusNumber);
        assertEquals(lottoResult.getThree(), 0);
        assertEquals(lottoResult.getFour(), 0);
        assertEquals(lottoResult.getFive(), 0);
        assertEquals(lottoResult.getFive_bonus(), 1);
        assertEquals(lottoResult.getSix(), 0);
    }

    @DisplayName("당첨 개수 추출")
    @Test
    void compareLottoNumberWithWinningNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(3, 4, 5, 6, 7, 8);

        int cnt = lottoService.count(numbers, winningNumbers);

        assertEquals(cnt, 4);
    }

    @DisplayName("보너스 번호 일치 확인")
    @Test
    void checkBonusNumberCorrect() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 2;
        boolean result = lottoService.isBonusNumberCorrect(numbers, bonusNumber);
        assertTrue(result);
    }

    @Test
    void printLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(List.of(6, 5, 4, 3, 2, 1))));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        lottoService.printLottos(lottos);
        assertEquals("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]", out.toString().trim());
    }

    @DisplayName("구입한 로또 수만큼 로또 번호 발행.")
    @Test
    void provideLottoNumbers() {
        List<Lotto> lottos = lottoService.provideLotto(6);
        assertEquals(6, lottos.size());
    }

    @DisplayName("당첨번호가 보너스 번호를 가지고 있을 경우 예외 발생.")
    @Test
    void winningNumbersContainBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "7";
        assertThatThrownBy(() -> {
            lottoService.isWinningNumbersContainBonusNumber(winningNumbers, bonusNumber);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.DUPLICATE_WITH_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("숫자가 아닌 값이 섞여 있을 경우 예외 발생.")
    @Test
    void containsNonNumericCharacters() {
        String input = "1,2,a,b";
        assertThatThrownBy(() -> {
            lottoService.containsNonNumericCharacters(input);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.CONTAINS_NON_NUMERIC_CHARACTERS.getMessage());
    }

    @DisplayName("숫자가 1000으로 나눠 떨어지지 않을 경우 예외 발생.")
    @Test
    void purchaseAmountNotDivideBy1000() {
        String input = "10001";
        assertThatThrownBy(() -> {
            lottoService.isPurchaseAmountDivideBy1000(input);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.PURCHASE_NOT_DIVIDE_BY_1000.getMessage());
    }

    @DisplayName("숫자가 45를 넘을 경우 예외 발생.")
    @Test
    void isLottoNumberOverLimit() {
        String input = "46";
        assertThatThrownBy(() -> {
            lottoService.isNumberOverLimit(input);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.NUMBER_OVER_LIMIT.getMessage());
    }
}