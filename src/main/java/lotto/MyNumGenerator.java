package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MyNumGenerator {
    private final int countLotto; // 구매한 로또의 수량

    public MyNumGenerator(int count) {
        this.countLotto = count;
    }

    protected List<List<Integer>> generateNums() {
        List<List<Integer>> myNums = new ArrayList<>();
        List<Integer> myNum = new ArrayList<>();

        for(int i = 0; i < countLotto; i++) {
            myNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myNums.add(myNum);
        }
        return myNums;
    }
}
