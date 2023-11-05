package lotto.start;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.func.LottoDraw;
import lotto.func.Winner;

public class LottoStart {

    public void runLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        int purchaseCount = Integer.parseInt(purchaseAmount);

        int numberOfLottoTickets = purchaseCount / 1000;
        List<List<Integer>> lottoTickets = generateLottoTickets(numberOfLottoTickets);
        System.out.println("");
        System.out.println(numberOfLottoTickets + "장을 구매했습니다.");
        for (int i = 0; i < numberOfLottoTickets; i++) {
            System.out.println(lottoTickets.get(i));
        }
        Winner win = new Winner();
        win.winNumber();
    }

    private List<List<Integer>> generateLottoTickets(int numberOfTickets) {
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoTicket = LottoDraw.generateRandomLotto();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

}
