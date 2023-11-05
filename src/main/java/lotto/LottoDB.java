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

    public void setUserLottoCount(int count) {
        int game = count / 1000;
        System.out.println(game);
        userLottoCount += game;
    }

}
