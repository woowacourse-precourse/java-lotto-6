package random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Random {
    static private int start = 1;
    static private int end = 45;
    static private int count = 6;

    public Random() {

    }

    public Random(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    public List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
