package lotto.view;

import lotto.controller.Rank;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Print {
    public static void printPrice(int price) {
        System.out.println(price);
    }
    public static void printBoughtLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottery(List<Lotto> lottery) {
        for (Lotto lotto : lottery) {
            printLottoNumber(lotto);
        }
    }

    public static void printLottoNumber(Lotto lotto) {
        List<String> tmpLotto = new ArrayList<>();
        for (int lottoNumber : lotto.getLotto()) {
            tmpLotto.add(String.valueOf(lottoNumber));
        }
        String allNumber = "[";
        allNumber += String.join(",", tmpLotto);
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
            sb.append(rank.getCorrectNum()).append("개 일치 (").append(rank.getPrize())
                            .append("원) - ").append(count).append("개\n");
        }
        System.out.println(sb);
    }

    public static void printStatistics() {

    }

    public static void printMean(float mean) {
        System.out.println("총 수익률은 " + mean + "%입니다.");
    }
}
