package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private int threeWins = 0;
    private int fourWins = 0;
    private int fiveWins = 0;
    private int fiveAndBonusWins = 0;
    private int sixWins = 0;
    private boolean bonusWins = false;

    public int getThreeWins() {

        return threeWins;
    }

    public int getFourWins() {

        return fourWins;
    }

    public int getFiveWins() {

        return fiveWins;
    }

    public int getFiveAndBonusWins() {

        return fiveAndBonusWins;
    }

    public int getSixWins() {

        return sixWins;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void countWinningNumber(Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int count = compare(lotto, winningLotto);
            calculateWinning(count);
        }
    }

    private int compare(Lotto lotto, Lotto winningLotto) {
        int count = 0;

        for (int i = 0; i < lotto.size(); i++) {
            int winningNumber = winningLotto.getNumber(i);
            if (lotto.containsNumber(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private void calculateWinning(int count) {
        if (count == 3) {
            threeWins++;
            return;
        }
        if (count == 4) {
            fourWins++;
            return;
        }
        if (count == 5) {
            fiveWins++;
            return;
        }
        if (count == 6) {
            sixWins++;
        }
    }
}
