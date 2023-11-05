package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int price = 1000;
    static int amountOfMoney, bonusNumber;
    static List<String> winningNums = new ArrayList<>();

    public static void inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            validateAmount(amount);
            amountOfMoney = amount;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            inputLottoAmount();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            inputLottoAmount();
        }
    }

    public static void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try{
            int bonus = Integer.parseInt(Console.readLine());
            validateNumber(bonus);
            bonusNumber = bonus;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            inputBonusNumber();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            inputBonusNumber();
        }
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winningNums = (Arrays.asList(Console.readLine().split(",")));
        try {
            isAllValidNumbers(winningNums);
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            inputWinningNumbers();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            inputWinningNumbers();
        }
        return new Lotto(convertStringToInt(winningNums));
    }

    public static void isAllValidNumbers (List<String> original) {
        for (String previous: original){
            int num = Integer.parseInt(previous);
            validateNumber(num);
        }
    }

    public static List<Integer> convertStringToInt (List<String> original) {
        List<Integer> convert = new ArrayList<>();
        for (String previous: original){
            int num = Integer.parseInt(previous);
            convert.add(num);
        }
        return convert;
    }

    public static void validateNumber(int num){
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static List<Lotto> generateLottos(int quantity){
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++){
            allLotto.add(new Lotto(createRandomNumbers()));
        }
        return allLotto;
    }

    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public static void printLottos(List<Lotto> allLotto, int quantity) {
        System.out.printf("\n%d개를 구매했습니다.\n", quantity);
        for (Lotto lotto: allLotto){
            lotto.printNumbers();
        }
    }

    public static List<Integer> getResult(List<Lotto> allLotto, Lotto winningLotto, int bonus) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto: allLotto) {
            result.add(lotto.countMatchingNumbers(winningLotto, bonus));
        }
        return result;
    }

    public static void printStatistic(List<Integer> result, int amount) {
        System.out.println("\n당첨 통계\n---");
        List<Integer> rankNumber = countRank(result);
        System.out.printf("3개 일치 (5,000원) - %d개\n", rankNumber.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", rankNumber.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rankNumber.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankNumber.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rankNumber.get(0));

        printRateOfReturn(rankNumber, amount);
    }

    public static List<Integer> countRank(List<Integer> result) {
        List<Integer> rankNumber = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            rankNumber.add(Collections.frequency(result, i));
        }
        return rankNumber;
    }

    public static void printRateOfReturn(List<Integer> rankNumber, int amount) {
        double rateOfReturn = calcRateOfReturn(rankNumber, amount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    public static double calcRateOfReturn(List<Integer> rankNumber, int amount) {
        List<Integer> allPrize = Statistic.getPrize();
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += allPrize.get(i) * rankNumber.get(i);
        }
        return (double)total/(double)amount*100.0;
    }

    public static void main(String[] args) {
        inputLottoAmount();

        List<Lotto> allLotto = generateLottos(amountOfMoney/price);
        printLottos(allLotto, amountOfMoney/price);

        Lotto winningLotto = inputWinningNumbers();
        inputBonusNumber();

        List<Integer> result = getResult(allLotto, winningLotto, bonusNumber);
        printStatistic(result, amountOfMoney);
    }
}
