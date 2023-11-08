package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPrize;

import java.util.Arrays;
import java.util.List;

public class LottoView {
    public  LottoView(){

    }

    public int askPrice() {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            return Integer.parseInt(input);

    }

    public void buyLottoNumberPrint(List<List<Integer>> lottoNumber) {
        System.out.println();
        System.out.println(lottoNumber.size()+"개를 구매했습니다.");
        lottoNumber.forEach(System.out::println);
    }

    public List<String> prizeNumberInput() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> input = Arrays.asList(Console.readLine().split(","));
        return input;
    }

    public Integer bonusNumberInput() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }





    public void seeWinningStatstic(List<LottoPrize> lottoPrizelist) {
        System.out.println("당첨통계");
        System.out.println("---");
        for(LottoPrize lottoPrize: lottoPrizelist){
            System.out.println(lottoPrize.getText()+lottoPrize.getWinCount()+lottoPrize.getUnit());
        }
    }

    public void seePercentage(double percentage) {
        System.out.println("총 수익률은 "+percentage+"%입니다.");

    }
}
