package lotto.Lotto.controller;

import lotto.Lotto.entity.Lotto;
import lotto.Lotto.service.LottoService;
import lotto.Lotto.service.UIService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final UIService uiService;

    public LottoController() {
        this.uiService = new UIService();
        this.lottoService = new LottoService();
    }

    //당첨 번호 설정 기능
    public void setWinningNumbers() {
        //당첨 번호를 입력받는 기능
        Lotto winningLotto = null;
        try {
            List<Integer> winningNumbers = lottoService.getWinningNumbers();
            winningLotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningNumbers();
        }

        lottoService.setWinningNumbers(winningLotto);

        //보너스 번호를 입력받는 기능
        int bonusNumber = uiService.readLottoNumber((List<Integer>) winningLotto);
        lottoService.setBonusNumber(bonusNumber);
    }
}
