package controller;


import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningStatus;
import service.GenerateLotto;

public class LottoController {
    private final UserController userController = new UserController();
    private final GenerateLotto generateLotto = new GenerateLotto();
    public void start(){

        //사용자에게 로또 구매 금액 입력받기
        int userInput = userController.enterPurchaseAmount();

        //구매 금액만큼 로또 생성
        List<Lotto> lottoList = generateLotto.generateLottoList(userInput);

        // 당첨번호, 보너스 번호 입력 (숫자인지 1 ~ 45 사이의 값, 중복 존재 확인)
        List<Integer> winnerLotto = userController.enterLottoNumbers();
        int bonus = userController.enterBonus();

        // 로또 번호 & 당첨 번호 비교 => 당첨 내역 체크
        Map<WinningStatus, Integer> statistics = generateLotto.winningStatistics(lottoList, winnerLotto, bonus);

        //당첨률 확인
        generateLotto.rateOfReturn(statistics, userInput);

    }



}
