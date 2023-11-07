package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Input {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;

    public Input(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }

    public int startInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        System.out.println();
        int numOfTicket = Integer.parseInt(purchaseAmount)/1000;
        System.out.println(numOfTicket+"개를 구매했습니다.");
        for(int i=0; i<numOfTicket; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTicket.add(new Lotto(numbers));
            System.out.print("[");
            System.out.print(lottoTicket.get(i).getNumbers().get(0).intValue()+", ");
            System.out.print(lottoTicket.get(i).getNumbers().get(1).intValue()+", ");
            System.out.print(lottoTicket.get(i).getNumbers().get(2).intValue()+", ");
            System.out.print(lottoTicket.get(i).getNumbers().get(3).intValue()+", ");
            System.out.print(lottoTicket.get(i).getNumbers().get(4).intValue()+", ");
            System.out.print(lottoTicket.get(i).getNumbers().get(5).intValue());
            System.out.println("]");
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = Console.readLine();
        String[] splitWinningNumber = winningNum.split(",");
        for (String num : splitWinningNumber) {
            winningNumber.add(Integer.parseInt(num));
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        int bonusNumber = Integer.parseInt(bonusNum);
        System.out.println();

        return bonusNumber;
    }
}
