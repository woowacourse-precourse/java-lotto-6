package lotto.Model;

import lotto.DTO.StatResultDTO;

public class MakeTotalProceeds {
    int totalProceeds;
    int calval;

    public void makeTotalProceeds(StatResultDTO statResultDTO) {
        totalProceeds = 0;
        calval = 0;
        for (int i = 0; i < 5; i++) {
            int num = statResultDTO.getWinCount(i);
            calval = cal(i, num);
            totalProceeds += calval;
        }

        statResultDTO.setTotalProceeds(totalProceeds);
    }

    public int cal(int index, int num) {
        int[] prize = { 5000, 50000, 1500000, 30000000, 2000000000 };

        if (index >= 0 && index < prize.length) {
            return prize[index] * num;
        }

        throw new IllegalArgumentException();
    }
}