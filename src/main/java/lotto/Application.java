package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoGenerator;

public class Application {
    public static void main(String[] args) {

        int money = Integer.parseInt(Console.readLine());

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> tickets = lottoGenerator.getTickets(money);

        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (int i = 0; i < tickets.size() ; i++) {
            System.out.println(tickets.get(i));
        }
    }
}
