package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoInput {

    ExceptionCases exceptionCases = new ExceptionCases();
    public int getLottoPrice() {
        PrintInput printInput = new PrintInput();
        printInput.printLottoMoney();
        String s;
        do {
            s = Console.readLine();
        } while (exceptionCases.LottoPriceCheck(s));
        System.out.println();
        return Integer.parseInt(s);
    }

    public List<Integer> getWinningNum(){
        List<Integer> WinningNumbers = new ArrayList<>();
        String s = Console.readLine();
        String[] tempS = s.split((","));
        for (String temp : tempS) {
            try {
                WinningNumbers.add(Integer.parseInt(temp));
            }catch (NumberFormatException e){
                exceptionCases.CheckFormat2();
                return getWinningNum();
            }
        }
        return CheckError(WinningNumbers,s);
    }
    public int getBonusNum(){
        String s = Console.readLine();
        int i;
        try {
            i = Integer.parseInt(s);
        }catch (NumberFormatException e){
            exceptionCases.CheckFormat2();
            return getBonusNum();
        }
        return CheckBonusError(i);
    }
    public List<Integer> CheckError(List<Integer> WinningNumbers, String s){
        try{
            new Lotto(WinningNumbers);
            exceptionCases.CheckLastComma(s);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            WinningNumbers = getWinningNum();
        }
        return WinningNumbers;
    }
    public int CheckBonusError(int Bonus){
        try{
            exceptionCases.CheckNum(Bonus);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Bonus = getBonusNum();
        }
        return Bonus;
    }
}
