package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Shop {

    private final Set<Lotto> lottos;
    private final Money money;
    private final WinnerLotto winnerLotto;
    private final InputView inputView;
    private final OutputView outputView;

    private Shop() {
        this.money = new Money();
        this.winnerLotto = new WinnerLotto();
        this.lottos = new HashSet<>();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static Shop visitShop() {
        return new Shop();
    }

    public void buyLottos() {
        String input = inputView.showInputMoneyMessage();
        money.inputMoney(input);
        int quantity = money.countQuantity();
        generateLottos(quantity);
        outputView.showQuantityMessage(quantity);
    }

    public void checkLottoResult() {
        winnerLotto.createWinnerLotto();
        winnerLotto.matchWinnerLotto(lottos);
        winnerLotto.showResultBoard();
        int prize = winnerLotto.calculatePrize();
        outputView.showIncomeRate(money.calculateIncomeRate(prize));
    }

    public void generateLottos(int quantityOfLotto) {
        for (int i = 0; i < quantityOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            showGeneratedLottos(numbers);
        }
    }

    private void showGeneratedLottos(List<Integer> LottoNumbers) {
        outputView.showLotto(LottoNumbers.stream().sorted().collect(Collectors.toList()));
    }
}
