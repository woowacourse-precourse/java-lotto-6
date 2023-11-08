package lotto.Lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Input.Input;
import lotto.Print.Print;
import lotto.Result.Result;
import lotto.Result.WinningResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    public static void run(){
        //로또 개수 구하기
        int lottoBuyCount = Input.getLottoBuyCount();
        List<Lotto> paidLottos = LottoGame.getPaidLottoNumbers(lottoBuyCount);
        Print.printPaidLottoResult(paidLottos,lottoBuyCount);
        WinningLotto winningLotto = LottoGame.getWinningLotto();
        List<WinningResult> winningResults = Result.calcWinningLottoResult(winningLotto,paidLottos);
        Map<WinningResult,Integer> winningResultCountMap = Result.getWinningResultCountMap(winningResults);
        Print.printWinningResult(winningResultCountMap,lottoBuyCount);
    }

    //구입한 로또 리스트 구하기
    public static List<Lotto> getPaidLottoNumbers(int lottoBuyCount){
        List<Lotto> paidLottoNumbers = new ArrayList<>();
        for(int i=0;i<lottoBuyCount;i++){
            paidLottoNumbers.add(getRandomLottoNumber());
        }
        return paidLottoNumbers;
    }

    //랜덤 로또 번호 구하기
    public static Lotto getRandomLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    //로또 당첨 번호와 보너스번호를 한 클래스로 받는 메서드
    public static WinningLotto getWinningLotto(){
        Lotto winnigNumbers = Input.getWinningLottoNumbers();
        int bonusNumber = Input.getBonusNumber();
        return new WinningLotto(winnigNumbers,bonusNumber);
    }
}
