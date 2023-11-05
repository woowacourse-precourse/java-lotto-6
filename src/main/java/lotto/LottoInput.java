package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.description.annotation.AnnotationValue.ForEnumerationDescription.WithUnknownConstant;

public class LottoInput {
    private static final List<Integer> WinningNumbers = new ArrayList<>();
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
        String[] tempS;
        String s = Console.readLine();
        tempS = s.split((","));
        for (String temp : tempS) {
            WinningNumbers.add(Integer.parseInt(temp));
        }
        return WinningNumbers;
    }
    public int getBonusNum(){
        String s = Console.readLine();
        return Integer.parseInt(s);
    }
}
