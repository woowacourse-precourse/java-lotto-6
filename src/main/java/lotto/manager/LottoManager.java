package lotto.manager;

import lotto.constants.ErrorMessage;
import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.constants.Rank;
import lotto.domain.WinningLotto;
import lotto.utils.RandomUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {


    private final List<Lotto> buyLottos = new ArrayList<>();
    private WinningLotto winningLotto;

    private final RandomUtils randomUtils = new RandomUtils();

    private final Map<Rank, Integer> lottoResults = new LinkedHashMap<>();

    public LottoManager() {
        lottoResults.put(Rank.FIFTH, 0);
        lottoResults.put(Rank.FOURTH, 0);
        lottoResults.put(Rank.THIRD, 0);
        lottoResults.put(Rank.SECOND, 0);
        lottoResults.put(Rank.FIRST, 0);
    }

    public void setBuyLottos(int payMoney) {
        validatePayAmount(payMoney);

        for (int i = 0; i < payMoney / Value.LOTTO_TICKET_PRICE; i++) {
            List<Integer> numbers = new ArrayList<>(randomUtils.pickSixUniqueRandomNumbers());
            buyLottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getBuyLottos() {
        return buyLottos;
    }

    public Map<Rank, Integer> getLottoResults() {
        return lottoResults;
    }

    private void validatePayAmount(int payMoney) {
        if (payMoney < Value.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.PAY_MONEY_RANGE.getMessage());
        }

        if ((payMoney % Value.LOTTO_TICKET_PRICE) != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAY_MONEY_UNIT.getMessage());
        }
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void calculateRank() {
        buyLottos.forEach(buyLotto -> {
            Rank rank = compareWinningLottoAndBuyLottos(buyLotto.getNumbers());

            if (lottoResults.containsKey(rank)) {
                lottoResults.put(rank, lottoResults.get(rank) + 1);
            }
        });
    }

    private Rank compareWinningLottoAndBuyLottos(List<Integer> buyLottosNumbers) {
        int count = countEqualLottoNumbers(buyLottosNumbers);

        if (count == 5 && isContainBonusNumber(buyLottosNumbers)) {
            return Rank.SECOND;
        }

        return Rank.values()[count];
    }

    private int countEqualLottoNumbers(List<Integer> buyLottosNumbers) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int count = 0;

        for (int winningNumber : winningLottoNumbers) {
            if (buyLottosNumbers.contains(winningNumber)) {
                count++;
            }
        }

        return count;
    }

    private boolean isContainBonusNumber(List<Integer> buyLottosNumbers) {
        int winningBonusNumber = winningLotto.getBonusNumber();

        return buyLottosNumbers.contains(winningBonusNumber);
    }

    public String calculateProfitRate(int payMoney) {
        double profit = lottoResults.entrySet().stream()
                .mapToDouble(rank -> rank.getValue() * rank.getKey().getPrize())
                .sum();

        double profitRate = profit / payMoney * 100;

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(profitRate);
    }
}
