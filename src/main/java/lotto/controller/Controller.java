package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.ResultMaker;
import lotto.domain.SelectedLotto;
import lotto.util.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    LottoValidator validator = new LottoValidator();
    private LottoBundle lottoBundle;
    private ResultMaker resultMaker;

    public Controller() {
    }

    public void run() {
        buyLotto();
        showYourLotto();
        checkLotto();
        showYourResult();
    }

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

    private void showYourResult() {
        Map<Rank, Integer> lottoResult = resultMaker.giveResult();
        outputView.printResult(lottoResult);
    }

    private void checkLotto() {
        resultMaker = new ResultMaker(lottoBundle, selectWinningLotto());
        resultMaker.updateResult();
    }

    private SelectedLotto selectWinningLotto() {
        String nums = selectNumbers();
        String bonus = chooseBonus(makeSplittedNumbers(nums));
        return new SelectedLotto(nums, bonus);
    }

    private String selectNumbers() {
        String nums = "";
        while (true) {
            try {
                nums = inputView.readSelectedNumbers();
                List<String> splitted = makeSplittedNumbers(nums);
                validator.lottoNumbers(splitted);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return nums;
    }

    private String chooseBonus(List<String> splitted) {
        String bonus = "";
        while (true) {
            try {
                bonus = inputView.readSelectedBonus();
                validator.bonusNumber(bonus, splitted);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

    private List<String> makeSplittedNumbers(String InputNumbers) {

        List<String> numbers = Arrays.asList(InputNumbers.split(",", -1));
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i).trim());
        }
        return numbers;
    }
}
