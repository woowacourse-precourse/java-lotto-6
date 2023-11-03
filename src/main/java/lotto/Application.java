package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int price = inputPrice(0);
    }

    public static int inputPrice(int price) {
        while (true) {
            while (true) {
                try {
                    price = Integer.parseInt(Console.readLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자로 입력해 주세요.");
                }
            }
            if (price % 1000 == 0) return price;
            System.out.println("[ERROR] 1000단위로 입력해 주세요.");
        }
    }

}
