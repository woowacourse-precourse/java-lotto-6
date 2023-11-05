package lotto.service;

import lotto.constants.Message;
import lotto.constants.Value;
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

    public void showRank(List<Lotto> userLottos) {
        calculateLottoResult(userLottos);

        System.out.println(Message.AMOUNT_REQUEST_MESSAGE);
        Set<Rank> ranks = lottoResults.keySet();

        for (Rank rank : ranks) {
            System.out.println(rank.toString() + " - " + lottoResults.get(rank) + "개");
        }
    }

    public void calculateLottoResult(List<Lotto> userLottos) {
        userLottos.forEach(userLotto -> {
            Rank rank = compareUserLottoAndWinningLotto(userLotto.getNumbers());
            if (lottoResults.containsKey(rank)) {
                lottoResults.put(rank, lottoResults.get(rank) + 1);
            }
        });
    }

    private Rank compareUserLottoAndWinningLotto(List<Integer> userLottoNumbers) {

        int count = getSameNumberCount(userLottoNumbers);

        if (count == 5 && isContainBonusNumber(userLottoNumbers)) {
            return Rank.SECOND;
        }

        return Rank.values()[count];
    }

    private int getSameNumberCount(List<Integer> userLottoNumbers) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();

        int count = 0;
        for (int userLottoNumber : userLottoNumbers) {
            if (winningLottoNumbers.contains(userLottoNumber)) {
                count++;
            }
        }

        return count;
    }

    private boolean isContainBonusNumber(List<Integer> userLottoNumbers) {
        int winningLottoBonusNumber = winningLotto.getBonusNumber();

        return userLottoNumbers.contains(winningLottoBonusNumber);
    }

    public void showProfitRate(int amount) {
        int profit = 0;
        List<Rank> ranks = new ArrayList<>(lottoResults.keySet().stream().toList());

        for (Rank rank : ranks) {
            profit += (lottoResults.get(rank) * rank.getPrize());
        }

        double profitRate = profit / (double) amount * 100;

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        System.out.println("총 수익률은 " + decimalFormat.format(profitRate) + "%입니다.");
    }
}
