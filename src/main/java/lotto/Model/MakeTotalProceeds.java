package lotto.Model;

import lotto.DTO.StatResultDTO;

public class MakeTotalProceeds {
    int totalProceeds;
    int calval;

    public void makeTotalProceeds(StatResultDTO statResultDTO) {
        totalProceeds = 0;
        calval = 0;
        for (int i = 0; i < 5; i++) {
            // System.out.println("--- 체크 중 " + i + "---");
            // System.out.println(statResultDTO.getWinCount(i));
            int num = statResultDTO.getWinCount(i);
            calval = cal(i, num);
            totalProceeds += calval;
        }

        statResultDTO.setTotalProceeds(totalProceeds);
        //System.out.println(statResultDTO.getTotalProceeds());
    }

    public int cal(int index, int num) {
        int[] prize = { 5000, 50000, 1500000, 30000000, 2000000000 };
        //System.out.println("넘겨 받은 index : "+index );
        if (index >= 0 && index < prize.length) {
            return prize[index] * num;
        }

        throw new IllegalArgumentException();
        // int val = 0;
        // if(index == 0) return 5000*num;
        // if(index == 1) return 50000*num;
        // if(index == 2) return 1500000*num;
        // if(index == 3) return 30000000*num;
        // if(index == 4) return 2000000000*num;

    }
}

// 3개 일치 인덱스 0