package lotto.controller;

import java.util.List;

public class Statistics {
    int three;
    int four;
    int five;
    int fiveAndBonus;
    int six;

    public Statistics() {
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.fiveAndBonus = 0;
        this.six = 0;
    }

    public void calculateVariance(List<Integer> winningLotto, List<Integer> myLotto, int bonusNumber) {
        int sameCount = 0;
        int sameBonus = 0;
        for (Integer myNum : myLotto) {
            if(isSameBonusNumber(myNum, bonusNumber)) {
                sameBonus++;
                continue;
            }
            if(isSameNumber(winningLotto, myNum)) {
                sameCount++;
                continue;
            }
        }
    }

    public boolean isSameBonusNumber(int myNum, int bonusNumber) {
        return myNum == bonusNumber;
    }

    public boolean isSameNumber(List<Integer> winningLotto, int myNum) {
        for (Integer winNum : winningLotto) {
            if(myNum == winNum) {
                return true;
            }
        }
        return false;
    }
}
