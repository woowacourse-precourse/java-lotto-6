package lotto;

import java.lang.NumberFormatException;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static boolean isInteger(String input){
        try{
            Integer.parseInt (input);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] 입력값은 정수여야 합니다.");
            return false;
        }
    }
    public static void cashSanityCheck(int cashInput)  throws IllegalArgumentException {
        if ( (cashInput%10) != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000의 배수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void numberCheck(int inputNumber) throws IllegalArgumentException {
        if ( !(1 <= inputNumber && inputNumber <= 45) ) {
            System.out.println("[ERROR] 로또 번호는 1에서 45 사이의 정수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void bonusCheck(ArrayList<Integer> input, int bonus) throws IllegalArgumentException {
        if(input.contains(bonus)){
            System.out.println("[ERROR] 보너스 숫자가 당첨 숫자와 중복입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean isRightNumber(int number){
        try{
            numberCheck(number);
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public static boolean overlapCheck(List<Integer> numbers) throws IllegalArgumentException {
        List<Integer> UserInput = new ArrayList<>();
        for (Integer number : numbers) {
            if( !isInteger(String.valueOf(number)) ){
                return false;
            }

            int digit = Integer.parseInt(String.valueOf(number));
            if ( !isRightNumber(digit) ){
                return false;
            }

            if ( !UserInput.contains(digit) ) {
                UserInput.add(digit);
                continue;
            }
            System.out.println("[ERROR] 로또 번호는 6개의 중복되지 않는 정수여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isRightCash(String input){
        if ( !isInteger(input) ) return false;
        int cash = Integer.parseInt(input);
        try{
            cashSanityCheck(cash);
            return true;
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }
    public static boolean isRightLotto(List<Integer> numbers){
        try{
            if ( numbers.size() > 6 ){
                System.out.println("[ERROR] 로또 번호는 6개의 중복되지 않는 정수여야 합니다.");
                throw new IllegalArgumentException();
            }
            return overlapCheck(numbers);
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }

    public static boolean isRightBonus(ArrayList<Integer> input, int bonus){
        if( !isRightNumber(bonus) ){
            return false;
        }
        try{
            bonusCheck(input, bonus);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    public static ArrayList<Integer> stringToIntList(String input){
        String[] InputTokens = input.split(",");
        ArrayList<Integer> intList = new ArrayList<>();
        for (String tokens : InputTokens){
            intList.add(Integer.parseInt(tokens));
        }
        return intList;
    }

    public static ArrayList<Integer> compare(ArrayList<Lotto> input, ArrayList<Integer> winning, int bonus){
        ArrayList<Integer> winnings = new ArrayList<>();
        int profit = 0;
        for (int i = 0; i < 6; i++){
            winnings.add(0);
        }


        for (Lotto lotto : input){
            ArrayList<Integer> comparing = new ArrayList<>();
            for (int i = 0; i < 6; i++){
                comparing.add(lotto.getNumbers().get(i));
            }

            int bonusFlag = 0;
            if (comparing.contains(bonus)){
                bonusFlag = 1;
            }

            comparing.retainAll(winning);
            if(comparing.size()==3){
                winnings.set(0, winnings.get(0)+1);
                profit = profit + 5000;
            }
            if(comparing.size()==4){
                winnings.set(1, winnings.get(1)+1);
                profit = profit + 50000;
            }
            if(comparing.size()==6){
                winnings.set(4, winnings.get(4)+1);
                profit = profit + 2000000000;
            }
            if(comparing.size()==5 && bonusFlag==1){
                winnings.set(3, winnings.get(3)+1);
                profit = profit + 3000000;
                continue;
            }
            if(comparing.size()==5){
                winnings.set(2, winnings.get(2)+1);
                profit = profit + 1500000;
            }
        }

        winnings.set(5, profit);
        return winnings;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int Investment = 0;
        ArrayList<Lotto> Lottos = new ArrayList<>();

        System.out.println("구입금액을 입력해 주세요.");
        String User = Console.readLine();
        while(!isRightCash(User)){
            System.out.println("구입금액을 다시 입력해 주세요.");
            User = Console.readLine();
        }

        Investment = Integer.parseInt(User);
        int PlayingTime = Investment / 1000;
        System.out.printf("%d개를 구매했습니다.\n", PlayingTime);

        for (int i = 0; i < PlayingTime; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto eachLotto = new Lotto(numbers);
            Lottos.add(eachLotto);
        }
        for (Lotto lotto : Lottos){
            lotto.printNumbers();
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        User = Console.readLine();
        ArrayList<Integer> winningNumber = stringToIntList(User);
        while( !isRightLotto(winningNumber) ){
            System.out.println("당첨 번호를 다시 입력해 주세요.");
            User = Console.readLine();
            winningNumber = stringToIntList(User);
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        while( !isRightBonus(winningNumber, bonusNumber) ){
            System.out.println("보너스 번호를 다시 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
        }

        float Profit = 0;
        ArrayList<Integer> result = compare(Lottos, winningNumber, bonusNumber);
        Profit = (float) result.get(5) / Investment * 100;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(4));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", Profit);
    }

}
