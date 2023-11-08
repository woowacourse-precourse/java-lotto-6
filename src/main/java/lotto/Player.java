package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;


public class Player{
    private Judgment judge;
    private int amount;
    private int numberOfTickets;
    private int[] winningCount = new int[8];
    private int totalProfit = 0;
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

    public void checkNumbers(){
        for(List<Integer> Ticket : this.lotto){
                rankLotto(Ticket);
        }
    }

    public void rankLotto(List<Integer> Ticket){
        int count = 0;
        for(int number : Ticket){
            count = CompareWinningNumber(count, number);
        }

        if(count >= 5){
            count = CompareBonusNumber(count, Ticket);
        }
        winningCount[count] += 1;

    }

    public int CompareWinningNumber(int count, int number){
        if(judge.getLotto().isIncludes(number)){
            return count + 1;
        }
        return count;
    }

    public int CompareBonusNumber(int count, List<Integer> Ticket){

        if(Ticket.contains(judge.getBonus()) || count == 6) { // 보너스 번호를 포함하거나 로또 번호가 1등 인 경우
            count += 1;                                     // count를 증가하여 로또 번호 2등과 구분
        }
        return count;
    }

    public void printWonLotto(){
        String[] str = {"","", "", "THREE", "FOUR", "FIVE","FIVEBONUS", "SIX"};
        LotteryMatchNumber Match;
        int count = 0;

        System.out.println("\n당첨 통계\n" + "---");

        for(int i=3; i < winningCount.length; i++){
            Match = LotteryMatchNumber.valueOf(str[i]);
            addProfit(winningCount[i], Match);

            System.out.println(Match.getLabel() + " - " + winningCount[i] + "개");
        }
    }
    public void addProfit(int winningCount, LotteryMatchNumber Match){
        if(winningCount > 0) {
            totalProfit += Match.getProfits() * winningCount;
        }

    }

    public void playGame(){
        inputAmount();
        buyLotto();
        printLotto();

        judge = new Judgment();
        judge.userInput();

        checkNumbers();
        printWonLotto();

    }
}
