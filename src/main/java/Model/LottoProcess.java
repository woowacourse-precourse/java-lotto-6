package Model;

import View.BatInput;
import View.ShowPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

enum MESSAGE {
    INPUT_COUNTS("개를 구매했습니다.");
    private final String label;

    MESSAGE(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}

public class LottoProcess {
    static ArrayList<List<Integer>> autoLots = new ArrayList<List<Integer>>();
    static List<Integer> points = Arrays.asList(0, 0, 0, 0, 0);
    static double totalMoney = 0;
    static String totalEarningRate;

    public static void LottoProcess() {
    }

    public static ArrayList<List<Integer>> getAutoLotto(int batCount) {
        System.out.printf("%d%s", batCount, MESSAGE.INPUT_COUNTS.label());
        System.out.println();
        List<Integer> autoLots_1 = new ArrayList<Integer>();

        for (int i = 0; i < batCount; i++) {
            autoLots_1 = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(autoLots_1);
            autoLots.add(autoLots_1);
            System.out.println(autoLots_1);
        }

        System.out.println();
        return autoLots;
    }

    public static int calculation(int price, int batCount, List<Integer> winners, int bonus) {
        for (int i = 0; i < autoLots.size(); i++) {
            getPoint(intersaction(autoLots.get(i), winners), autoLots.get(i), bonus);
        }
        totalMoney = ShowPoint.showPointsInRow(points);
        totalEarningRate = ShowPoint.showEarningRate((double) price, totalMoney);
        return 0;
    }

    public static List<Integer> intersaction(List<Integer> subAutoLots, List<Integer> winners) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.addAll(subAutoLots);
        temp.removeAll(winners);
        result.addAll(subAutoLots);
        result.removeAll(temp);
        return result;
    }

    public static List<Integer> getPoint(List<Integer> intersact, List<Integer> subAutoLots, int bonus) {
        if (intersact.size() == 6) {
            points.set(4, points.get(4) + 1);
        } else if (intersact.size() == 5 && subAutoLots.contains(bonus)) {
            points.set(3, points.get(3) + 1);
        } else if (intersact.size() == 5) {
            points.set(2, points.get(2) + 1);
        } else if (intersact.size() == 4)
            points.set(1, points.get(1) + 1);
        else if (intersact.size() == 3)
            points.set(0, points.get(0) + 1);
        return points;
    }
}
