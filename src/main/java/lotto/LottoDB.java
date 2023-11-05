package lotto;

import java.util.ArrayList;
import java.util.List;

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

    public void storeLottoNumbers(List<Integer> lottoNumbers) {
        userLottoNumbers.addAll(lottoNumbers);
    }

}
