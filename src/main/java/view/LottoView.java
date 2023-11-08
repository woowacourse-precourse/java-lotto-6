package view;

import java.util.List;
import java.util.Scanner;

public class LottoView {
    public void printNumbers(List<Integer> numbers) {
        System.out.print("로또 번호: ");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public int getPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("구입 금액을 입력하세요: ");
        return scanner.nextInt();
    }
}
