package lotto.model;

import lotto.EarningPrize;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final int first;
    private final int second;
    private final int third;
    private final int fourth;
    private final int fifth;
    private final float earningRate;

    public Model(List<Lotto> lottos, List<Integer> winnigNumbers, int bonusNumber) {
        List<Integer> lottosResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottosResult.add(lotto.checkLotto(winnigNumbers, bonusNumber));
        }

        this.first = (int)lottosResult.stream().filter(num -> num == 1).count();
        this.second = (int)lottosResult.stream().filter(num -> num == 2).count();
        this.third = (int)lottosResult.stream().filter(num -> num == 3).count();
        this.fourth = (int)lottosResult.stream().filter(num -> num == 4).count();
        this.fifth = (int)lottosResult.stream().filter(num -> num == 5).count();

        earningRate = (float) ((first * EarningPrize.FIRST.getPrize())
                + (second * EarningPrize.SECOND.getPrize())
                + (third * EarningPrize.THIRD.getPrize())
                + (fourth * EarningPrize.FOURTH.getPrize())
                + (fifth * EarningPrize.FIFTH.getPrize()))
                / (lottos.size() * 1000);
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public float getEarningRate() {
        return earningRate;
    }
}
