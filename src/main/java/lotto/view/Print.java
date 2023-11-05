package lotto.view;

import lotto.controller.Rank;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Print {
    public static void printBoughtLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> lotto) {
        List<String> tmpLotto = new ArrayList<>();
        for (int lottoNumber : lotto) {
            tmpLotto.add(String.valueOf(lottoNumber));
        }
        String allNumber = "[";
        allNumber += String.join(", ", tmpLotto);
        allNumber += "]";
        System.out.println(allNumber);
    }

    public static void printResultRank(HashMap<Rank, Integer> result) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Rank rank : Rank.values()) {
            if (result.containsKey(rank)) {
                count = result.get(rank);
            }
            sb.append(rank.getResultPrint()).append(count).append("개\n");
            count = 0;
        }
        System.out.print(sb);
    }

    public static void printMean(double mean) {
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ").append(String.format("%.1f",mean)).append("%입니다.");
        System.out.println(sb.toString());
    }
}
