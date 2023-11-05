package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static final Integer lottoPrice = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        Integer inputMoney = InputMoney();
        Integer n = inputMoney / lottoPrice;
        Lotto lottoArray[] = new Lotto[n];
        System.out.println("\n"+n+"개를 구매했습니다.");
        for (int i = 0; i < n; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoArray[i] = new Lotto(numbers);
            Sort(lottoArray[i]);
            System.out.println(lottoArray[i].getNumbers());
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");

    }

    private static Integer InputMoney() {
        Integer inputMoney = Integer.valueOf(Console.readLine());
        Integer money;
        try {
            if (inputMoney % lottoPrice != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 단위는 1,000원 단위여야 합니다.");
            }
            money = inputMoney;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            money = InputMoney();
        }
        return money;
    }

    private static void Sort(Lotto lotto){
        for (int i=0;i<5;i++){
            Sorting(lotto,i);
        }
    }

    private static void Sorting(Lotto lotto, int index){
        Integer minIndex=index;
        for(int i=index+1;i<6;i++){
            if(lotto.getNumberIndex(minIndex)>lotto.getNumberIndex(i)){
                minIndex=i;
            }
        }
        Integer tmp=lotto.getNumberIndex(minIndex);
        lotto.setNumberIndex(minIndex,lotto.getNumberIndex(index));
        lotto.setNumberIndex(index,tmp);
    }

    private static void InputNumber(){

    }
}