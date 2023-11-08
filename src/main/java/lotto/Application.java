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
        // 구매 출력
        int lottoCnt = price / 1000;
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lottos.add(new Lotto(new ArrayList<Integer>(numbers)));
        }
        int[] goalCount = new int[10];
        System.out.println(lottoCnt + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            lottos.get(i).printNumbers();
        }


    }
}

