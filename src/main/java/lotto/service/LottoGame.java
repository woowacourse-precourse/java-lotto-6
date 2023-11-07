package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Jackpot;
import lotto.domain.Lotto;
import lotto.dto.LottoResult;
import lotto.util.InputConverter;
import lotto.util.ProfitRateCalculator;
import lotto.util.ResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Lotto.*;

public class LottoGame {

    private int purchasePrice;
    private List<Lotto> lotteries = new ArrayList<>();
    private Jackpot jackpot;
    private LottoResult result;
    private final InputConverter inputConverter = new InputConverter();
    private Lotto lotto;
    private int bonusNumber;

    public LottoGame() {
        buyLotto();

        int ticketQuantity = calculateTicketQuantity();
        generateLotteries(ticketQuantity);
        OutputView.purchaseQuantity(ticketQuantity);
        OutputView.lotteries(lotteries);

        createJackpotLotto();
        createJackpotBonusNumber();
        jackpot = new Jackpot(lotto, bonusNumber);
    }

    private void createJackpotBonusNumber() {
        try {
            bonusNumber = Integer.parseInt(InputView.bonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createJackpotBonusNumber();
        }
    }

    private void createJackpotLotto() {
        try {
            lotto = inputConverter.toLotto(InputView.lottoNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createJackpotLotto();
        }
    }

    private void buyLotto() {
        try {
            purchasePrice = inputConverter.toPurchasePrice(InputView.purchasePrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }

    }

    public void start() {
        generateResult();
        OutputView.lottoResult(result);
        OutputView.profitRate(ProfitRateCalculator.execute(result, purchasePrice));
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), SIZE.getValue());
        return new Lotto(numbers);
    }

    private List<Lotto> generateLotteries(int quantity) {
        while (quantity-- != 0) {
            lotteries.add(generateLotto());
        }
        return lotteries;
    }

    private void generateResult() {
        ResultCalculator calculator = new ResultCalculator();
        result = calculator.execute(lotteries, jackpot);
    }

    private int calculateTicketQuantity() {
        return purchasePrice / COST.getValue();
    }
}
