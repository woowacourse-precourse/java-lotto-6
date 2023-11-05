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

    public void setUserLottoCount(int userLottoCount) throws IllegalArgumentException {
        this.userLottoCount = userLottoCount / 1000;
    }

    public int getUserLottoCount() {
        return userLottoCount;
    }


}
