package lotto;

import java.util.ArrayList;

public class LottoDB {

    // instance
    private ArrayList<Integer> userLottoNumbers;
    private int userLottoCount;

    public LottoDB() {
        userLottoNumbers = new ArrayList<>();
        userLottoCount = 0;
    }

    public void setUserLottoCount(int count) throws IllegalArgumentException {
        int countMod = count % 1000;
        if (countMod != 0) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 1,000단위가 아닙니다.");
        }
        userLottoCount += count / 1000;
        System.out.println(userLottoCount);
    }

}
