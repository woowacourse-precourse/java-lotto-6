package lotto.domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.GameResult;
import lotto.domain.Rank;
import lotto.domain.lotto.converter.LottoMessageConverter;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }


    public void run() {
        Money money = inputMoneyAmount();
        List<Lotto> lottos = purchaseLottos(money);

        Lotto winningLotto = createWinningLotto();
        LottoNumber bonusNumber = createBonusNumber(winningLotto);

        GameResult result = calculateGameResult(winningLotto, bonusNumber, lottos);

        double profitPercentage = calculateProfitPercentage(result.calculateProfit(), money);
        printResult(result, profitPercentage);
    }


    private GameResult calculateGameResult(Lotto winningLotto, LottoNumber bonusNumber, List<Lotto> lottos) {
        Map<Rank, Integer> result = initLottoResult();
        List<LottoNumber> winningNumbers = winningLotto.getNumbers();

        for (Lotto lotto : lottos) {
            int matchCount = checkMatchCount(lotto, winningNumbers);
            if (matchCount < 3) {
                continue;
            }
            boolean isBonusNumberMatched = lotto.containsNumber(bonusNumber);

            Rank rank = Rank.calcualteBy(matchCount, isBonusNumberMatched);
            result.put(rank, result.get(rank) + 1);
        }

        return new GameResult(result);
    }

    private void printResult(GameResult result, double profitPercentage) {
        String lottoResultMessage = LottoMessageConverter.convertLottoResultMessage(result, profitPercentage);
        outputView.println(lottoResultMessage);
    }

    private double calculateProfitPercentage(int profit, Money money) {
        return (double) profit / money.getAmount() * 100;
    }

    private int checkMatchCount(Lotto lotto, List<LottoNumber> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber winningNumber : winningNumbers) {
            if (lotto.containsNumber(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static Map<Rank, Integer> initLottoResult() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        return result;
    }

    private Money inputMoneyAmount() {
        try {
            int amount = inputView.readLottoPurchaseMoney();
            return new Money(amount);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return inputMoneyAmount();
        }
    }

    private List<Lotto> purchaseLottos(Money money) {
        List<Lotto> lottos = lottoMachine.purchaseLottos(money);
        outputView.println(LottoMessageConverter.convertLottoNumberMessage(lottos));

        return lottos;
    }

    private Lotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputView.readWinningNumbers();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return createWinningLotto();
        }
    }

    private LottoNumber createBonusNumber(Lotto winningLotto) {
        try {
            int number = inputView.readBonusNumber();
            LottoNumber bonusNumber = new LottoNumber(number);

            if (winningLotto.containsNumber(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
            }
            return bonusNumber;
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return createBonusNumber(winningLotto);
        }
    }
}
