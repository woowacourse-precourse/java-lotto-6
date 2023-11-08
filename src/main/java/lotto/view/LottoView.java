package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPrize;

import java.util.Arrays;
import java.util.List;

import static lotto.view.constants.ConstantsMessage.*;

public class LottoView {
    public  LottoView(){

    }

    public int askPrice() {
            System.out.println(ASK_BUY_PRICE.getMessage());
            String input = Console.readLine();
            return Integer.parseInt(input);

    }

    public void buyLottoNumberPrint(List<List<Integer>> lottoNumber) {
        printNewLine();
        System.out.println(lottoNumber.size()+BUY_RESULT_MESSAGE.getMessage());
        lottoNumber.forEach(System.out::println);
    }

    public List<String> prizeNumberInput() {
        printNewLine();
        System.out.println(ASK_PRIZE_NUMBER.getMessage());
        List<String> input = Arrays.asList(Console.readLine().split(","));
        return input;
    }

    public Integer bonusNumberInput() {
        printNewLine();
        System.out.println(ASK_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private void printNewLine() {
        System.out.println();
    }


    public void seeWinningStatstic(List<LottoPrize> lottoPrizelist) {
        System.out.println(WIN_RESULT_MESSAGE.getMessage());
        System.out.println(lINE_SEPARATION_MESSAGE.getMessage());
        for(LottoPrize lottoPrize: lottoPrizelist){
            System.out.println(lottoPrize.getText()+lottoPrize.getWinCount()+lottoPrize.getUnit());
        }
    }

    public void seePercentage(double percentage) {
        System.out.println(PERCENT_FRONT_MESSAGE.getMessage()+percentage+PERCENT_BACK_MESSAGE.getMessage());

    }
}
