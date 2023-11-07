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

    private List<Lotto> lotteries = new ArrayList<>();
    private LottoResult result;
    private final int purchasePrice;
    private final Jackpot jackpot;
    private final InputConverter inputConverter = new InputConverter();

    public LottoGame() {
        purchasePrice = inputConverter.toPurchasePrice(InputView.purchasePrice());

        int ticketQuantity = purchasePrice / COST.getValue();
        generateLotteries(ticketQuantity);
        OutputView.purchaseQuantity(ticketQuantity);
        OutputView.lotteries(lotteries);

        Lotto lotto = inputConverter.toLotto(InputView.lottoNumber());
        int bonusNumber = Integer.parseInt(InputView.bonusNumber());
        jackpot = new Jackpot(lotto, bonusNumber);
    }

    public void start() {
        int quantity = calculateTicketQuantity();
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
