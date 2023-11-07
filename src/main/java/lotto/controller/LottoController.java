package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Map<WinningResult, Integer> countOfWinningResult = new LinkedHashMap<>();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        for (WinningResult winningResult : WinningResult.values()) {
            countOfWinningResult.put(winningResult, 0);
        }
    }

    public void start() {
        int money = inputView.getPurchasePrice();
        UserLotto userLotto = new UserLotto(money);
        int quantity = calculateQuantity(money);
        outputView.printLottoQuantity(quantity);

        List<Lotto> lottos = pickLottoNumbers(quantity);
        userLotto.setLottos(lottos);
        outputView.printLottoNumbers(lottos);

        WinningLotto winningLotto = inputView.getWinningNumbers();
        inputView.getBonusNumber(winningLotto);
        calculateWinningPrice(userLotto, winningLotto);

        outputView.printLottoResult(userLotto, countOfWinningResult);
    }

    private void calculateWinningPrice(UserLotto userLotto, WinningLotto winningLotto) {
        List<Lotto> userLottos = userLotto.getLottos();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        userLottos.stream()
                .forEach(uL -> countWinningPrice(userLotto, uL.getNumbers(), winningLotto.getNumbers(), winningLotto.getBonusNumber()));
    }

    private void countWinningPrice(UserLotto userLotto, List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) {
        int countWinningLottoWithoutBonus = countWinningLotto(numbers, winningNumbers);
        boolean isBonusLotto = countBonusLotto(numbers, bonusNumber);

        if (isCorrectWinningLottoCount(countWinningLottoWithoutBonus)) {
            winLotto(userLotto, countWinningLottoWithoutBonus);
            return;
        }
        if (isCountFive(countWinningLottoWithoutBonus) && !isBonusLotto) {
            winLotto(userLotto, countWinningLottoWithoutBonus);
            return;
        }
        if (isCountFive(countWinningLottoWithoutBonus) && isBonusLotto) {
            winLotto(userLotto, 7);
            return;
        }
    }

    private boolean isCountFive(int count) {
        return count == 5;
    }

    private boolean countBonusLotto(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void winLotto(UserLotto userLotto, int count) {
        WinningResult winningPrice = WinningResult.getWinningPrice(count);
        countOfWinningResult.put(winningPrice, countOfWinningResult.getOrDefault(winningPrice, 0) + 1);
        userLotto.setWinningPrice(winningPrice.getPrice());
    }

    private boolean isCorrectWinningLottoCount(int count) {
        return count == 3 || count == 4 || count == 6;
    }

    private int countWinningLotto(List<Integer> numbers, List<Integer> winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    private List<Lotto> pickLottoNumbers(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            sortedNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(sortedNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private int calculateQuantity(int money) {
        return money / 1000;
    }

}

