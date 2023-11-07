package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> numbers = new ArrayList<>();
    private int bonusNumber;

    public void run() {
        Customer customer = setCustomer();
        setGame();
        Result result = new Result();
        Lotto lotto = new Lotto(this.numbers);
        customer.tickets.forEach(ticket -> {
            Comparator comparator = new Comparator(ticket, lotto.getNumbers(), bonusNumber);
            int match = comparator.getMatch();
            boolean bonus = comparator.getBonus();
            result.addToPrizes(match, bonus);
            result.computeTotalProfit(match, bonus);
        });
        List<Long> numbersOfPrizes = result.countPrizes();
        float totalProfit = result.getTotalProfit();
        Print.prizes(numbersOfPrizes);
        Print.profitRate(customer.inputPrice, totalProfit);
    }

    private Customer setCustomer() {
        System.out.println("구입금액을 입력해 주세요.");
        Customer customer = new Customer(inputPrice());
        Print.tickets(customer);
        return customer;
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

    private void setGame() {
        inputLottoNumbers();
        inputBonusNumber();
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
}