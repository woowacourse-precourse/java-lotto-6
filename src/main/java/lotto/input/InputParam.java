package lotto.input;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParam {
    public int inputMoney(){
        return Integer.parseInt(inputMoneyLoop());
    }
    public String inputMoneyLoop(){
        String money;
        while (true){
            money=readLine();
            try {
               errorCheckInputMoney(money);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액을 잘못 입력했습니다.");
                continue;
            }
            break;
        }
        return money;
    }
    public void errorCheckInputMoney(String money) {
        for (int i = 0; i < money.length(); i++) {
            int num=money.charAt(i)-'0';
            if(num<0||num>9) {
                throw new IllegalArgumentException();
            }
        }
        if(Integer.parseInt(money)%1000!=0) throw new IllegalArgumentException();
    }

    public int[] inputLottoNumbers(){
        int[] inputNumbers = inputNumberLoop();
        return inputNumbers;
    }

    private  int[] inputNumberLoop() {
        while (true){
            String[] split = readLine().split(",");
            int[] inputNumbers=new int[split.length];
            for (int i = 0; i < split.length; i++) {
                inputNumbers[i] = Integer.parseInt(split[i]);
            }
            try{
                errorCheckInputNumber(inputNumbers);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 중복문자가 입력되었습니다.");
            }
            return inputNumbers;
        }
    }

    public void errorCheckInputNumber(int[] inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int inputNumber : inputNumbers) {
            uniqueNumbers.add(inputNumber);
        }
        if(uniqueNumbers.size()!=6) throw new IllegalArgumentException();
    }

    public int inputBonusNumber(){
        int n = Integer.parseInt(readLine());
        return n;
    }
}
