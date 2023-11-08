package lotto;

import lotto.Input;

import java.util.List;

public class LottoGame {
    public void run() {
        Input input = new Input();
        Output output = new Output();
        int userCash = input.getUserCash();
        int lottoCount = userCash / 1000;
        output.showLottoCount(lottoCount);
        LottoGroup lottoGroup = new LottoGroup(lottoCount);//개수만큼 로또 그룹생성
        output.showLottoGroupNum(lottoGroup); //그룹생성한거 보여주기
        List<Integer> lottoWinnerNumList = input.printWinnerNum(); // 당첨번호 받고
        int bonusNum = input.printBonusNum(); // 보너스 번호 받고
        LottoWinnerNum lottoWinnerNum = new LottoWinnerNum(lottoWinnerNumList, bonusNum);//위에 두개 묶고
        LottoCheckResult lottoCheckResult = new LottoCheckResult();
        LottoCheck lottoCheck = new LottoCheck(lottoCheckResult,lottoGroup, lottoWinnerNum);//체크객체 생성
        lottoCheck.showLottoCheckResult();//몇개 맞았는지 보여줌.
        output.showLottoCheckPrice(lottoCheck, userCash);//수익률 보여줌
    }
}
