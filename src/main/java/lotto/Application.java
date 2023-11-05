package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = new ArrayList<>();
        String inputWinNumber = Console.readLine();
        for (String s : inputWinNumber.split(",")){
            winNumbers.add(Integer.parseInt(s));
        }
        Lotto lotto = new Lotto(winNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());


        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> tickets = lottoGenerator.getTickets(money);
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (int i = 0; i < tickets.size() ; i++) {
            System.out.println(tickets.get(i));
        }
    }
}
