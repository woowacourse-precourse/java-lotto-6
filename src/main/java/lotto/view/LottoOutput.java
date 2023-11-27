package lotto.view;

import camp.nextstep.edu.missionutils.Console;


import java.util.List;

import static lotto.view.ConstantsMessage.*;

public class LottoOutput {



    public void buyLottoNumberPrint(List<List<Integer>> lottoNumber) {
        printNewLine();
        System.out.println(lottoNumber.size()+BUY_RESULT_MESSAGE.getMessage());
        lottoNumber.forEach(System.out::println);
    }
    public Integer bonusNumberInput() {
        printNewLine();
        System.out.println(ASK_BONUS_NUMBER.getMessage());
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
    public static void seeWinningStatstic(List<String> lottoPrizes) {
        System.out.println(WIN_RESULT_MESSAGE.getMessage());
        System.out.println(lINE_SEPARATION_MESSAGE.getMessage());
       for(String lottoPrize : lottoPrizes){
           System.out.println(lottoPrize);
       }

    }
    private void printNewLine() {
        System.out.println();
    }
}
