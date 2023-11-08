package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class Player{
    private int amount;
    private int numberOfTickets;
    private List<Integer>[] lotto;

    public void inputAmount(){
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());

                this.numberOfTickets = Judgment.divisibleByThousand(amount);
                this.amount = amount;
                break;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void buyLotto(){
        lotto = new List[this.numberOfTickets];

        for(int i=0; i< lotto.length; i++){
            lotto[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Judgment.lottoSort(lotto[i]);
        }
    }

    public void printLotto(){
        System.out.println(numberOfTickets + "개를 구매했습니다.");

        for(List<Integer> Ticket : this.lotto){
            System.out.println(Ticket.toString());
        }
        System.out.println();
    }
}
