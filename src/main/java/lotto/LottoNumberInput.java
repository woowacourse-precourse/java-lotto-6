package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberInput {
    List<Integer> numbers;
    int countNum;
    int bonusNum;
    public void run (){
        moneyInput();
        //numberInput();
        bonusInput();
        Lotto lotto = new Lotto(numbers);
    }

    private void bonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Integer.parseInt(Console.readLine());
        if(bonusNum<1 || bonusNum >25){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    private void moneyInput(){
        System.out.println("구입금액을 입력해 주세요.?");
        countNum = Integer.parseInt(Console.readLine());
    }

    public void numberInput(String testnum){
        System.out.println("당첨 번호를 입력해 주세요.");
        String num = testnum;
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
        //hasduplication();
    }

    public void hasduplication(List<Integer> testNumbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for( int number : testNumbers){
            if(!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
    }
}
