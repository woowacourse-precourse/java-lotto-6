package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Integer> numbers = new ArrayList<>();
    public boolean bonus;
    public int match;
    private int bonusNumber;
    public int inputPrice;
    public float totalProfit = 0;
    public List<String> prizes = new ArrayList<>();
    public List<Long> numbersOfPrizes = new ArrayList<>();

    public void setInputPrice() {
        this.inputPrice = inputPrice();
    }

    private int inputPrice() {
        int inputPrice;
        while (true) {
            try {
                String input = Console.readLine();
                inputPrice = Integer.parseInt(input);;
                break;
            } catch (NumberFormatException e) {
                System.out.print("[ERROR] 금액은 숫자여야 합니다.");
            }
        }
        return inputPrice;
    }

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
        this.match = compareLotto(user, lotto);
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
    public void setPrizes(int match, boolean bonus) {
        for (Prize prize : Prize.values()) {
            if (match == prize.getMatch() && ((bonus == prize.getBonus()) || prize.getBonus())) {
                this.prizes.add(prize.getName());
            }
        }
    }

    public long countFirstPrize(List<String> prizes) {
        long count = prizes.stream()
                .filter(name -> name.equals("FIRST"))
                .count();
        return count;
    }

    public long countSecondPrize(List<String> prizes) {
        long count = prizes.stream()
                .filter(name -> name.equals("SECOND"))
                .count();
        return count;
    }

    public long countThirdPrize(List<String> prizes) {
        long count = prizes.stream()
                .filter(name -> name.equals("THIRD"))
                .count();
        return count;
    }

    public long countFourthPrize(List<String> prizes) {
        long count = prizes.stream()
                .filter(name -> name.equals("FOURTH"))
                .count();
        return count;
    }

    public long countFifthPrize(List<String> prizes) {
        long count = prizes.stream()
                .filter(name -> name.equals("FIFTH"))
                .count();
        return count;
    }

    public List<Long> countPrizes() {
        List<Long> numbersOfPrizes = new ArrayList<>();
        numbersOfPrizes.add(countFirstPrize(this.prizes));
        numbersOfPrizes.add(countSecondPrize(this.prizes));
        numbersOfPrizes.add(countThirdPrize(this.prizes));
        numbersOfPrizes.add(countFourthPrize(this.prizes));
        numbersOfPrizes.add(countFifthPrize(this.prizes));
        return numbersOfPrizes;
    }

    public float computeTotalProfit(int match, boolean bonus) {
        float totalProfit = 0;
        for (Prize prize : Prize.values()) {
            if (match == prize.getMatch() && ((bonus == prize.getBonus()) || prize.getBonus())) {
                totalProfit += prize.getProfit();
            }
        }
        return totalProfit;
    }

    public void setGame() {
        inputLottoNumbers();
        inputBonusNumber();
    }

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        setInputPrice();
        Ticket ticket = new Ticket(this.inputPrice);
        System.out.printf("\n%d개를 구매했습니다.\n", ticket.amount);
        printTickets(ticket);
        setGame();
        for (int i = 0; i < ticket.amount; i++) {
            Lotto lotto = new Lotto(this.numbers);
            compareNumbers(ticket.tickets.get(i), lotto.getNumbers());
            setPrizes(this.match, this.bonus);
        }
        this.numbersOfPrizes = countPrizes();
        this.totalProfit = computeTotalProfit(this.match, this.bonus);

        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", this.numbersOfPrizes.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", this.numbersOfPrizes.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", this.numbersOfPrizes.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", this.numbersOfPrizes.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", this.numbersOfPrizes.get(0));
        float profitRate = this.totalProfit / ticket.price * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private static void printTickets(Ticket ticket) {
        for (int i = 0; i < ticket.amount; i++) {
            System.out.println(ticket.tickets.get(i));
        }
    }
}