
package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    int lottoCounts;
    int cost;

    BuyLotto(){
        boolean validInput = false;
        while (!validInput) {
            try {
                cost = Integer.parseInt(lottoCost());
                numberOfLotto(cost);
                validInput = true;
            }catch (NumberFormatException e){
                System.out.println("[Error] 숫자만 입력해주세요");
            }catch (IllegalArgumentException e) {
                System.out.println("[Error] 1000원 단위로 입력해주세요");
            }
        }
        numberOfLotto(cost);
    }
    int getCost(){
        return this.cost;
    }
    int getLottoCounts(){
        return this.lottoCounts;
    }

    String lottoCost(){
        String inputCost = Console.readLine();
        return inputCost;
    }

    void numberOfLotto(int cost){
        if(cost%1000 != 0) throw new IllegalArgumentException();
        lottoCounts = cost/1000;
    }
    void showCount(int lottoCounts){
        System.out.printf("%d%s%n", lottoCounts, "개를 구매했습니다");
    }

    void showLotto(int count){
        for(int i = 0; i < count; i++){
            printNumber(selectNumber());
            System.out.println();
        }
    }

    void printNumber(List<Integer> numbers){
        System.out.print("[");
        for(int i = 0; i < 6; i++){
            System.out.printf("%d", numbers.get(i));
            if(i != 5) System.out.print(", ");
        }
        System.out.print("]");
    }

    List<Integer> selectNumber(){
        List<Integer> numbers= new ArrayList<>();
        while(numbers.size() < 6) {
            int num = Randoms.pickNumberInRange(1, 45);
            if(checkOverlap(num, numbers)) numbers.add(num);
        }
        return numbers;
    }

    boolean checkOverlap(int num, List<Integer> array){
        if(array.contains(num)) return false;
        return true;
    }
}