package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    private static List<Lotto> lottoes;
    private static List<Integer> selectedNumbers;
    private static Map<RESULT, Integer> results;
    private static int price;
    private static int amount;
    private static int profit;
    private static int bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoes = new ArrayList<>();
        selectedNumbers = new ArrayList<>();
        price = getPurchasePrice();
        amount = price / 1000;
        getLottoes(amount);
        getSelectedNumbers();
        getBonusNumber();
        results = new HashMap<>();
        getResults();
        printProfit();
    }

    private static void printProfit() {
        getProfit();
        int netProfit = profit - price;
        double profitRatio = (double) profit / (double) price;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRatio * 100) + "%입니다.");
    }

    private static void getProfit() {
        for (RESULT result : results.keySet()){
            profit += results.get(result) * result.getProfit();
        }
    }

    private static void getResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        getCount();
        System.out.println("3개 일치 (5,000원) - " + results.getOrDefault(RESULT.THREE_STRIKE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.getOrDefault(RESULT.FOUR_STRIKE, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.getOrDefault(RESULT.FIVE_STRIKE, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.getOrDefault(RESULT.FIVE_STRIKE_AND_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.getOrDefault(RESULT.SIX_STRIKE, 0) + "개");
    }

    private static void getCount() {
        lottoes.stream().forEach(lotto -> {
                RESULT result = lotto.countResult(selectedNumbers, bonusNumber);
                results.put(result, results.getOrDefault(result, 0) + 1);
                });
    }

    public static void getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                bonusNumber = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            }
        }
    }

    public static void getSelectedNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = getNumbersFromInput();
        selectedNumbers = numbers;
    }

    private static List<Integer> getNumbersFromInput() {
        List<Integer> numbers;
        while(true){
            try {
                String input = Console.readLine();
                numbers = Arrays.stream(input.split(",")).map(number -> Integer.parseInt(number))
                        .collect(Collectors.toList());
                validateNumbers(numbers);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 6개의 번호를 입력해주세요.");
            }
        }
        return numbers;
    }

    public static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void makeNewSelectedNumbers(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.");
        }
        selectedNumbers = numbers;
    }

    public static void getLottoes(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++) {
            Lotto lotto = Lotto.makeLottoWithRandomNumbers();
            lottoes.add(lotto);
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static int getPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price;
        while (true){
            try {
                String input = Console.readLine();
                price = Integer.parseInt(input);
                isValidPrice(price);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
            }
        }
        return price;
    }

    public static void isValidPrice(int price) {
        if (isPriceDividedByThousand(price)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public static boolean isPriceDividedByThousand(int price) {
        return price % 1000 != 0;
    }
}
