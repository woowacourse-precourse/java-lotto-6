package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Lotto {

    private static final int FIRST_WINNING_PRICE = 2000000000;
    private static final int SECOND_WINNING_PRICE = 30000000;
    private static final int THIRD_WINNING_PRICE = 1500000;
    private static final int FOURTH_WINNING_PRICE = 50000;
    private static final int FIFTH_WINNING_PRICE = 5000;
    List<Integer> numbers = new ArrayList<>();
    List<List<Integer>> storedNumber = new ArrayList<>();
    int chance;
    int bonusNum;
    int[] counts = new int[8];
    float rateOfReturn;

    public void run (){
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
        bonusNum = Integer.parseInt(Console.readLine());
        try {
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public void moneyInput(/*int testNum*/){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        try {
            if(money%1000 != 0){
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해 주세요");
            }
            this.chance = money/1000;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        System.out.printf("%d개를 구매했습니다.\n", chance);
        generateLotto(chance);
    }

    public void numberInput(/*String testnum*/){
        System.out.println("당첨 번호를 입력해 주세요.");
        //String num = testnum;
        String num = Console.readLine();
        for (String i : num.split(",")) {
            try {
                int number = Integer.parseInt(i);
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                    throw new NumberFormatException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
        validate();
    }

    public void validate(/*List<Integer> testNumbers*/){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for( int number : numbers){
            if(!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void generateLotto(int count) {
        for(int i=0; i< count;i++) {
            List<Integer> generatenumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            generatenumbers.sort(null);
            storedNumber.add(generatenumbers);
            numbersPrint(generatenumbers);
        }
    }

    public void compareLotto(){
        for(List<Integer> compareNumber : storedNumber){
            int sameNumber =0;
            for(int i:compareNumber){
                if (numbers.contains(i)){
                    sameNumber++;
                }
            }
            if(sameNumber==5 && compareNumber.contains(bonusNum)){
                counts[7]++;
                return;
            }
            counts[sameNumber]++;
        }
    }

    public void numbersPrint(List<Integer> generateNumbers){
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
                /*if (numbers.contains(userNumber)) {
                sameNumber++;
            }*/

    /*if(sameNumber==5 && generateNumbers.contains(bonusNum)){
            counts[7]++;
            return;
        }
        counts[sameNumber]++;*/

    public void printResult(){
        System.out.printf("3개 일치 (5,000원) - %d개\n",counts[3]);
        System.out.printf("4개 일치 (5,0000원) - %d개\n",counts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",counts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",counts[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",counts[6]);
        System.out.printf("총 수익률은 %.2f", rateOfReturn);
    }

    public void calculateRateofReturn(){
        rateOfReturn = (float) (FIRST_WINNING_PRICE * counts[6] + THIRD_WINNING_PRICE * counts[5] +
                FOURTH_WINNING_PRICE * counts[4] + FIFTH_WINNING_PRICE * counts[3] + SECOND_WINNING_PRICE * counts[7]) / chance;
    }
}
