package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean flag = true;
        int money=0;
        while(flag){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                money = Integer.parseInt(Console.readLine());
                if(money%1000!=0)
                    throw new IllegalArgumentException();
                flag =false;
            }catch (Exception e){
                System.out.println("[error] 1000원 단위의 숫자를 입력해주세요");
                flag =true;
            }finally {
                continue;
            }
        }
        for(int i=0;i<money/1000;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoTicket = new Lotto(numbers);
            System.out.println(lottoTicket);
        }
    }
}
