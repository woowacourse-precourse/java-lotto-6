package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoDB {

    // instance
    private final ArrayList<Integer> userLottoNumbers;

    private int userLottoCount;

    public LottoDB() {
        userLottoNumbers = new ArrayList<>();
        userLottoCount = 0;
    }

    public int getUserLottoCount() {
        return userLottoCount;
    }

    public void storeLottoNumbers(List<Integer> lottoNumbers) {
        userLottoNumbers.addAll(lottoNumbers);
    }

    public void saveUserLottoCount(int userLottoCountIn) {
        this.userLottoCount = userLottoCountIn;
    }

}
