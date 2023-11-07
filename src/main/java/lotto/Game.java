package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> numbers = new ArrayList<>();
    private boolean bonus;
    private int match;
    private int bonusNumber;
    private int inputPrice;
    private float totalProfit = 0;
    private List<Long> numbersOfPrizes = new ArrayList<>();
    private Customer customer;

    private void setInputPrice() {
        this.inputPrice = inputPrice();
    }

    private int inputPrice() {
        int inputPrice;
        while (true) {
            try {
                String input = Console.readLine();
                inputPrice = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.print("[ERROR] 금액은 숫자여야 합니다.");
            }
        }
        return inputPrice;
    }

    private void inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputNumbers;
        inputNumbers = Console.readLine().split(",");
        for (String number : inputNumbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    private void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    private final List<String> prizes = new ArrayList<>();

    private void setPrizes(int match, boolean bonus) {
        for (Prize prize : Prize.values()) {
            if (match == prize.getMatch() && ((bonus == prize.getBonus()) || prize.getBonus())) {
                this.prizes.add(prize.getName());
            }
        }
    }

    private long countFirstPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("FIRST"))
                .count();
    }

    private long countSecondPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("SECOND"))
                .count();
    }

    private long countThirdPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("THIRD"))
                .count();
    }

    public long countFourthPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("FOURTH"))
                .count();
    }

    private long countFifthPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("FIFTH"))
                .count();
    }

    private List<Long> countPrizes() {
        List<Long> numbersOfPrizes = new ArrayList<>();
        numbersOfPrizes.add(countFirstPrize(prizes));
        numbersOfPrizes.add(countSecondPrize(prizes));
        numbersOfPrizes.add(countThirdPrize(prizes));
        numbersOfPrizes.add(countFourthPrize(prizes));
        numbersOfPrizes.add(countFifthPrize(prizes));
        return numbersOfPrizes;
    }

    private float computeTotalProfit(int match, boolean bonus) {
        float totalProfit = 0;
        for (Prize prize : Prize.values()) {
            if (match == prize.getMatch() && ((bonus == prize.getBonus()) || prize.getBonus())) {
                totalProfit += prize.getProfit();
            }
        }
        return totalProfit;
    }

    private void setGame() {
        inputLottoNumbers();
        inputBonusNumber();
    }

    public void run() {
        setCustomer();
        setGame();
        for (int i = 0; i < customer.amount; i++) {
            Lotto lotto = new Lotto(this.numbers);
            Comparator comparator = new Comparator(customer.tickets.get(i), lotto.getNumbers(),bonusNumber);
            match = comparator.getMatch();
            bonus = comparator.getBonus();
            setPrizes(match, bonus);
        }
        numbersOfPrizes = countPrizes();
        totalProfit = computeTotalProfit(match, bonus);

        printOutput(customer);
    }

    private void setCustomer() {
        System.out.println("구입금액을 입력해 주세요.");
        setInputPrice();
        customer = new Customer(inputPrice);
        printTickets(customer);
    }

    private void printOutput(Customer customer) {
        System.out.println("당첨 통계\n---");
        printPrizes();
        printProfitRate(customer);
    }

    private void printPrizes() {
        System.out.printf("3개 일치 (5,000원) - %d개\n", numbersOfPrizes.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", numbersOfPrizes.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", numbersOfPrizes.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", numbersOfPrizes.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", numbersOfPrizes.get(0));
    }

    private void printProfitRate(Customer customer) {
        float profitRate = totalProfit / customer.inputPrice * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private void printTickets(Customer customer) {
        System.out.printf("\n%d개를 구매했습니다.\n", customer.amount);
        for (int i = 0; i < customer.amount; i++) {
            System.out.println(customer.tickets.get(i));
        }
    }
}