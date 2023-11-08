package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Controller.ErrorMessage;

public class LottoPlayer {
    private final Integer CACHE_UNIT = 1000;
    private final Integer EARN_RATE_UNIT = 100;
    private Cache investment, profits;
    private ArrayList<Lotto> ownedLottos;

    public LottoPlayer(Integer insertData) {
        validateInitialCache(insertData);

        this.ownedLottos = new ArrayList<>();

        this.investment = new Cache(insertData);
        this.profits = new Cache(0);
    }


    public Integer orderLottos() {
        return investment.getAmount() / CACHE_UNIT;
    }

    public void receiveLotto(Lotto lotto) {
        ownedLottos.add(lotto);
    }


    public double getEarnRate() {
        if (investment.getAmount() == 0) {
            return 0.0;
        }
        return (double) profits.getAmount() / investment.getAmount() * EARN_RATE_UNIT;
    }

    public ScoreBoard calculateScore(LottoData answerLotto, Integer bonusNumber) {
        ScoreBoard roundScore = new ScoreBoard();
        List<Integer> answerNumbers = answerLotto.getNumbers();

        for (Lotto lotto : ownedLottos) {
            Prize prize = lotto.calculatePrize(answerNumbers, bonusNumber);
            getReward(prize);
            roundScore.recordScore(prize);
        }

        return roundScore;
    }

    public void validateInitialCache(Integer insertData) {
        if (isNonPositive(insertData)) {
            throw new IllegalArgumentException(ErrorMessage.CASH_NOT_POSITIVE.getMessage());
        }
        if (isUnit(insertData)) {
            throw new IllegalArgumentException(ErrorMessage.CASH_NOT_THOUSAND.getMessage());
        }
    }


    public ArrayList<LottoData> getLottoDatas() {
        return ownedLottos.stream()
                .map(Lotto::getData)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isNonPositive(Integer insertData) {
        return insertData <= 0;
    }

    private boolean isUnit(Integer insertData) {
        return insertData % CACHE_UNIT != 0;
    }

    private void getReward(Prize prize) {
        profits.deposit(prize.getReward());
    }


}
