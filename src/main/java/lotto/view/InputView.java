package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomizedException;

import java.util.ArrayList;
import java.util.List;

public class InputView {


    public static int getLottoPrice() {
        int LottoPrice;
        while (true) {
            try {
                LottoPrice = Integer.parseInt(Console.readLine());
                CustomizedException.NotDivisibleByThousandException(LottoPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return LottoPrice;
    }

    public static List<Integer> getWinningNumbers(){
        List<Integer> WinningNumbers=new ArrayList<>();
        String InputData = Console.readLine();
        String[] TemporaryWinningNumbers = InputData.split(",");
        for(int i = 0 ; i<TemporaryWinningNumbers.length;i++){
            WinningNumbers.add(Integer.valueOf(TemporaryWinningNumbers[i]));
        }
        return WinningNumbers;
    }
}
