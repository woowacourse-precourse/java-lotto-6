package lotto.view;

import java.util.List;

public class OutputView {

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", "); // 숫자 사이에 쉼표 추가
            }
        }
        System.out.println("]");
    }
}
