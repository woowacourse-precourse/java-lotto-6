package lotto.controller;

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
        
        while (inputBuyCostIntegerVaildation(buycost) ||
                inputBuyCostUnitVaildation(buycost)) {
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
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortAscendingNumbers(lotto);
    }

    public String[] InputCorrectLotto(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        
        String[] numbers = input.split(",");
        while(inputNumberIntegerVaildation(numbers)){
            input = Console.readLine();
            numbers = input.split(",");
        }

        return numbers;
    }

    public ArrayList<Integer> conversionInputToInteger(String[] input){
        ArrayList<Integer> correctNumbers = new ArrayList<>();

        for(String st : input){
            int value = Integer.parseInt(st);
            correctNumbers.add(value);
        }

        return correctNumbers;
    }
    
    public boolean inputNumberIntegerVaildation(String[] input){
        boolean end = false;
        try{
            for(String st : input){
                Integer.parseInt(st);
            }
        }catch(IllegalArgumentException e){
            end = true;
            System.out.println(e + "\n[ERROR]당첨 번호는 숫자를 입력해야 합니다.");
            System.out.println("\n당첨 번호를 입력해 주세요.");
        }
        return end;
    }

    public List<Integer> sortAscendingNumbers(List<Integer> sortLottoNumbers){
        Collections.sort(sortLottoNumbers);
        return sortLottoNumbers;
    }

    public boolean inputBuyCostIntegerVaildation(String buycost){
        boolean end = false;
        try{
            Integer.parseInt(buycost);
        }catch(IllegalArgumentException e){
            end = true;
            System.out.println(e + "\n[ERROR]구입금액은 숫자여야 합니다.");
            System.out.println("\n구입금액을 입력해 주세요.");
        }
        return end;
    }

    public boolean inputBuyCostUnitVaildation(String buycost){
        boolean end = false;
        try{
            if(Integer.parseInt(buycost) % LOTTOCOSTUNIT != 0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            end = true;
            System.out.println("\n[ERROR]1000원 단위로 구매해 주세요.");
            System.out.println("\n구입금액을 입력해 주세요.");
        }
        return end;
    }
}
