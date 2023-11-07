package lotto.controller;

import java.util.List;

public class NumberGeneratorVaildation {

    final static int LOTTOCOSTUNIT = 1000;

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

    public boolean bonueNumberIntegerVaildation(String bonusNum){
        boolean end = false;
        try{
            int bonusNumber = Integer.parseInt(bonusNum);
        }catch(IllegalArgumentException e){
            end = true;
            System.out.println("\n[ERROR]보너스 번호는 숫자를 입력해 주세요.");
            System.out.println("\n보너스 번호를 입력해 주세요.");
        }

        return end;
    }
}
