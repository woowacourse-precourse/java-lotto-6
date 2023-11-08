package lotto.view;

import lotto.controller.LottoCompareController;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserOutputView {

    private final LottoCompareController lottoCompareController = LottoCompareController.getInstance();
    private final LottoController lottoController = LottoController.getInstance();

    private UserOutputView() {
    }

    private static class UserOutputViewHolder{
        private static final UserOutputView userOutputView = new UserOutputView();
    }

    public static UserOutputView getInstance(){
        return UserOutputViewHolder.userOutputView;
    }


    public void outputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요");

    }

    public void getBuyLottoTicketsNum(){
        System.out.println();
        System.out.println(lottoController.getBuyLottoTicketsNum() + "개를 구매했습니다.");
    }

    public void getBuyLottoTickets(){
        for(Lotto lotto : lottoController.getBuyLottoTickets()){
            System.out.println(getLottoNums(lotto));
        }

    }

    public void outputWinningNums(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void outputBonusNum(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void winningStatistics(){
        System.out.println();
        System.out.println("당첨 통계");
        lottoCompareController.lottoTicketsCompareNum();
        System.out.println("---");
    }

    public void winningStatisticsResult(){
        System.out.println("3개 일치 (5,000원) - " + WinningLotto.getInstance().getTreeSameNumLotto() + "개");
        System.out.println("4개 일치 (50,000원) - " + WinningLotto.getInstance().getFourSameNumLotto() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + WinningLotto.getInstance().getFiveSameNumLotto() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + WinningLotto.getInstance().getFiveAndBonusSameNumLotto() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + WinningLotto.getInstance().getSixSameNumLotto() + "개");
    }

    public void winningLottoRateResult(){
        System.out.println("총 수익률은 " + lottoCompareController.winningLottoRate()+"%입니다.");
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
