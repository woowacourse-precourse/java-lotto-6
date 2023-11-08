package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.condition.NumberConditions;

import java.util.ArrayList;
import java.util.List;

import static lotto.condition.NumberConditions.*;
import static lotto.condition.WinningConditions.*;

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

    public void countWinningNumber(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int count = compare(lotto, winningLotto);
            checkContainBonusNumber(lotto, winningLotto);
            calculateWinning(count);
        }
    }

    private void checkContainBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        int bonusNumber = winningLotto.getBonusNumber();
        if (lotto.containsNumber(bonusNumber)) {
            bonusWins = true;
        }
    }

    private int compare(Lotto lotto, WinningLotto winningLotto) {
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
        if (count < FIFTH_PLACE.getCondition()) {
            return;
        }
        if(checkFifthPlaceCondition(count)){
            return;
        }
        if(checkFourthPlaceCondition(count)){
            return;
        }
        if(checkThirdAndSecondPlaceCondition(count)){
            return;
        }
        checkFirstPlaceCondition(count);
    }

    private void checkFirstPlaceCondition(int count) {
        if (count == FIRST_PLACE.getCondition()) {
            sixWins++;
        }
    }

    private boolean checkThirdAndSecondPlaceCondition(int count) {
        if (count == THIRD_PLACE.getCondition()) {
            if (checkSecondPlaceCondition(count)) {
                bonusWins = false;
                return true;
            }
            fiveWins++;
            return true;
        }
        return false;
    }

    private boolean checkSecondPlaceCondition(int count) {
        if (bonusWins) {
            fiveAndBonusWins++;
            return true;
        }
        return false;
    }

    private boolean checkFourthPlaceCondition(int count) {
        if (count == FOURTH_PLACE.getCondition()) {
            fourWins++;
            return true;
        }
        return false;
    }

    private boolean checkFifthPlaceCondition(int count) {
        if (count == FIFTH_PLACE.getCondition()) {
            threeWins++;
            return true;
        }
        return false;
    }

    public void generate() {
        Lotto lotto = new Lotto(generateRandomNumbers());
        addLotto(lotto);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), NUMBER_COUNT.getNumber());
    }

    public int getSize() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
