package lotto.view;

import java.util.List;

public class OutputView {

    public static void printLottoNumbers (StringBuilder numbers) {
        System.out.println(numbers);
    }

    public static void printLottoResult (int sameThree, int sameFour, int sameFive, int sameFiveBonus, int sameAll, int result) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+sameThree+"개");
        System.out.println("4개 일치 (50,000원) - "+sameFour+"개");
        System.out.println("5개 일치 (1,500,000원) - "+sameFive+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+sameFiveBonus+"개");
        System.out.println("6개 일치 (200,000,000원) - "+sameAll+"개");
        System.out.println("총 수익률은 "+result+"입니다.");
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
