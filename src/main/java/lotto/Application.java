package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        final String REGEX = "\\b\\d*[05]00\\b";
        final String REGEX2 = "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}$";
        final String REGEX3 = "([1-9]|[1-3][0-9]|4[0-5])";

        List<Lotto> lottoWallet = new ArrayList<Lotto>();
        boolean flag = true;
        String input;
        int money=0;
        while(flag){
            System.out.println("구입금액을 입력해 주세요.");
            input= Console.readLine();
            try {
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
            lottoWallet.add(lottoTicket);
            System.out.println(lottoTicket);
        }
        flag =true;
        WinningNumber winningNumber = null;
        Set<Integer> set = null;
        while(flag){
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                input = Console.readLine();
                if(!input.matches(REGEX2)) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                String[] stringNumbers = input.split(",");
                set = Arrays.stream(stringNumbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
                checkDuplicate(set);
                flag=false;
            }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    flag=true;
                }
            }
        flag=true;
        while(flag){
            try{
                System.out.println("보너스 번호를 입력해 주세요");
                input = Console.readLine();
                if(!input.matches(REGEX3)) throw new IllegalArgumentException("[ERROR] 1개의 숫자를 입력해주세요");
                if(set.contains(input))throw new IllegalArgumentException("[ERROR] 당첨번호에 포함되어 있는 숫자입니다.");
                winningNumber = new WinningNumber(set,Integer.parseInt(input));
                flag=false;
            }catch (IllegalArgumentException e){System.out.println(e.getMessage());flag=true;}
        }
       Counter counter = new Counter(lottoWallet,winningNumber);
        counter.calculate();
        }
    private static void checkDuplicate(Set<Integer> set) {
        if(set.size()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

