package lotto.Controller;

import static lotto.View.InputView.getBonusNumber;
import static lotto.View.InputView.getHowMuchLottoWillYouBuy;
import static lotto.View.InputView.getWinningLottoNumbers;
import static lotto.View.OutputView.printLottoList;
import static lotto.util.Generator.generateNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto;

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
    }

    public static List<Lotto> generateLotto(Integer buyCount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<buyCount; i++){
            Lotto lotto = generateNumbers();
            lottoList.add(lotto);
        }
        return lottoList;
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

}
