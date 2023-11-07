package lotto;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static Integer buyTickets(){
        while (true) {
            try {
                Integer N = Integer.parseInt(Console.readLine());
                if (N % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                return N/1000;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1000원 단위로 입력해주세요.");
            }
        }
               
    }
    public static void main(String[] args) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 10, 6);
        Collections.sort(numbers);
        System.out.println(numbers);

        List<Integer> players = Randoms.pickUniqueNumbersInRange(1, 10, 6);
        Collections.sort(players);
        System.out.println(players);
        
        Lotto lotto = new Lotto(numbers);
        int count = lotto.run(players);
        System.out.println(count);

        buyTickets();
    }
}
