package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNumber;

    public void run() {
        Customer customer = setCustomer();
        Result result = new Result();
        Lotto lotto = setLotto();

        inputBonusNumber();
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
        Customer customer;
        while (true) {
            try {
                customer = new Customer(inputPrice());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 최소 1000원 이상의 금액을 1000원 단위로 입력해주세요.");
            }

        }
        Print.tickets(customer);
        return customer;
    }

    private Lotto setLotto() {
        while (true) {
            try {
                inputLottoNumbers();
                return new Lotto(this.numbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식으로 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45 사이의 중복되지 않는 숫자 6개를 입력해주세요.");
            }
        }
    }

    private int inputPrice() {
        int inputPrice;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                inputPrice = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식으로 입력해주세요.");
            }
        }
        return inputPrice;
    }

    private void inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();
        this.numbers = Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                if (numbers.contains(bonusNumber) || (bonusNumber < 1 || bonusNumber > 45)) {
                    throw new IllegalArgumentException();
                }
                this.bonusNumber = bonusNumber;
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식으로 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호와 중복되지 않는 1~45 사이의 숫자 1개를 입력해주세요.");
            }
        }
    }
}