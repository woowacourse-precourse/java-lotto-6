package lotto.Lottery.Service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lottery.Util.CostChecker;

public class LottoService {

    CostChecker costChecker = new CostChecker();

    private int userMoney;
    final static int LOTTO_PRICE = 1000;

    // Getter
    public int getUserMoney() {
        return userMoney;
    }

    /**
     * 해당 부분은 사용자의 입력 부분과 관련이 있으며 사용자의 입력 정보(Long type)를 받고 검사한다.
     * 검사가 되는 부분은 총 4가지이다.
     * 1. Long 타입 값을 벗어난 경우 Java에서 자체적으로 IllegalArgumentException을 던져준다.
     * 2. 사용자의 입력을 받았을 때 숫자값이 아닌 경우 Java의 오류를 IllegalArgumentException으로 변환하여 던진다.
     * 3. 사용자 정의: 로또 금액인 1000원 단위를 벗어난 경우 IllegalArgumentException을 던져준다.
     * 4. 사용자 정의: 로또 금액이 양수가 아닌 경우 IllegalArgumentException을 던져준다.
     *
     * 실제 구현에서는 오류가 뜨더라도 예외 메세지를 던지고 반복을 해야한다.
     * 따라서 Impl 부분에서는 해당 조건이 만족되어 true를 반환할 때까지 무한하게 반복한다.
     */

    public boolean getUserCostInput(){
        try{
            System.out.println("구입금액을 입력해 주세요.");
            this.userMoney = costChecker.isNumber(Console.readLine()); // 유효성 검사(숫자?) -> IllegalArgumentException으로 변환
            System.out.println();
            costChecker.CostCheck(userMoney); // 유효성 검사(1000원 단위?, 양수?)
            return true;
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 유효하지 않은 금액입니다. 다음과 같이 입력해주세요. ex) 1000");
            System.out.println();
            return false;
        }
    }

    public void UserCostInputImpl(){
        while(getUserCostInput() == false);
    }


}
