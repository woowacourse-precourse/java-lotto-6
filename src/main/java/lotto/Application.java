package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers= new ArrayList<>();
        int numberOfLotto = 0;
        int money = 0;


        System.out.println("구입 금액을 입력해 주세요.");
        money = moneyInput(money);
        System.out.println();
        System.out.println(money+"개를 구매했습니다.");

        for(int i = 0 ; i < money ; i++) {
            makeLotto(lottos);
            printLotto(lottos.get(i).getNumbers());
            System.out.println();
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbersInput(winningNumbers);

    }

    public static int moneyInput(int money){
        try {
            money = Integer.parseInt(Console.readLine());
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 1000원 단위로 입력하여야 합니다.");
        }
        if((money%1000)!=0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하여야 합니다. ");
        return money;
    }

    public static void makeLotto(List<Lotto> lottos){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        Lotto firstLottoList = new Lotto(numbers);
        lottos.add(firstLottoList);
    }

    public static void printLotto(List<Integer> lotto){
        System.out.print(lotto);
    }

    public static void winningNumbersInput (List<Integer> winningNumbers) {
        String userInput = Console.readLine();
        String[] numbers = userInput.split(",");
        if(numbers.length!=6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        try {
            for (String name : numbers){
                winningNumbers.add(Integer.parseInt(name.trim()));
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        }

    }

}
