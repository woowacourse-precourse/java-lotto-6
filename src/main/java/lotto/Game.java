package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final String ERROR = "[ERROR]";
    public static final int MAX_OF_RANGE = 45;
    public static final int MIN_OF_RANGE = 1;
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNumber;


    public void run() {
        Customer customer = setCustomer();
        Result result = new Result();
        Lotto lotto = setLotto();

        setBonusNumber();
        customer.tickets.forEach(ticket -> {
            Comparator comparator = new Comparator(ticket, lotto.getNumbers(), bonusNumber);
            int match = comparator.getMatch();
            boolean isBonus = comparator.getIsBonus();
            result.addToPrizes(match, isBonus);
            result.computeTotalProfit(match, isBonus);
        });
        List<Long> numbersOfPrizes = result.countPrizes();
        float totalProfit = result.getTotalProfit();
        Print.prizes(numbersOfPrizes);
        Print.profitRate(customer.price, totalProfit);
    }

    private Customer setCustomer() {
        Customer customer;
        while (true) {
            try {
                String price = inputPrice();
                customer = new Customer(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR + "숫자 형식으로 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + "최소 1000원 이상의 금액을 1000원 단위로 입력해주세요.");
            }

        }
        Print.tickets(customer);
        return customer;
    }

    private Lotto setLotto() {
        while (true) {
            try {
                setLottoNumbers();
                return new Lotto(this.numbers);
            } catch (NumberFormatException e) {
                System.out.println(ERROR + "숫자 형식으로 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + "1~45 사이의 중복되지 않는 숫자 6개를 입력해주세요.");
            }
        }
    }

    private int setPrice() {
        int inputPrice;
        while (true) {
            try {
                String input = inputPrice();
                inputPrice = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR + "숫자 형식으로 입력해주세요.");
            }
        }
        return inputPrice;
    }

    private static String inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private void setLottoNumbers() {
        String inputNumbers = inputLottoNumbers();
        validateLottoNumbers(inputNumbers);
        this.numbers = Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateLottoNumbers(String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (inputNumbers.charAt(inputNumbers.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    private static String inputLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private void setBonusNumber() {
        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                validateBonusNumber(bonusNumber);
                this.bonusNumber = bonusNumber;
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR + "숫자 형식으로 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + "당첨 번호와 중복되지 않는 1~45 사이의 숫자 1개를 입력해주세요.");
            }
        }
    }

    private static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        if (inputBonusNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputBonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber) || (bonusNumber < MIN_OF_RANGE || bonusNumber > MAX_OF_RANGE)) {
            throw new IllegalArgumentException();
        }
    }
}