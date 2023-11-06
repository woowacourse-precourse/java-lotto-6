package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.constans.WinningPrize;
import lotto.validator.PayAmountValidator;
import lotto.validator.Validator;

public class Client {
    private final int payAmount;
    private List<Lotto> lottos = new ArrayList<>();
    private static final Validator PAY_AMOUNT_VALIDATOR = new PayAmountValidator();

    private Client(int payAmount) {
        this.payAmount = payAmount;
    }

    public static Client from(String payAmount) {
        PAY_AMOUNT_VALIDATOR.validate(payAmount);
        return new Client(Integer.parseInt(payAmount));
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void receiveLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        List<Lotto> clonedLottos = new ArrayList<>(lottos);
        return Collections.unmodifiableList(clonedLottos);
    }

    private long calculateWinningPrize(List<Integer> lottoResults) {
        long winningPrize = 0;
        for (int rank = 0; rank < lottoResults.size(); rank++) {
            winningPrize += lottoResults.get(rank) * WinningPrize.getPrizeByRank(rank);
        }
        return winningPrize;
    }

    public double calculateRateOfReturn(List<Integer> lottoResults) {
        double rateOfReturn = (double) calculateWinningPrize(lottoResults) / payAmount;
        rateOfReturn = Math.round(rateOfReturn * 1000) / 10.0;
        return rateOfReturn;
    }
}
