package controller;

import static util.ConstantUtil.DIVIDE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import model.LottoResult;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public void startGame() {
        outputView.userInputPayNumber();
        int cost = inputView.inputPayNumber()/DIVIDE;


        List<Lotto> lottos = pickRandomNumbers(cost);
        outputView.userPurchaseNumber(cost, lottos);

        outputView.printWinnerNumber();
        List<Integer> winnerNumber = inputView.inputWinnerNumber();
        outputView.printInputBonusNumber();
        int bonusNumber = inputView.inputBonusNumber();

        getUserResult(lottos, winnerNumber, bonusNumber);
        outputView.printResultGame();
    }

    public List<Lotto> pickRandomNumbers(int cost) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i=0; i<cost; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public void getUserResult(List<Lotto> lottos, List<Integer> winnerNumber, int bonusNumber) {

        for(Lotto lotto: lottos) {
            int correctCount = compareMyLotto(lotto, winnerNumber);
        }
    }

    private int compareMyLotto(Lotto lotto, List<Integer> winnerNumber) {
        List<Integer> correctNumber = lotto.getNumbers().stream()
            .filter(myLotto -> winnerNumber.contains(myLotto))
            .toList();
        return correctNumber.size();
    }
}
