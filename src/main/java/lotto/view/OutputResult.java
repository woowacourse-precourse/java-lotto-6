package lotto.view;

import lotto.dto.Bingo;

public class OutputResult {
    public static void printResult(){
        System.out.println("\n당첨통계\n---");

        System.out.println("3개 일치 (5,000원) - " + Bingo.getBingo3().correctLotto + "개");
        System.out.println("4개 일치 (50,000원) - " + Bingo.getBingo4().correctLotto + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Bingo.getBingo5().correctLotto + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Bingo.getBingo5wB().correctLotto + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Bingo.getBingo6().correctLotto + "개");

    }

}

