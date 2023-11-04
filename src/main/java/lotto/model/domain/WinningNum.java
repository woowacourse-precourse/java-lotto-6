package lotto.model.domain;

import java.util.ArrayList;

public class WinningNum {

    private final ArrayList<Integer> winningnum;

    WinningNum(ArrayList<Integer> winningnum) {
        this.winningnum = winningnum;
    }

    public ArrayList<Integer> getWinningnum() {
        return this.winningnum;
    }
}
