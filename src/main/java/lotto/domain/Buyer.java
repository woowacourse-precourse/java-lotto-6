package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Error;
import lotto.util.Utils;
import lotto.view.outputMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer {
    public static final int ONE_LOTTO_PRICE = 1000;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_COUNT = 6;

    private final ArrayList<Lotto> lotteries = new ArrayList<>();
    private final int price;

    public ArrayList<Lotto> getLotteries() {
        return lotteries;
    }

    public Buyer(int price) {
        this.price = price;
        makeLotteries();
        outputMessage.buyMessage(lotteries);
    }

    private void makeLotteries() {
        int amount = calculationAmount(price);
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            lotteries.add(lotto);
        }
    }

    public int calculationAmount(int price) {
        if (price % ONE_LOTTO_PRICE != 0){
            Error error = Error.PRICE_WRONG;
            Utils.backFunction(error);
        }
        return price / ONE_LOTTO_PRICE;
    }

    private List<Integer> makeLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }

    private long sumPrizeMoney(HashMap<Rank, Integer> ranks) {
        long totalMoney = 0;
        for (Rank rank : ranks.keySet()) {
            if (ranks.getOrDefault(rank, 0) == 0) {
                continue;
            }
            totalMoney += rank.getMoney();
        }
        return totalMoney;
    }

    public double calculationEarningRate(HashMap<Rank, Integer> ranks) {
        double totalPrizeMoney = sumPrizeMoney(ranks) * 1.0;
        return (totalPrizeMoney / price) * 100.0;
    }
}
