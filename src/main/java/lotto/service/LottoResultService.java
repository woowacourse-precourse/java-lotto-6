package lotto.service;

import lotto.constants.Message;
import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.*;

public class LottoResultService {

    private WinningLotto winningLotto;
    private final Map<Rank, Integer> lottoResults = new LinkedHashMap<>();

    public LottoResultService() {
        lottoResults.put(Rank.FIFTH, 0);
        lottoResults.put(Rank.FOURTH, 0);
        lottoResults.put(Rank.THIRD, 0);
        lottoResults.put(Rank.SECOND, 0);
        lottoResults.put(Rank.FIRST, 0);
    }


    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void showRank(List<Lotto> buyLottos) {
        setRank(buyLottos);

        System.out.println(Message.PAY_MONEY_REQUEST_MESSAGE);
        Set<Rank> ranks = lottoResults.keySet();

        for (Rank rank : ranks) {
            System.out.println(rank.toString() + " - " + lottoResults.get(rank) + "개");
        }
    }

    private void setRank(List<Lotto> buyLottos) {
        buyLottos.forEach(buyLotto -> {
            Rank rank = calculateRank(buyLotto.getNumbers());

            if (lottoResults.containsKey(rank)) {
                lottoResults.put(rank, lottoResults.get(rank) + 1);
            }
        });
    }

    private Rank calculateRank(List<Integer> buyLottosNumbers) {
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

    public void showProfitRate(int payMoney) {
        double profit = lottoResults.entrySet().stream()
                .mapToDouble(rank -> rank.getValue() * rank.getKey().getPrize())
                .sum();

        double profitRate = profit / payMoney * 100;

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        System.out.println("총 수익률은 " + decimalFormat.format(profitRate) + "%입니다.");
    }
}
