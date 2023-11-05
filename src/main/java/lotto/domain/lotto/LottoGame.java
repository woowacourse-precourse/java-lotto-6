package lotto.domain.lotto;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.lotto.converter.LottoMessageConverter;
import lotto.global.constant.message.ErrorMessage;
import lotto.global.exception.LottoIllegalArgumentException;
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

        double profitPercentage = result.calculateProfitPercentage(money);
        printResult(result, profitPercentage);
    }

    private Money inputMoneyAmount() {
        try {
            int amount = inputView.readLottoPurchaseMoney();
            return new Money(amount);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
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
            outputView.printErrorMessage(error);
            return createWinningLotto();
        }
    }

    private LottoNumber createBonusNumber(Lotto winningLotto) {
        try {
            int number = inputView.readBonusNumber();
            LottoNumber bonusNumber = new LottoNumber(number);

            validateBonusNumberDuplication(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            return createBonusNumber(winningLotto);
        }
    }

    private void validateBonusNumberDuplication(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.containsNumber(bonusNumber)) {
            throw new LottoIllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

    private GameResult calculateGameResult(Lotto winningLotto, LottoNumber bonusNumber, List<Lotto> lottos) {
        GameResult result = GameResult.create();
        List<LottoNumber> winningNumbers = winningLotto.getNumbers();

        for (Lotto lotto : lottos) {
            int matchCount = checkMatchCount(lotto, winningNumbers);
            if (matchCount < 3) {
                continue;
            }
            boolean isBonusNumberMatched = lotto.containsNumber(bonusNumber);

            Rank rank = Rank.judgeBy(matchCount, isBonusNumberMatched);
            result.add(rank);
        }

        return result;
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

    private void printResult(GameResult result, double profitPercentage) {
        String lottoResultMessage = LottoMessageConverter.convertLottoResultMessage(result, profitPercentage);
        outputView.println(lottoResultMessage);
    }
}
