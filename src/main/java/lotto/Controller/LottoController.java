package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import lotto.Domain.LottoResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        int money = getMoney();
        List<Lotto> lottos = getLottos(money);

        List<Integer> matchNumbers = getMatchNumbers();
        int bonusNumber = getBonusNumber(matchNumbers);

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(matchNumbers,
                bonusNumber);
        EnumMap<LottoRank, Integer> score = lottoResultCalculator.computeLottoScore(lottos);

        outputView.printLottoResult(score);
        outputView.printLottoRatio(score, money);
    }

    private int getMoney() {
        try {
            outputView.printCostMessage();
            int money = inputView.getMoney();
            if (money <= 0) {
                throw new IllegalArgumentException("돈은 0원 초과여야 합니다.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("돈은 1000의 배수여야 합니다.");
            }
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
            return getMoney();
        }
    }

    private List<Lotto> getLottos(int money) {
        int lottoCount = money / 1000;
        outputView.printLottoCount(lottoCount);

        return Stream.generate(() -> {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            outputView.printNumbers(numbers);
            return new Lotto(numbers);
        }).limit(lottoCount).collect(Collectors.toList());
    }

    private List<Integer> getMatchNumbers() {
        try {
            outputView.printMatchNumberMessage();
            return inputView.getMatchNumbers();
        } catch (Exception e) {
            outputView.printError(e);
            return getMatchNumbers();
        }
    }

    private int getBonusNumber(List<Integer> matchNumbers) {
        try {
            outputView.printBonusNumberMessage();
            int bonusNumber = inputView.getBonusNumber();
            if (matchNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("보너스 숫자는 당첨 숫자들과 달라야 합니다.");
            }
            return bonusNumber;
        } catch (Exception e) {
            outputView.printError(e);
            return getBonusNumber(matchNumbers);
        }
    }
}
