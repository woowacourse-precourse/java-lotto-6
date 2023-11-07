package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Error{
    ERROR("[ERROR] 올바른 입력을 하세요");

    private final String error;

    Error(String error){
        this.error = error;
    }

    public String getError(){
        return error;
    }
}

class money_for_lotto{
    public static int realNumber;

    public static int realMoney(String inputNumber){
        moneyIsNumber(inputNumber);
        realNumber = Integer.parseInt(inputNumber);
        moneyIsOver0(realNumber);
        multipleOfThousand(realNumber);
        return Integer.parseInt(inputNumber);
    }

    public static void moneyIsNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
    }

    public static void moneyIsOver0(int realNumber){
        if(realNumber<1){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
    }
    public static void multipleOfThousand(int realNumber){
        if(realNumber%1000 != 0){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
    }

    public static int repeatTime(int realNumber){
        return realNumber/1000;
    }

    public static int exceptionRepeatMoney(){
        int result = 0;
        while (result == 0) {
            result = readLine(result);
        }
        return result;
    }

    public static int readLine(int result) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputMoney = Console.readLine();
            result = money_for_lotto.realMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(Error.ERROR.getError());
        }
        return result;
    }
}

class random_lotto{
    static final List<List<Integer>> totalLotto = new ArrayList<>();

    public static List<List<Integer>> print_lotto(int repeatTime){
        save_lotto(repeatTime);
        for(int i = 0; i<repeatTime; i++){
            System.out.println(totalLotto.get(i));
        }
        return totalLotto;
    }

    public static void save_lotto(int repeatTime){
        for(int i = 0; i<repeatTime; i++){
            totalLotto.add(pick_lotto());
        }
    }
    public static List<Integer> pick_lotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}

class winning_number{

    public static List<Integer> splitInput(String input){
        String[] winningNumbers = input.split(",");
        return changeAllAsInt(winningNumbers);
    }

    public static List<Integer> changeAllAsInt(String[] numbers){
        List<Integer> splitedWinNumber = new ArrayList<>();
        for (String number : numbers) {
            checkIntOrNot(number);
            splitedWinNumber.add(changeAsInt(number));
        }
        Lotto lotto = new Lotto(splitedWinNumber);
        return splitedWinNumber;
    }

    public static void checkIntOrNot(String number){
        try{
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
    }

    public static int changeAsInt(String strNumber){
        return Integer.parseInt(strNumber);
    }

    public static List<Integer> exceptionRepeatWinNumber(){
        List<Integer> repeatOrNot = new ArrayList<>();
        while(repeatOrNot.isEmpty()){
            repeatOrNot = readLine(repeatOrNot);
        }
        return repeatOrNot;
    }

    public static List<Integer> readLine(List<Integer> repeat){
        try{
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningNumber = Console.readLine();
            repeat = winning_number.splitInput(winningNumber);
        }catch (IllegalArgumentException e) {
            System.out.println(Error.ERROR.getError());
        }
        return repeat;
    }
}

class bonus_number{
    public static int checkBonus(List<Integer> winNumbers, String bonus){
        int bonusNumber = intgerBonus(bonus);
        checkBonusRange(bonusNumber);
        circulationForCheck(winNumbers, bonusNumber);
        return bonusNumber;
    }

    public static int intgerBonus(String bonus){
        try {
            Integer.parseInt(bonus);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
        return Integer.parseInt(bonus);
    }

    public static void checkBonusRange(int number){
        if(number<1||number>45){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
    }

    public static void circulationForCheck(List<Integer> criterias, int number){
        for(int criteria : criterias){
            checkDuplication(criteria, number);
        }
    }

    public static void checkDuplication(int criteria, int number){
        if(criteria == number){
            throw new IllegalArgumentException(Error.ERROR.getError());
        }
    }

    public static int exceptionRepeatBonus(List<Integer> winningNumber){
        int bonusNumber = 0;
        while(bonusNumber == 0){
            bonusNumber = readLine(winningNumber);
        }
        return bonusNumber;
    }

    public static int readLine(List<Integer> winningNumber){
        int IntegeredBbonus = 0;
        try{
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();
            IntegeredBbonus = bonus_number.checkBonus(winningNumber, bonusNumber);
        }catch (IllegalArgumentException e) {
            System.out.println(Error.ERROR.getError());
        }
        return IntegeredBbonus;
    }
}

class lotto_result{
    private static final int SECOND_PRIZE = 7;

    public static List<Integer> totalLottoCheck(List<List<Integer>> total, List<Integer> numbers, int bonus){
        List<Integer> result = new ArrayList<>();
        for(List<Integer> lotto : total){
            int correction = eachLottoCheck(lotto, numbers, bonus);
            result.add(correction);
        }
        printResult(result);
        return result;
    }

    public static int eachLottoCheck(List<Integer> lotto, List<Integer> numbers, int bonus){
        int totalCorrectionEach = 0;
        for(int number : numbers){
            totalCorrectionEach += checkCorrection(number, lotto);
        }
        if(totalCorrectionEach == 5){
            totalCorrectionEach = checkBonus(lotto, bonus);
        }
        return totalCorrectionEach;
    }

    public static int checkCorrection(int number, List<Integer> lotto){
        int correct = 0;
        for(int lottoNumber : lotto){
            if(lottoNumber == number){
                correct++;
            }
        }
        return correct;
    }

    public static int checkBonus(List<Integer> lotto, int bonus){
        int totalCorrectionEach = 5;
        for(int eachNumber : lotto){
            if (bonus == eachNumber) {
                totalCorrectionEach = SECOND_PRIZE;
                break;
            }
        }
        return totalCorrectionEach;
    }

    public static void printResult(List<Integer> result){
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(result, 3) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(result, 4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(result, 5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(result, 7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(result, 6) + "개");
    }
}

class profit_margin_caculation{
    public static void profitMargin(List<Integer> result, int inputMoney){
        int totalPrize = 0;
        totalPrize += 5000 * Collections.frequency(result, 3);
        totalPrize += 50000 * Collections.frequency(result, 4);
        totalPrize += 1500000 * Collections.frequency(result, 5);
        totalPrize += 30000000 * Collections.frequency(result, 7);
        totalPrize += 2000000000 * Collections.frequency(result, 6);
        float profitMargin = (float) totalPrize /inputMoney * 100;
        printProfit(profitMargin);
    }

    public static void printProfit(float margin){
        System.out.println("총 수익률은 "+ String.format("%.1f", margin) + "%입니다.");
    }

}

public class Application {
    public static void main(String[] args) {

        int realMoney = money_for_lotto.exceptionRepeatMoney();
        int repeatTime = money_for_lotto.repeatTime(realMoney);

        System.out.println("\n" + repeatTime + "개를 구매했습니다.");
        List<List<Integer>> totalLotto = random_lotto.print_lotto(repeatTime);
        List<Integer> winningNumber = winning_number.exceptionRepeatWinNumber();
        int realBonus = bonus_number.exceptionRepeatBonus(winningNumber);

        System.out.println("\n당첨 통계\n---");
        List<Integer> result = lotto_result.totalLottoCheck(totalLotto, winningNumber, realBonus);
        profit_margin_caculation.profitMargin(result, realMoney);
        Console.close();

    }
}
