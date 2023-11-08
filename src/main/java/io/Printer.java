package io;

import enums.Prize;

import java.util.HashMap;
import java.util.List;

public class Printer {

    public static void printMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoAmount(int lottoAmount) {
        System.out.printf("%d개를 구매했습니다.\n",lottoAmount);
    }

    public static void printWinningNumInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult(HashMap<Prize, Integer> ranking) {
        System.out.println("당첨 통계\n---" );
        System.out.printf("""
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        """, ranking.get(Prize.FIFTH),
                    ranking.get(Prize.FOURTH),ranking.get(Prize.THIRD),
                    ranking.get(Prize.SECOND),ranking.get(Prize.FIRST));
    }

    public static void printRate(float rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.",rate);
    }
}
