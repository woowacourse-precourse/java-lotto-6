package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.text.DecimalFormat;
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

        pickLottoNumbers(userLotto, quantity);
        outputView.printLottoNumbers(userLotto.getLottos());

        WinningLotto winningLotto = inputView.getWinningNumbers();
        inputView.getBonusNumber(winningLotto);
        calculateWinningPrice(userLotto, winningLotto);

        outputView.printLottoResult(countOfWinningResult);
        outputView.printRateOfReturn(calculateRateOfReturn(userLotto));
    }

    private double calculateRateOfReturn(UserLotto userLotto) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format((double) userLotto.getWinningPrice() / userLotto.getPurchasePrice() * 100));
    }

    private void calculateWinningPrice(UserLotto userLotto, WinningLotto winningLotto) {
        List<Lotto> userLottos = userLotto.getLottos();
        userLottos.forEach(uL -> countWinningPrice(userLotto, uL.getNumbers(), winningLotto.getNumbers(), winningLotto.getBonusNumber()));
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
            winLotto(userLotto, WinningResult.SECOND.getValue());
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

    private void pickLottoNumbers(UserLotto userLotto, int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            sortedNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(sortedNumbers);
            lottos.add(lotto);
        }
        userLotto.setLottos(lottos);
    }

    private int calculateQuantity(int money) {
        return money / 1000;
    }

}

