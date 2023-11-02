package lotto.view;

import java.util.List;

public class OutputView {

    private String[] strs = {
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (200,000,000원) - ",
    };

    public static void printLottoNumbers (StringBuilder numbers) {
        System.out.println(numbers);
    }

    public void printLottoResult (int[] result, double percentage) {
        System.out.println("당첨 통계\n---");
        for(int i = 0; i < this.strs.length; i++) {
            System.out.println(this.strs[i]+result[i]+"개");
        }
        System.out.println("총 수익률은 "+percentage+"%입니다.");
    }

    public static void printIsInteger () {
        System.out.println("[ERROR] 숫자 형태의 값이여야 합니다.");
    }

    public static void printIsWrongMoney () {
        System.out.println("[ERROR] 1000원 단위의 금액이여야 합니다.");
    }

    public static void printIsMinMoney () {
        System.out.println("[ERROR] 1000원 이상의 금액이여야 합니다.");
    }

    public static void printIsUnique () {
        System.out.println("[ERROR] 고유한 값들 이여야 합니다.");
    }

    public static void printIsWrongRange () {
        System.out.println("[ERROR] 1 ~ 45 사이의 숫자여야 합니다.");
    }

    public static void printIsWrongLength () {
        System.out.println("[ERROR] 6개의 숫자를 입력해야 합니다.");
    }

    public static void printIsDuplicate () {
        System.out.println("[ERROR] 중복된 값이 아니여야 합니다.");
    }
}
