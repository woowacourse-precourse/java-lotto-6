package lotto.lottoGame;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;
import lotto.customer.Customer;
import lotto.lottoGame.rank.Rank;
import lotto.lottoGame.rank.RankCounter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public final LottoComparator lottoComparator;
    private final LottoRandomGenerator lottoRandomGenerator;
    private final LottoInputGenerator lottoInputGenerator;
    private final ResultCalculrator resultCalculrator;

    public LottoGame(LottoRandomGenerator lottoRandomGenerator, LottoInputGenerator lottoInputGenerator,
                     LottoComparator lottoComparator, ResultCalculrator resultCalculrator) {
        this.lottoRandomGenerator = lottoRandomGenerator;
        this.lottoInputGenerator = lottoInputGenerator;
        this.lottoComparator = lottoComparator;
        this.resultCalculrator = resultCalculrator;
    }

    private Customer initCustomer() {
        Customer customer = null;

        while (customer == null) {
            try {
                String inputPurchaseValue = InputView.inputPrice();
                customer = new Customer(inputPurchaseValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return customer;
    }

    private WinningLotto initWinningLotto() {
        WinningLotto winningLotto = null;

        while (winningLotto == null) {
            try {
                String inputWinningNumbers = InputView.inputWinningLottoNumber();
                Lotto winningNumbers = lottoInputGenerator.inputNumbersToLotto(inputWinningNumbers);

                String inputBonusNumber = InputView.inputWinningBonusNumber();
                int validatedBonusNumber = lottoInputGenerator.inputBonusToValidatedValue(inputBonusNumber);
                winningLotto = new WinningLotto(winningNumbers, validatedBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    public void run() {
        Customer customer = initCustomer();
        issuanceLottos(customer);

        WinningLotto winningLotto = initWinningLotto();
        RankCounter rankCounter = allLottosCompare(winningLotto, customer.getLottos());
        long incomeValue = resultCalculrator.incomeSum(rankCounter);

        double incomeRate = resultCalculrator.calculateIncomeRate(incomeValue, customer.getPurchaseValue());
        OutputView.resultOutput(rankCounter, incomeRate);
    }

    private RankCounter allLottosCompare(WinningLotto winningLotto, List<Lotto> customerLottos) {
        RankCounter rankCounts = new RankCounter();

        for (Lotto lotto : customerLottos) {
            Rank rank = lottoComparator.calculateLottoRank(winningLotto, lotto);
            rankCounts.addCount(rank);
        }

        return rankCounts;
    }


    private void issuanceLottos(Customer customer) {
        int index = customer.getPurchaseValue() / 1000;
        while (customer.getLottoSize() < index) {
            customer.buy(lottoRandomGenerator.generateLottoSortedNumbers());
        }

        OutputView.outputIssuance(index, customer.getLottos());
    }
}
