package lotto;

import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoSeller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public static final LottoMachine lottoMachine = new LottoMachine();
    private Money money;
    private List<Lotto> createdLotto;
    private List<Rank> ranks;

    public void buyLotto() {
        money = receiveMoneyFromPlayer();
        printLottoCount(money);
        createdLotto = getLottos(money);
        printLottos();
    }

    public void noticeStatistic() {
        ranks = calculateRank();
        printRank(ranks);
        printRate(calculateRate(money, ranks));
    }

    private Money receiveMoneyFromPlayer() {
        while (true) {
            try {
                return new Money(inputView.inputMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottoCount(Money money) {
        outputView.printLottoCount(money);
    }

    private List<Lotto> getLottos(Money money) {
        return lottoMachine.createLottos(money.getLottoCount());
    }

    private void printLottos() {
        outputView.printLottos(createdLotto);
    }

    private List<Rank> calculateRank() {
        return lottoMachine.calculateRank(createdLotto);
    }

    private double calculateRate(Money money, List<Rank> ranks) {
        return lottoMachine.calculateRate(money, ranks);
    }

    private void printRank(List<Rank> ranks) {
        int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
        for (Rank rank : ranks) {
            if (rank == Rank.FIRST) {
                first++;
            }
            if (rank == Rank.SECOND) {
                second++;
            }
            if (rank == Rank.THIRD) {
                third++;
            }
            if (rank == Rank.FOURTH) {
                fourth++;
            }
            if (rank == Rank.FIFTH) {
                fifth++;
            }
        }
        outputView.printRank(first, second, third, fourth, fifth);
    }

    private void printRate(double rate) {
        outputView.printRate(rate);
    }
}
