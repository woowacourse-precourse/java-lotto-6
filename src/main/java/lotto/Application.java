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

    public void numberCheck(int inputNumber) throws IllegalArgumentException {
        if ( !(1 <= inputNumber && inputNumber <= 45) ) {
            System.out.println("[ERROR] 로또 번호는 1에서 45 사이의 정수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void overlapCheck(List<Integer> numbers) throws IllegalArgumentException {
        List<Integer> UserInput = new ArrayList<>();
        for (Integer number : numbers) {
            int digit = Integer.parseInt(String.valueOf(number));
            if (!UserInput.contains(digit)) {
                UserInput.add(digit);
                continue;
            }
            System.out.println("[ERROR] 로또 번호는 6개의 중복되지 않는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean isRightCash(String input){
        if (isInteger(input)) return false;
        int cash = Integer.parseInt(input);
        try{
            cashSanityCheck(cash);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isRightLotto(List<Integer> numbers){
        try{
            overlapCheck(numbers);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String buying = "a";
        ArrayList<Lotto> Lottos = new ArrayList<>();

        while(!isRightCash(buying)){
            System.out.println("구입금액을 입력해 주세요.");
            buying = Console.readLine();
        }

        int PlayingTime = Integer.parseInt(buying) / 1000;
        System.out.printf("%d개를 구매했습니다.\n", PlayingTime);

        for (int i = 0; i < PlayingTime; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto eachLotto = new Lotto(numbers);
            Lottos.add(eachLotto);
        }
        for (Lotto lotto : Lottos){
            lotto.printNumbers();
        }
        

    }


}
