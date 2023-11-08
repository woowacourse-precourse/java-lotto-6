package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Lotto {
    List<Integer> numbers = new ArrayList<>();
    List<List<Integer>> storedNumber = new ArrayList<>();
    int chance;
    int bonusNum;
    int[] counts = new int[8];
    float rateOfReturn;

    public void run() {
        moneyInput();
        numberInput();
        bonusInput();
        compareLotto();
        calculateRateofReturn();
        printResult();
        //Lotto lotto = new Lotto(numbers);
    }

    private void bonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        while (checkValidate(bonusNum) || checkNumInRange(bonusNum) || bonusDuplicate(bonusNum)) {
            bonusNum = Console.readLine();
        }
        this.bonusNum = Integer.parseInt(bonusNum);
    }

    private Boolean bonusDuplicate(String num){
        if(numbers.contains(Integer.parseInt((num)))){
            System.out.println("[ERROR] 당첨번호와 중복됩니다. 다시 입력해주세요");
            return true;
        }
        return false;
    }

    private void numberInput(/*String testnum*/) {
        boolean check = false;
        System.out.println("당첨 번호를 입력해 주세요.");
        String num = Console.readLine();
        while (checkNumberUnder7AndNonDuplicate(num)) {
            num = Console.readLine();
        }
    }

    private void moneyInput(/*int testNum*/) {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        while (checkValidate(money) || check1000(money)) {
            money = Console.readLine();
        }
        int checkedmoney = Integer.parseInt(money);
        this.chance = checkedmoney / 1000;

        System.out.printf("%d개를 구매했습니다.\n", chance);
        generateLotto(chance);
    }

    private Boolean checkNumberUnder7AndNonDuplicate(String num) {
        List<Integer> checkNubmer = new ArrayList<>();
        for (String i : num.split(",")) {
            if (checkValidate(i)) return true;
            if (checkNumInRange(i)) return true;
            checkNubmer.add(Integer.parseInt(i));
        }
        if (checkNumberSize(checkNubmer)) return true;
        if (checkDuplicate(checkNubmer)) return true;
        numbers = checkNubmer;
        return false;
    }

    private Boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : numbers) {
            if (!set.add(i)) {
                System.out.println("[ERROR] 중복 번호가 있습니다. 다시 입력해주세요");
                return true;
            }
        }
        return false;
    }

    private Boolean checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리여야 합니다. 다시 입력해주세요");
            return true;
        }
        return false;
    }

    private Boolean check1000(String num) {
        if (Integer.parseInt(num) % 1000 != 0) {
            System.out.println("[ERROR] 급액은 1000단위여야 합니다. 다시 입력해주세요.");
            return true;
        }
        return false;
    }

    private Boolean checkValidate(String num) {
        try {
            int number = Integer.parseInt(num);
            if(number<0){
                System.out.println("[ERROR] 양수를 입력해주세요.");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 또는 보너스 번호는 숫자여야 합니다. 다시 입력해주세요");
            return true;
        }
        return false;
    }

    private Boolean checkNumInRange(String num) {
        int number = Integer.parseInt(num);
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 로또 또는 보너스 번호는 1과 45 사이여야 합니다.다시 입력해주세요");
            return true;
        }
        return false;
    }

    private void generateLotto(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> generatenumberss = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> generatenumbers = new ArrayList<>(generatenumberss);
            generatenumbers.sort(null);
            storedNumber.add(generatenumbers);
            numbersPrint(generatenumbers);
        }
    }

    private void compareLotto() {
        for (List<Integer> compareNumber : storedNumber) {
            checkcompare(compareNumber);
        }
    }

    private void checkcompare(List<Integer>compareNumber){
        int sameNumber = 0;
        for (int i : compareNumber) {
            if (numbers.contains(i)) {
                sameNumber++;
            }
        }
        if (sameNumber == 5 && compareNumber.contains(bonusNum)) {
            counts[7]++;
            return;
        }
        counts[sameNumber]++;
    }

    private void numbersPrint(List<Integer> generateNumbers) {
        System.out.print("[");
        for (int i = 0; i < generateNumbers.size(); i++) {
            int userNumber = generateNumbers.get(i);
            System.out.print(userNumber);
            if (i < generateNumbers.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", counts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", counts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", counts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", counts[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", counts[6]);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    private void calculateRateofReturn() {
        rateOfReturn = (float) (Value.FIRST_WINNING_PRICE.value * counts[6] +
                Value.THIRD_WINNING_PRICE.value * counts[5] +
                Value.FOURTH_WINNING_PRICE.value * counts[4] +
                Value.FIFTH_WINNING_PRICE.value * counts[3] +
                Value.SECOND_WINNING_PRICE.value * counts[7]) / (chance * 10);
    }

    public enum Value {
        FIRST_WINNING_PRICE(2000000000),
        SECOND_WINNING_PRICE(30000000),
        THIRD_WINNING_PRICE(1500000),
        FOURTH_WINNING_PRICE(50000),
        FIFTH_WINNING_PRICE(5000);

        final private Integer value;

        Value(Integer value){
            this.value = value;
        }
    }
}
