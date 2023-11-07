package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //로또 구입 금액 입력받기
        int purchaseAmount=getPurchaseAmount();


    }
    //로또 구입 금액 입력받기, 1000원 단위로 입력받음, 1000원으로 나누어 떨어지지 않으면 예외
    private static int getPurchaseAmount() {
        int purchaseAmount;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                purchaseAmount = Integer.parseInt(Console.readLine());
                if(purchaseAmount%1000!=0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;

    }
    //당첨 번호 입력 받기
//    private static List<Integer> getWinningNumbers()

    //보너스 입력 받기

}
