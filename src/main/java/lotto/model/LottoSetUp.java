package lotto.model;

import lotto.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoSetUp {
    static int rows;
    static int cols;

    public static int[][] makeListToGetLottos() {
        rows = 6;
        cols = View.getTotalNumber();
        int[][] lottos = new int[cols][rows];

        return lottos;
    }
    public static int[] listToIntArray(List<Integer> list) {
        int[] lottos = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lottos[i] = list.get(i);
        }
        return lottos;
    }

    public static int[][] toMakeIncreseLotto() {
        int[][] lottos = LottoGet.getLottos();
        for(int i = 0; i < View.getTotalNumber(); i++) {
            Arrays.sort(lottos[i]);
        }
        return lottos;
    }

    public static int getcols() {
        return cols;
    }
}
