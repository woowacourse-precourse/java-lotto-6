package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final int ticketPrice = 1000;

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        List<Integer> winnigNumber;
        int bonusNumber;
        int ticketCount = getticketNumber();

        lottoStore.issueLottoTicket(ticketCount);
        lottoStore.setPrizeMoneys();
        winnigNumber = getWinningNumber();
        bonusNumber = getBonusNumber();
        lottoStore.confirmWin(winnigNumber, bonusNumber);
        lottoStore.printTotalPrize();
        lottoStore.printPrizeRate(ticketPrice);
    }

    public static int getticketNumber() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(readLine());
        return purchasePrice / ticketPrice;
    }

    public static ArrayList<Integer> getWinningNumber() throws IllegalArgumentException{
        ArrayList<Integer> lottoNumber = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumbers= readLine().split(",");

        for(String winnumber: winningNumbers){
            lottoNumber.add(Integer.parseInt(winnumber));
        }

        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public static int getBonusNumber() throws IllegalArgumentException{
        int bonusNumber;

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(readLine());

        return bonusNumber;
    }
}
