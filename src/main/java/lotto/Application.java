package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
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
        Lotto winNumber = new Lotto(winNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());


        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> tickets = lottoGenerator.getTickets(money);
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (int i = 0; i < tickets.size() ; i++) {
            System.out.println(tickets.get(i).toString());
        }
        LottoChecker lottoChecker = new LottoChecker();
        int totalReward = 0;
        for (int i = 0; i < tickets.size() ; i++) {
            totalReward = lottoChecker.checkReward(tickets.get(i), winNumber, bonusNumber);

        }

        int[] rankCount = lottoChecker.getRankCount();
        System.out.println("3개 일치 (5,000원) - " + rankCount[0]+"개");
        System.out.println("4개 일치 (50,000원) - " + rankCount[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount[4]+"개");

        DecimalFormat df = new DecimalFormat("#.##"); // 소수점 둘째 자리까지 표시
        double profitability = ((double) totalReward / money) * 100;
        System.out.println("총 수익률은 " + df.format(profitability) + "%입니다.");


    }
}
