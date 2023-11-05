package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static final Integer lottoPrice = 1000;
    private static String errorMessage;

    public static void main(String[] args) {
        String[] inputNumberString,resultString={"3개 일치 (5,000원) - ","4개 일치 (50,000원) - ","5개 일치 (1,500,000원) - ","5개 일치, 보너스 볼 일치 (30,000,000원) - ","6개 일치 (2,000,000,000원) - "};
        Integer[] result={0,0,0,0,0},pride={5000,50000,1500000,30000000,200000000};
        int sum=0;
        System.out.println("구입금액을 입력해 주세요.");
        Integer inputMoney = InputMoney();
        Lotto lottoArray[] = new Lotto[inputMoney / lottoPrice];
        System.out.println("\n" + inputMoney / lottoPrice + "개를 구매했습니다.");
        for (int i = 0; i < inputMoney / lottoPrice; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoArray[i] = new Lotto(numbers);
            Sort(lottoArray[i]);
            System.out.println(lottoArray[i].getNumbers());
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputNumberString = InputNumber();
        Integer[] inputNumber = new Integer[inputNumberString.length];
        for (int i = 0; i < inputNumberString.length; i++) {
            inputNumber[i] = Integer.valueOf(inputNumberString[i]);
        }
        System.out.println("\n보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.valueOf(InputBonusNumber(inputNumber));
        for(int i=0;i<lottoArray.length;i++){
            int n = IsResult(lottoArray[i],inputNumber,bonusNumber);
            if(n==0)continue;
            result[n-1]++;
        }
        System.out.println("\n당첨통계\n---");
        for(int i=0;i<result.length;i++){
            System.out.println(resultString[i]+result[i]+"개");
            sum+=result[i]*pride[i];
        }
        System.out.println("총 수익률은 "+String.format("%.1f", Double.valueOf(sum/Double.valueOf(inputMoney))*100)+"% 입니다.");

    }

    private static int IsResult(Lotto lotto, Integer[] inputNumber, Integer bonusNumber) {
        if(CheckNumber(lotto,inputNumber)==6)return 5;
        if(CheckNumber(lotto,inputNumber)==5&&lotto.getNumbers().contains(bonusNumber))return 4;
        if(CheckNumber(lotto,inputNumber)==5)return 3;
        if(CheckNumber(lotto,inputNumber)==4)return 2;
        if(CheckNumber(lotto,inputNumber)==3)return 1;
        return 0;
    }

    private static int CheckNumber(Lotto lotto, Integer[] inputNumber) {
        int count=0;
        for (int i=0;i<inputNumber.length;i++){
            if(lotto.getNumbers().contains(inputNumber[i]))count++;
        }
        return count;
    }

    private static int InputMoney() {
        Integer inputMoney = Integer.valueOf(Console.readLine());
        Integer money;
        try {
            if (inputMoney % lottoPrice != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 단위는 1,000원 단위여야 합니다.");
            }
            money = inputMoney;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            money = InputMoney();
        }
        return money;
    }

    private static void Sort(Lotto lotto) {
        for (int i = 0; i < 5; i++) {
            Sorting(lotto, i);
        }
    }

    private static void Sorting(Lotto lotto, int index) {
        Integer minIndex = index;
        for (int i = index + 1; i < 6; i++) {
            if (lotto.getNumberIndex(minIndex) > lotto.getNumberIndex(i)) {
                minIndex = i;
            }
        }
        Integer tmp = lotto.getNumberIndex(minIndex);
        lotto.setNumberIndex(minIndex, lotto.getNumberIndex(index));
        lotto.setNumberIndex(index, tmp);
    }

    private static String[] InputNumber() {
        String[] inputNumberString = Console.readLine().split(",");
        try {
            if (IsValid(inputNumberString)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputNumberString = InputNumber();
        }
        return inputNumberString;
    }

    private static boolean IsValid(String[] input) {
        if (CheckLength(input)) {
            return true;
        }
        if (IsNumber(input)) {
            return true;
        }
        for (int i = 0; i < input.length - 1; i++) {
            if (IsUnique(input, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckLength(String[] input) {
        if (input.length < 6) {
            errorMessage = "[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.";
            return true;
        }
        return false;
    }

    private static boolean IsNumber(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (Integer.valueOf(input[i]) < 1 || Integer.valueOf(input[i]) > 45) {
                errorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
                return true;
            }
        }
        return false;
    }

    private static boolean IsUnique(String[] input, int i) {
        for (int j = i + 1; j < input.length; j++) {
            if (Integer.valueOf(input[i]) == Integer.valueOf(input[j])) {
                errorMessage = "[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다.";
                return true;
            }
        }
        return false;
    }

    private static String InputBonusNumber(Integer[] inputNumber) {
        String bonusNumber = Console.readLine();
        try {
            if (IsNumber(bonusNumber)) {
                throw new IllegalArgumentException(errorMessage);
            }
            if (IsUnique(inputNumber, bonusNumber)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bonusNumber = InputBonusNumber(inputNumber);
        }
        return bonusNumber;
    }

    private static boolean IsUnique(Integer[] inputNumber, String bonusNumber) {
        for (int i = 0; i < inputNumber.length; i++) {
            if (inputNumber[i] == Integer.valueOf(bonusNumber)) {
                errorMessage = "[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 숫자여야 합니다.";
                return true;
            }
        }
        return false;
    }

    private static boolean IsNumber(String bonusNumber) {
        if (Integer.valueOf(bonusNumber) < 1 || Integer.valueOf(bonusNumber) > 45) {
            errorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
            return true;
        }
        return false;
    }
}