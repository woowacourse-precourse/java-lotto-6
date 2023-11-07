package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Purchase {

    public List<List<Integer>> process(){
        System.out.println("구입금액을 입력해주세요.");
        int money = 0;
        while (true){
            try{
                money = Integer.parseInt(inputMoney());
                break;
            }catch (NumberFormatException exception){
                System.out.println("[ERROR] 구입 금액은 숫자만 입력 가능합니다.");
            }
        }
        int lottoCount = checkLottoCount(money);
        return printLotto(lottoCount);
    }

    public String inputMoney(){
        return Console.readLine();
    }
    public int checkLottoCount(int money) throws NumberFormatException{
        int lottoCount = money / 1000;
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 확인해주세요. 1장당 1000원");
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public List<List<Integer>> printLotto(int lottoCount){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (lottoCount > 0){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> newLottoNumber = new ArrayList<>(lottoNumber);
            Collections.sort(newLottoNumber);
            System.out.println(newLottoNumber);
            lottoCount--;
            lottoNumbers.add(newLottoNumber);
        }

        return lottoNumbers;
    }
}
