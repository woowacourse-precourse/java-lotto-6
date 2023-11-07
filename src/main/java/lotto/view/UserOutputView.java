package lotto.view;

import lotto.controller.LottoCompareController;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserOutputView {

    public static  void outputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요");

    }

    public static void getBuyLottoTicketsNum(){
        System.out.println();
        System.out.println(LottoController.getBuyLottoTicketsNum() + "개를 구매했습니다.");
    }

    public static void getBuyLottoTickets(){
        for(Lotto lotto : LottoController.getBuyLottoTickets()){
            System.out.println(getLottoNums(lotto));
        }

    }

    public static void outputWinningNums(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void outputBonusNum(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void winningStatistics(){
        System.out.println();
        System.out.println("당첨 통계");
        LottoCompareController.lottoTicketsCompareNum();
        System.out.println("---");
    }

    public static  void winningStatisticsResult(){
        System.out.println("3개 일치 (5,000원) - " + WinningLotto.getTreeSameNumLotto() + "개");
        System.out.println("4개 일치 (50,000원) - " + WinningLotto.getFourSameNumLotto() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + WinningLotto.getFiveSameNumLotto() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + WinningLotto.getFiveAndBonusSameNumLotto() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + WinningLotto.getSixSameNumLotto() + "개");
    }

    public static void winningLottoRateResult(){
        System.out.println("총 수익률은 " + LottoCompareController.winningLottoRate()+"%입니다.");
    }






    private static List<Integer> getLottoNums(Lotto lotto){
        List<Integer> lottoNums = new ArrayList<>();
        for(Integer lottoNum : lotto.getNumbers()){
            lottoNums.add(lottoNum);
        }
        Collections.sort(lottoNums);
        return lottoNums;
    }

}
