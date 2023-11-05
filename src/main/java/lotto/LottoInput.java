package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.description.annotation.AnnotationValue.ForEnumerationDescription.WithUnknownConstant;

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
    public List<Integer> CheckError(List<Integer> WinningNumbers, String s){
        try{
            new Lotto(WinningNumbers);
            CheckLast(s);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            WinningNumbers = getWinningNum();
        }
        return WinningNumbers;
    }
    public void CheckLast(String s){
        if(s.charAt(s.length()-1)==','){
            exceptionCases.CheckComma();
        }
    }
    public int getBonusNum(){
        String s = Console.readLine();
        return Integer.parseInt(s);
    }
}
