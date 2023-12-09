package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int payForLotto() {
        System.out.println("구매하실 금액을 입력해 주세요.");
        int pay = Integer.parseInt(Console.readLine());
        if(pay%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        return pay;
    }
    public List<Integer> userInputLottoNum() {
        List<Integer> winningNum = new ArrayList<>();
        System.out.println("로또 당첨 번호를 여섯개 입력해주세요.(쉼표로 구분합니다)");
        String userInput= Console.readLine();
        String [] winningNums = userInput.split(",");
        for (String num : winningNums) {
            int intNum = Integer.parseInt(num);
            if (!isValidate(intNum)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNum.add(intNum);
        }
        return winningNum;
    }

    public int inputBonusNum() {
        System.out.println("보너스 번호를 입력해주세요.");
        int plusNum = Integer.parseInt(Console.readLine());
        if(!isValidate(plusNum)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return plusNum;
    }

    public boolean isValidate(int num) {
        if(num<1 || num>45){
            return false;
        }
        return true;
    }
}
