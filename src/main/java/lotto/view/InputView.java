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
                CustomizedException.notDivisibleByThousandException(LottoPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return LottoPrice;
    }

    public static void storeWinningNumbersArraysToList(List<Integer> WinningNumbers, String InputData) {
        String[] TemporaryWinningNumbers = InputData.split(",");
        for (int i = 0; i < TemporaryWinningNumbers.length; i++) {
            WinningNumbers.add(Integer.valueOf(TemporaryWinningNumbers[i]));
        }
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> WinningNumbers;
        while (true) {
            try {
                WinningNumbers = new ArrayList<>();
                String InputData = Console.readLine();
                storeWinningNumbersArraysToList(WinningNumbers, InputData);
                CustomizedException.winningNumbersQualification(WinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return WinningNumbers;
    }
    public static int getBonusNumber(){
        int bonusNumber;
        while(true){
            try {
                bonusNumber= Integer.parseInt(Console.readLine());
                CustomizedException.bonusNumbersNotRange(bonusNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
