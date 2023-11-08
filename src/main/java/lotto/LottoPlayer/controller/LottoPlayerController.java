package lotto.LottoPlayer.controller;

import lotto.Lotto.entity.Lotto;
import lotto.LottoPlayer.dto.WinningStatistic;
import lotto.LottoPlayer.service.LottoPlayerService;
import lotto.LottoPlayer.service.UIService;

import java.util.List;

public class LottoPlayerController {
    UIService uiService = new UIService();
    LottoPlayerService playerService = new LottoPlayerService();

    //로또 구매 기능
    public void buyLotto() {
        // 로또 구입 금액을 입력받는 기능
        int inputMoney = playerService.getMoney();

        //입력된 구입 금액만큼 발행 장 수를 계산하는 기능
        int issuedCount = playerService.calculateLottoCount(inputMoney);

        //입력된 발행 장수만큼 로또를 발행하는 기능
        List<Lotto> issuedLotto = playerService.issueLotto(issuedCount);
        playerService.setIssuedLotto(issuedLotto, issuedCount);

        //발행한 로또 수량을 출력하는 기능
        uiService.printIssuedLottoCount(issuedCount);

        //발행한 로또 번호를 오름차순으로 정렬하는 기능
        List<Lotto> sortedLotto = playerService.sortIssuedLottoAscending(issuedLotto);

        //발행한 로또 번호를 출력하는 기능
        uiService.printIssuedLotto(sortedLotto);

    }

    //당첨 통계 추출 기능
    public void extractStatistics() {
        //사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력하는 기능
        WinningStatistic statistics = playerService.checkWinningStatistic();
        uiService.printStatistics(statistics);

        //총 수익률을 출력하고 게임을 종료하는 기능
        double totalProfitRate = playerService.calculateTotalProfitRate(statistics);
        uiService.printProfitRate(totalProfitRate);
    }





}
