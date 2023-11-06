package lotto.controller;


import lotto.Service.LottoService;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();


    public void startLotto() {
        List<Lotto> lottos = createLottoList();
        List<Integer> winningNum = createWinningNum();
        Integer bonusNum = createBonusNum(winningNum);
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
}
