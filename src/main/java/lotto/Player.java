package lotto;

import camp.nextstep.edu.missionutils.Console;

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
                this.amount = amount;

                this.numberOfTickets = Judgment.divisibleByThousand(amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000 단위의 숫자를 입력해주세요. ");
            }
        }
    }

    public void buyLotto(){


    }

}
