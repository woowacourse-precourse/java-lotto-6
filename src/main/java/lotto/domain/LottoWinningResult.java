package lotto.domain;

import lotto.common.LottoPlace;
import static lotto.common.ContstantValue.*;
import static lotto.common.InfoMessage.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoWinningResult {
    private Map<LottoPlace, Integer> winningResult = new HashMap<>();


    public LottoWinningResult() {
        for (LottoPlace place : LottoPlace.values()) {
            winningResult.put(place, 0);
        }
    }

    public void addWinningPlace(LottoPlace lottoPlace) {
        winningResult.put(lottoPlace, winningResult.get(lottoPlace) + 1);
    }

    public double calculateEarningRate(int initialExpense) {
        double earningRate = ((double) getReward() / initialExpense) * 100;
        return earningRate;

    }

    private int getReward() {
        int reward = 0;
        for (LottoPlace place : winningResult.keySet()) {
            reward += place.getReward() * winningResult.get(place);
        }
        return reward;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<LottoPlace> lottoPlaces = new ArrayList<>(Arrays.asList(LottoPlace.values()));
        lottoPlaces.remove(LottoPlace.OUT_OF_RANK);

        for (LottoPlace place : lottoPlaces) {
            sb.append(place.toString());
            sb.append(" - ");
            sb.append(winningResult.get(place) + "개\n");
        }
        return sb.toString();

    }
}
