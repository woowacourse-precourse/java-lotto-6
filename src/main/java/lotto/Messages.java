package lotto;

import java.util.List;

public class Messages {
    final static int firstPlace = 6;
    final static int secondPlace = 5;
    final static int thridPlace = 5;
    final static int forthPlace = 4;
    final static int fifthPlace = 3;

    public static void priceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void howManyBuy(int ticket) {
        System.out.print(ticket);
        System.out.println("개를 구매했습니다.");
    }

    public static void winNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void winsMessage(List<Integer> wins) {
        for (int i = 4; i >= 0; i--) {
            if (i == 4) {
                System.out.println(fifthPlace + "개 일치 (5,000원) - " + wins.get(i) + "개");
            }
            if (i == 3) {
                System.out.println(forthPlace + "개 일치 (50,000원) - " + wins.get(i) + "개");
            }
            if (i == 2) {
                System.out.println(thridPlace + "개 일치 (1,500,000원) - " + wins.get(i) + "개");
            }
            if (i == 1) {
                System.out.println(secondPlace + "개 일치, 보너스 볼 일치 (30,000,000원) - " + wins.get(i) + "개");
            }
            if (i == 0) {
                System.out.println(firstPlace + "개 일치 (2,000,000,000원) - " + wins.get(i) + "개");
            }
        }
    }
    public static void prizeMessage(int prize, double earn) {
        System.out.println("상금은 "+prize+"원 입니다.");
        System.out.println("총 수익률은 "+earn+"%입니다.");
    }
}
