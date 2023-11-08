package lotto.Controller;

import static lotto.Model.Prize.FIFTH;
import static lotto.Model.Prize.FIRST;
import static lotto.Model.Prize.FOURTH;
import static lotto.Model.Prize.SECOND;
import static lotto.Model.Prize.THIRD;
import static lotto.View.InputView.getBonusNumber;
import static lotto.View.InputView.getHowMuchLottoWillYouBuy;
import static lotto.View.InputView.getWinningLottoNumbers;
import static lotto.View.OutputView.printLottoList;
import static lotto.View.OutputView.printLottoResult;
import static lotto.util.Generator.generateNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.Prize;
import lotto.Model.WinningDetails;

public class LottoGame {

    public LottoGame(){
        run();
    }

    public static void run(){
        notifyHowMuchWillYouPay();
        Integer buyCount = getHowMuchLottoWillYouBuy();

        List<Lotto> lottoList = generateLotto(buyCount); //발행된 로또
        printLottoList(buyCount, lottoList);

        notifyWinningNumbers();
        Lotto winningNumbers = getWinningLottoNumbers();

        notifyBonusNumber();
        Integer bonusNumber = getBonusNumber();

        WinningDetails detail = lottoResult(lottoList, winningNumbers, bonusNumber);
        notifyForResult();
        printLottoResult(Double.valueOf(buyCount),detail);
    }

    public static List<Lotto> generateLotto(Integer buyCount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<buyCount; i++){
            Lotto lotto = generateNumbers();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static WinningDetails lottoResult(List<Lotto> lottoList, Lotto winningNumbers, Integer bonusNumber){
        Integer[] result = {0,0,0,0};
        Integer bonus = 0;
        for(int i=0; i<lottoList.size();i++){
            Lotto lotto = lottoList.get(i);
            int cnt = lotto.getMatchLottoNumbers(winningNumbers);
            if(cnt<3)
                continue;
            if(cnt==5 && lotto.getMatchNumber(bonusNumber)){
                bonus += 1;
                continue;
            }
            result[cnt-3]+=1;
        }
        return new WinningDetails(result, bonus);
    }

    private static void notifyHowMuchWillYouPay(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static void notifyWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void notifyBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static void notifyForResult(){
        System.out.println("당첨 통계" + "\n" + "---");
    }

}
