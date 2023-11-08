package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        price = getPurchasePrice();
        amount = price / 1000;
        getLottoes(amount);
        getSelectedNumbers();
        getBonusNumber();
        results = new HashMap<>();
        getResults();
    }

    private static void getResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        getCount();
        System.out.println("3개 일치 (5,000원) - " + results.get(RESULT.THREE_STRIKE) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(RESULT.FOUR_STRIKE) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(RESULT.FIVE_STRIKE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(RESULT.FIVE_STRIKE_AND_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(RESULT.SIX_STRIKE) + "개");
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
            } catch (Exception e){
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
            } catch (Exception e){
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
        while (true){
            try {
                String input = Console.readLine();
                int price = Integer.parseInt(input);
                isValidPrice(price);
                break;
            } catch (Exception e){
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
            }
        }
        return price;
    }

    public static void isValidPrice(int price) {
        if (isPriceDividedByThousand(price)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isPriceDividedByThousand(int price) {
        return price % 1000 != 0;
    }
}
