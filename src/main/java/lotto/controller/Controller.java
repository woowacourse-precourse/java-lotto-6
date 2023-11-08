package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.ResultMaker;
import lotto.domain.SelectedBonus;
import lotto.domain.SelectedLotto;
import lotto.domain.SelectedNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private LottoBundle lottoBundle;
    private ResultMaker resultMaker;

    public void run() {
        buyLotto();
        showYourLotto();
        checkLotto();
        Console.close();
        showYourResult();
        showYourRateOfReturn();
    }

    /**
     * 로또 구매 메서드
     * <p>
     * 입력 금액에 맞는 로또 묶음(LottoBundle)을 생성
     */
    private void buyLotto() {
        while (true) {
            try {
                LottoMachine lottoMachine = new LottoMachine(inputView.readMoney());
                lottoBundle = lottoMachine.makeLottoBundle();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showYourLotto() {
        outputView.printLottos(lottoBundle.getBundle());
    }

    /**
     * 결과 비교 메서드
     * <p>
     * 로또 묶음과 당첨 로또를 비교 하고 ResultMaker 객체를 업데이트함.
     */
    private void checkLotto() {
        resultMaker = new ResultMaker(lottoBundle, selectWinningLotto());
        resultMaker.updateResult();
    }

    /**
     * 당첨 로또 생성
     *
     * @return 당첨 로또 반환
     */
    private SelectedLotto selectWinningLotto() {
        SelectedNumbers nums = selectNumbers();
        SelectedBonus bonus = selectBonus(nums);
        return new SelectedLotto(nums, bonus);
    }

    private SelectedNumbers selectNumbers() {
        while (true) {
            try {
                return new SelectedNumbers(inputView.readSelectedNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private SelectedBonus selectBonus(SelectedNumbers selectedNumbers) {
        while (true) {
            try {
                return new SelectedBonus(inputView.readSelectedBonus(),
                        selectedNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showYourResult() {
        Map<Rank, Integer> lottoResult = resultMaker.giveResult();
        outputView.printResult(lottoResult);
    }

    private void showYourRateOfReturn() {
        String rateOfReturn = resultMaker.calculateRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }


}
