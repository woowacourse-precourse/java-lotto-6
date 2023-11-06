package lotto.controller;


import lotto.Service.LottoService;
import lotto.Service.StatisticsService;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    List<String> reward = Arrays.asList("0", "0", "0", "5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000");

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();
    private final StatisticsService statisticsService = new StatisticsService();


    public void startLotto() {
        List<Lotto> lottos = createLottoList();
        List<Integer> winningNum = createWinningNum();
        Integer bonusNum = createBonusNum(winningNum);

        winningStats(lottos, winningNum, bonusNum);
    }

    /**
     * 랜덤으로 n개의 로또 번호를 생성함
     * ex) n = 3일때
     * [6, 9, 14, 20, 28, 32]
     * [6, 8, 15, 32, 36, 44]
     * [1, 13, 17, 21, 27, 38]
     */
    private List<Lotto> createLottoList() {
        Integer price = getPrice();
        return getLottos(price);
    }

    private Integer getPrice() {
        outputView.printLottoAmount();
        return inputView.purchaseLottoAmount();
    }

    private List<Lotto> getLottos(Integer price) {
        outputView.printLottoCount(price);
        List<Lotto> lottos = lottoService.createLotto(price);
        outputView.printLotto(lottos);
        return lottos;
    }

    /**
     * 당첨이 될 로또 번호를 입력 받음
     * ex) [1, 2, 3, 4, 5, 6]
     */
    private List<Integer> createWinningNum() {
        outputView.printWinningNum();
        return inputView.chooseWinningNum();
    }

    /**
     * 보너스 번호를 입력 받음
     * ex) 7
     */
    private Integer createBonusNum(List<Integer> winningNum) {
        outputView.printBonusNum();
        return inputView.chooseBonusNum(winningNum);
    }

    /**
     * 랜덤 로또 번호들, 당첨 로또 번호, 보너스 로또 번호를 가지고 계산을 함
     * matchCountFrequency = 각 등수가 나온 빈도 수
     * ex) matchCountFrequency = [12, 8, 3, 5, 4, 2, 0, 1]
     * -> 1등: 1개, 2등: 0개, 3등: 2개, 4등: 4개, ... 0개 일치: 12개
     * returnRate = 수익률
     * ex) returnRate = 550.0%
     */
    private void winningStats(List<Lotto> lottos, List<Integer> winningNum, Integer bonusNum) {
        outputView.printWinningStatistics();

        List<Integer> matchCountFrequency = statisticsService.winningStats(lottos, winningNum, bonusNum);
        outputView.printMatchNum(matchCountFrequency, reward);

        float returnRate = statisticsService.returnRate(matchCountFrequency, reward);
        outputView.printReturnRate(returnRate);
    }
}
