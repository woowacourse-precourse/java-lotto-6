package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {

    private int startNum;
    private int endNum;

    public RandomNumGenerator(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public int generate() {
        return Randoms.pickNumberInRange(startNum, endNum);
    }

}
