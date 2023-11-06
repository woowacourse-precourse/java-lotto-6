package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    final static int LOTTOCOSTUNIT = 1000;

    public int inputBuyCost(){
        System.out.println("구입금액을 입력해 주세요.");
        String buycost = Console.readLine();
        
        while (inputBuyCostVaildation(buycost)) {
            buycost = Console.readLine();
        }
        return Integer.parseInt(buycost);
    }

    public int createUnitLotto(int buycost){
        int buycount = buycost/LOTTOCOSTUNIT;
        return buycount;
    }

    public List<Integer> createRandomNumbers(){
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        return lotto;
    }

    public List<Integer> sortAscendingNumbers(List<Integer> sortLottoNumbers){
        return null;
    }

    public boolean inputBuyCostVaildation(String buycost){
        boolean end = false;
        try{
            int unitlotto = Integer.parseInt(buycost);
            if(unitlotto % LOTTOCOSTUNIT !=0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            end = true;
            System.out.println(e + "\n[Error]구입금액을 입력해 주세요.");
        }
        return end;
    }
}
