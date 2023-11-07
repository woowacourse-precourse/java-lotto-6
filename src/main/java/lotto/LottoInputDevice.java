package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoInputDevice {
    static final int LOTTERY_COST = 1000;
    static final int MIN_LOTTERY_NUM = 1;
    static final int MAX_LOTTERY_NUM = 45;
    public int getMoney() {
        System.out.println("구입금액을 입력해주세요.");
        int money;

        while(true){
            try{
                money = inputMoney();
                break;
            } catch(NumberFormatException e){
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            } catch(IllegalArgumentException e){
                System.out.println("[ERROR] 돈은 1000단위로 입력해야 합니다.");
            }
        }
        return money;
    }

    private int inputMoney() throws IllegalArgumentException{
        int money = Integer.parseInt(Console.readLine());

        if(money % LOTTERY_COST != 0){
            throw new IllegalArgumentException();
        }

        return money;
    }

    public Lotto getWinningNumber(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> number;
        Lotto winningNumber;
        while(true){
            try{
                number = inputWinningNumber();
                winningNumber = new Lotto(number);
                break;
            } catch(IllegalArgumentException e){
            }
        }
        return winningNumber;
    }

    private List<Integer> inputWinningNumber(){
        List<Integer> number = new ArrayList<>();

        String[] inputWinningNumber = Console.readLine().split(",");
        for (String eachNumber : inputWinningNumber) {
            number.add(Integer.parseInt(eachNumber));
        }

        return number;
    }

    public int getBonusNumber(Lotto winningNumber) throws IllegalArgumentException{
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        int bonusNumber;

        while(true){
            try{
                bonusNumber = inputBonusNumber();
                checkRedundantNumber(winningNumber, bonusNumber);

                break;
            } catch(IllegalArgumentException e){
                System.out.println("[ERROR] 보너스 번호는 당첨번호와 다른 1 ~ 45 사이의 숫자를 입력해야 합니다.");
            }
        }

        return bonusNumber;
    }

    private int inputBonusNumber() throws IllegalArgumentException{
        int bonusNumber = Integer.parseInt(Console.readLine());

        if(bonusNumber < MIN_LOTTERY_NUM || bonusNumber > MAX_LOTTERY_NUM){
            throw new IllegalArgumentException();
        }

        return bonusNumber;
    }

    private void checkRedundantNumber(Lotto winningNumber, int bonusNumber) throws IllegalArgumentException{
        if(winningNumber.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }
}
