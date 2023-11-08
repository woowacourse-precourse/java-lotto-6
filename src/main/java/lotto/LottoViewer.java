package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.variables.LottoVariables;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.variables.ErrorMessages.LOTTO_NUM_ERROR;
import static lotto.variables.ErrorMessages.MONEY_VAL_ERROR;

public class LottoViewer {
    List<Integer> getLotteryNumbers(){
        while(true){
            return tryLotteryNumbers();
        }
    }

    private List<Integer> tryLotteryNumbers() {
        try{
            System.out.println("당첨 번호를 입력해 주세요.");
            return Arrays.stream(Console.readLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(LOTTO_NUM_ERROR.getErrorMessage());
        }
    }

    int getBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String tmp = Console.readLine();
        return Integer.parseInt(tmp);
    }

    int getMoney(){
        while(true){
            return tryGetMoney();
        }
    }

    private int tryGetMoney() {
        try{
            System.out.println("구매 금액을 입력해 주세요.");
            String tmp = Console.readLine();
            return Integer.parseInt(tmp);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(MONEY_VAL_ERROR.getErrorMessage());
        }
    }

    void printLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다. ");
        lottos.stream().forEach( lotto -> System.out.println(lotto) );
    }

    void printProfitResult(double profit){
        System.out.println(String.format("총 수익률은 %.1f%% 입니다.", profit));
    }

    void printLottoResult(Map<Integer, Integer> lotteryResult){
        System.out.println("당첨 통계");
        System.out.println("---");

        for(LottoVariables lottoVariables: LottoVariables.values())
            printLottoResult(lottoVariables, lotteryResult.get(lottoVariables.getPrice()));
    }

    void printLottoResult(LottoVariables lottoVariables, int N){
        System.out.println(lottoVariables.getDescription() + " - " + N +"개");
    }

}
