package lotto.service;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class UserInputServiceImpl implements UserInputService {
    List <Integer> winningNum = new ArrayList<>();
    @Override
    public int payForLotto() {
        System.out.println("구매하실 금액을 입력해 주세요.");
        int pay = Integer.parseInt(Console.readLine());
        if(pay%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        return pay;
    }
    @Override
    public void userInputLottoNum() {
        System.out.println("로또 당첨 번호를 여섯개 입력해주세요. (쉼표로 구분합니다) ");
        String userInput= Console.readLine();
        String [] winningNums = userInput.split(",");
        for (String num : winningNums) {
            int intNum = Integer.parseInt(num);
            if (isValidate(intNum)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNum.add(intNum);
        }
        System.out.println("보너스 번호를 입력해주세요. ");
        int plusNum = Integer.parseInt(Console.readLine());
        if(!isValidate(plusNum)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        winningNum.add(plusNum);
    }
    @Override
    public boolean isValidate(int num) {
        if(num<1 || num>45){
            return false;
        }
        return true;
    }
    @Override
    public Lotto createLotto() {
        userInputLottoNum();
        return new Lotto(winningNum);
    }
}


