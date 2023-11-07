package lotto;

import java.util.ArrayList;

public class PrintStatisticAndRevenue {
    ArrayList<Integer> matchingStatus;
    int totalPrice;
    int initPrice;

    public PrintStatisticAndRevenue(ArrayList<Integer> matchingStatus, int initPrice) {
        this.matchingStatus = matchingStatus;
        this.totalPrice = 0;
        this.initPrice = initPrice;
        printStatistic();
        printRevenue();
    }

    void printStatistic() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchingStatus.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchingStatus.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchingStatus.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingStatus.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchingStatus.get(4) + "개");
    }

    void caculateTotalPrice() {
        for (int i = 0; i < matchingStatus.size(); i++) {
            totalPrice += caculatePrice(i, matchingStatus.get(i));
        }
    }

    int caculatePrice(int price, int many) {
        if (price == 0) {
            return 5000 * many;
        }
        if (price == 1) {
            return 50000 * many;
        }
        if (price == 2) {
            return 1500000 * many;
        }
        if (price == 3) {
            return 30000000 * many;
        }
        return 2000000000 * many;
    }
    void printRevenue(){
        caculateTotalPrice();
        System.out.println("총 수익률은 " + ((double)totalPrice / (double)initPrice) * 100 + "%입니다.");
    }
}
