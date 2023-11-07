package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력
        double money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                money = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
        }
        System.out.println();
    }
}
