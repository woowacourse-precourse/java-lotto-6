package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.converter.LottoMessageConverter;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView(outputView);
    static LottoMessageConverter messageConverter = new LottoMessageConverter();

    public static void main(String[] args) {

        // money 입력 기능
        Money money = inputMoneyAmount();

        // lotto 구매 기능
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = purchaseLottos(lottoMachine, money);

        outputView.println(messageConverter.convertLottoNumberMessage(lottos));

        // 당첨 번호 입력
        Lotto winningLotto = createWinningLotto();

        // 보너스 번호 입력
        int bonusNumber = createBonusNumber(winningLotto);

        // 결과 확인
        Map<Rank, Integer> result = new HashMap<>();
        int profit = 0;
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Lotto lotto : lottos) {
            int matchCount = 0;
            boolean isBonusNumberMatched = false;

            for (int winningNumber : winningNumbers) {
                if(lotto.containsNumber(winningNumber)){
                    matchCount++;
                }
            }

            if(matchCount < 3) {
                continue;
            }
            isBonusNumberMatched = lotto.containsNumber(bonusNumber);
            Rank lottoResult = Rank.findByLottoResult(matchCount, isBonusNumberMatched);
            profit += lottoResult.getPrizeMoney();
            result.put(lottoResult, result.get(lottoResult) + 1);
        }

        double profitPercentage = (double) profit / money.getAmount() * 100;
        String lottoResultMessage = messageConverter.convertLottoResultMessage(result, profitPercentage);
        outputView.println(lottoResultMessage);
    }

    private static Money inputMoneyAmount() {
        try {
            int amount = inputView.readLottoPurchaseMoney();
            return new Money(amount);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return inputMoneyAmount();
        }
    }

    private static List<Lotto> purchaseLottos(LottoMachine lottoMachine, Money money) {
        return lottoMachine.purchaseLottos(money);
    }

    private static Lotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputView.readWinningNumbers();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return createWinningLotto();
        }
    }

    private static int createBonusNumber(Lotto winningLotto) {
        try {
            int bonusNumber = inputView.readBonusNumber();
            validateBonusNumbersRange(bonusNumber);
            validateDuplicationWithWinningNumbers(bonusNumber, winningLotto);

            return bonusNumber;
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return createBonusNumber(winningLotto);
        }
    }

    private static void validateBonusNumbersRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }

    private static void validateDuplicationWithWinningNumbers(int bonusNumber, Lotto winningLotto) {
        Optional<Integer> duplicatedNumber = winningLotto.getNumbers().stream()
                .filter(number -> number == bonusNumber)
                .findAny();
        if(duplicatedNumber.isPresent()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
