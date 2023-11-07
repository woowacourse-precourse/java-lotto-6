package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public String inputPrice;
    public float totalProfit = 0;
    public int firstPrize = 0;
    public int secondPrize = 0;
    public int thirdPrize = 0;
    public int fourthPrize = 0;
    public int fifthPrize = 0;

    public void setInputPrice() {
        while (true) {
            try {
                String input = Console.readLine();
                Integer.parseInt(input);
                this.inputPrice = input;
                break;
            } catch (NumberFormatException e) {
                System.out.print("[ERROR]");
            }
        }
    }

    public void countPrize(int prize) {
        if (prize == 1) {
            firstPrize++;
        }
        if (prize == 2) {
            secondPrize++;
        }
        if (prize == 3) {
            thirdPrize++;
        }
        if (prize == 4) {
            fourthPrize++;
        }
        if (prize == 5) {
            fifthPrize++;
        }
    }
    public List<Integer> numbers = new ArrayList<>();
    ;
    public boolean bonus;
    public int rank;
    public int result;
    public int profit;
    public static final int FIRST_PROFIT = 2000000000;
    public static final int SECOND_PROFIT = 30000000;
    public static final int THIRD_PROFIT = 1500000;
    public static final int FOURTH_PROFIT = 50000;
    public static final int FIFTH_PROFIT = 5000;
    private int bonusNumber;

    public void inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputNumbers;
        inputNumbers = Console.readLine().split(",");
        for (String number : inputNumbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public void compareNumbers(List<Integer> user, List<Integer> lotto) {
        this.rank = compareLotto(user, lotto);
        this.bonus = compareBonus(user, this.bonusNumber);
    }

    public int compareLotto(List<Integer> user, List<Integer> lotto) {
        int match = 0;
        for (Integer userNumber : user) {
            if (lotto.contains(userNumber)) {
                match++;
            }
        }
        return match;
    }

    public boolean compareBonus(List<Integer> user, int bonus) {
        return user.contains(bonus);
    }

    public void computeResult(int rank) {
        this.result = 0;
        this.profit = 0;
        if (rank == 6) {
            this.result = 1;
            this.profit = FIRST_PROFIT;
        }
        if (rank == 5 && this.bonus) {
            this.result = 2;
            this.profit = SECOND_PROFIT;
        }
        if (rank == 5) {
            this.result = 3;
            this.profit = THIRD_PROFIT;
        }
        if (rank == 4) {
            this.result = 4;
            this.profit = FOURTH_PROFIT;
        }
        if (rank == 3) {
            this.result = 5;
            this.profit = FIFTH_PROFIT;
        }
    }

    public void setGame() {
        inputLottoNumbers();
        inputBonusNumber();
    }

    public void singleRun(List<Integer> user) {
        Lotto lotto = new Lotto(this.numbers);
        compareNumbers(user, lotto.getNumbers());
        computeResult(this.rank);
    }

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        setInputPrice();
        Ticket ticket = new Ticket(this.inputPrice);
        System.out.printf("\n%d개를 구매했습니다.\n", ticket.AMOUNT);
        for (int i = 0; i < ticket.AMOUNT; i++) {
            System.out.println(ticket.tickets.get(i));
        }
        setGame();
        for (int i = 0; i < ticket.AMOUNT; i++) {
            singleRun(ticket.tickets.get(i));
            countPrize(this.result);
            totalProfit += this.profit;
        }
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", this.fifthPrize);
        System.out.printf("4개 일치 (50,000원) - %d개\n", this.fourthPrize);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", this.thirdPrize);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", this.secondPrize);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", this.firstPrize);
        float profitRate = totalProfit / Integer.parseInt(ticket.price) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
