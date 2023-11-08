package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = 0;

        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                price = Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 형식이 올바르지 않습니다.");
                continue;
            }
            try {
                if (price % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] IllegalArgumentException");
                } else if (price % 1000 == 0){
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

    }
}

