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

    public void bonusNumberVaildation(String bonusNum, List<Integer> correctNumbers){
        if(bonueNumberIntegerVaildation(bonusNum)){
            throw new IllegalArgumentException("\n보너스 번호는 숫자를 입력해 주세요.");
        }
        else if(bonusNumDuplicateVaildation(bonusNum, correctNumbers)){
            throw new IllegalArgumentException("\n중복되지 않은 번호를 입력해 주세요.");
        }
        else if(bonusNumRangeVaildation(bonusNum)){
            throw new IllegalArgumentException("\n1부터 45사이의 번호를 입력해 주세요.");
        }
    }

    private boolean bonueNumberIntegerVaildation(String bonusNum){
        try{
             Integer.parseInt(bonusNum);
        }catch(IllegalArgumentException e){
            return true;
        }
        return false;
    }

    private boolean bonusNumDuplicateVaildation(String bonusNum, List<Integer> correctNumbers){
        int bonusNumer = Integer.parseInt(bonusNum);
        for(int i : correctNumbers){
            if(i == bonusNumer){
                return true;
            }
        }
        return false;
    }

    private boolean bonusNumRangeVaildation(String bonusNum){
        int bonusNumber = Integer.parseInt(bonusNum);
        if(bonusNumber > 45 || bonusNumber <1){
            return true;
        }
        return false;
    }
}
