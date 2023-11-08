package lotto;

import lotto.controller.LottoController;
import lotto.model.*;
import lotto.util.RandomNumberGenerator;
import lotto.util.ResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LottoGameIntegrationTest {
    private InputView inputView;
    private OutputView outputView;
    private RandomNumberGenerator randomNumberGenerator;
    private ResultCalculator resultCalculator;

    @BeforeEach
    public void setup() {
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        randomNumberGenerator = new RandomNumberGenerator() {
            @Override
            public List<Integer> pickLottoNumberInRange() {
                // Return fixed random numbers for testing
                return Arrays.asList(1, 2, 3, 4, 5, 6);
            }
        };
        resultCalculator = new ResultCalculator();
    }

    @Test
    public void testLottoGameIntegration() {
        // Arrange
        String inputAmount = "5000";
        String winningLotto = "1,2,3,4,5,6";
        String bonusNumber = "7";

        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Lotto> userLottos = randomNumbers.stream()
                .map(numbers -> new Lotto(Arrays.asList(numbers)))
                .collect(Collectors.toList());

        Amount amount = new Amount(inputAmount);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(bonusNumber, lotto);
        UserLotto userLotto = new UserLotto(userLottos);

        LottoController lottoController = new LottoController(randomNumberGenerator, resultCalculator);

        Mockito.when(InputView.getInputAmount()).thenReturn(inputAmount);
        Mockito.when(InputView.getWinningLotto()).thenReturn(winningLotto);
        Mockito.when(InputView.getBonusNumber()).thenReturn(bonusNumber);

        // Act
        lottoController.run();

        // Assert
        Mockito.verify(outputView);
        OutputView.printPurchaseLottoCount(amount.getAmount());
        Mockito.verify(outputView);
        OutputView.printLottos(userLotto);

        for (Rank rank : Rank.values()) {
            Mockito.verify(outputView);
            OutputView.printLottoPrize(
                    rank.getDescription(),
                    rank.getPrize(),
                    (int) resultCalculator.countMatchingResults(lottoController.getResults(), rank)
            );
        }

        Mockito.verify(outputView);
        OutputView.printProfit(50.0);
    }
}
