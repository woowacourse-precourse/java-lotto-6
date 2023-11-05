package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        final String REGEX = "\\b\\d*[05]00\\b";
        final String REGEX2 = "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}$";

        boolean flag = true;
        String input;
        int money=0;
        while(flag){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input= Console.readLine();
                if(!input.matches(REGEX)) throw new IllegalArgumentException("[ERROR] 1000원 단위의 숫자를 입력해주세요");
                money = Integer.parseInt(input);
                flag =false;
            }catch (Exception e){
                System.out.println(e.getMessage());
                flag =true;
            }
        }
        int numberOfTicket = money/1000;
        System.out.println(numberOfTicket+"개를 구매했습니다.");
        for(int i=0;i<numberOfTicket;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoTicket = new Lotto(numbers);
            System.out.println(lottoTicket);
        }
        flag =true;
        while(flag){
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                input = Console.readLine();
                if(!input.matches(REGEX2)) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                String[] winningNumber=input.split(",");
                Set<String> set = new HashSet<String>(Arrays.asList(winningNumber));
                checkDuplicate(set);
                flag=false;
            }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    flag=true;
                }
            }
        }

    private static void checkDuplicate(Set<String> set) {
        if(set.size()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

