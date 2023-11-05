package lotto.manager;

import java.util.List;

public class OutputManager {
    public void printInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void printRandomNumber(List<List<Integer>> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

    public void printWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
