package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Number {
    List<Integer> inspectNumber;
    private static final String purchaseMessage = "구입금액을 입력해 주세요.";
    private static final String purchaseNumberMessage = "개를 구매했습니다.";
    private static final String winningNumberMessage = "당첨 번호를 입력해 주세요.";
    private static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private static final String error = "[ERROR]";
    private static final String errorNumber = " 숫자를 제대로 입력해주세요.";
    private static final String error1000 = " 1000으로 나누어 떨어지는 수를 입력해주세요.";
    private static final String errorRange = " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String errorDuplication = " 서로 다른 수를 입력해주세요.";
    public int getLottoPurchaseNumber(){
        while(true){
            System.out.println(purchaseMessage);
            String purchaseLottoInput = Console.readLine();
            if(inputFormat(purchaseLottoInput)){
                int purchaseNumber = Integer.parseInt(purchaseLottoInput);
                int number = purchaseNumber / 1000;
                System.out.println(number+purchaseNumberMessage);
                return number;
            }
        }
    }
    private boolean inputFormat(String inputNumber){
        try{
            int purchaseNumber = Integer.parseInt(inputNumber);
            if(purchaseNumber % 1000 != 0){
                throw new IllegalArgumentException(error1000);
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println(error + errorNumber);
            return false;
        }catch (IllegalArgumentException e){
            System.out.println(error + e.getMessage());
            return false;
        }
    }

    public List<Integer> getLottoRandom(){
        List<Integer> ranmdomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(ranmdomNumber);
        return ranmdomNumber;
    }

    public List<Integer> getLottoWinning(){
        while(true){
            try{
                return winningNumberInspect();
            }catch(NumberFormatException e){
                System.out.println(error+errorNumber);
            }catch(IllegalArgumentException e){
                System.out.println(error+e.getMessage());
            }
        }
    }
    private List<Integer> winningNumberInspect() {
        System.out.println(winningNumberMessage);
        String[] winningNumber = Console.readLine().split(",");
        inspectNumber = new ArrayList<>();
        inputInspect(winningNumber);
        new Lotto(inspectNumber);
        return inspectNumber;
    }
    private void inputInspect(String[] number){
        for(String a : number){
            int num = Integer.parseInt(a);
            if(!inspectNumber.contains(num)){
                inspectNumber.add(num);
            }
        }
    }
    public int getLottoBonus(){
        while(true){
            try{
                System.out.println(bonusNumberMessage);
                String bounusNumber = Console.readLine();
                int bonus = Integer.parseInt(bounusNumber);
                numberRangeInspect(bonus);
                if(inspectNumber.contains(bonus)){
                    throw new IllegalArgumentException(errorDuplication);
                }
                return bonus;
            }catch(NumberFormatException e){
                System.out.println(error+errorNumber);
            }catch(IllegalArgumentException e){
                System.out.println(error+e.getMessage());
            }
        }
    }
    private void numberRangeInspect(int num){
        if(!(num >= 1 && num <= 45)){
            throw new IllegalArgumentException(errorRange);
        }
    }
}
