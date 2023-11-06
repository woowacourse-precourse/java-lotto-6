package lotto;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> createLottoNumbers(int buycount){
        System.out.println("\n"+buycount+"개를 구매했습니다.");
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0 ; i < buycount ; i++){
            lottoNumbers.add(createRandomNumber());
        }
        return lottoNumbers;
    }

    public List<Integer> createRandomNumber(){
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        return sortAscendingNumbers(lotto);
    }

    public List<Integer> sortAscendingNumbers(List<Integer> sortLottoNumbers){
        Collections.sort(sortLottoNumbers);
        return sortLottoNumbers;
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
