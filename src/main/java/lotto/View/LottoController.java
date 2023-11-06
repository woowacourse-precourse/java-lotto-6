package lotto.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Config.LottoConfig;
import lotto.Controller.LottoView;
import lotto.Model.Lotto;

public class LottoController {
    private List<Lotto> lottoTicketes;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void startGame() {
        try {
            getPrice();
            getWinningNumbers();
            getBonusNumber();
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
        }
    }

    private void getPrice() {
        try {
            int purchaseAmount = LottoView.promptForPurchaseAmount();
            validateAmount(purchaseAmount);
            lottoTicketes = purchaseLottoTickets(purchaseAmount);
            LottoView.printLottoTickets(lottoTicketes);
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
            getPrice();
        }

    }

    private void getWinningNumbers() {
        try {
            winningNumbers = LottoView.promptForWinningNumbers();
            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
            }
            for (int winningNumber : winningNumbers) {
                validateNumber(winningNumber);
            }
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
            getWinningNumbers();
        }
    }

    private void getBonusNumber() {
        try {
            bonusNumber = LottoView.promptForBonusNumber();
            validateNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
            getBonusNumber();
        }
    }

    private List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        List<Lotto> lottoes = new ArrayList<>();
        int numberOfLotto = purchaseAmount / LottoConfig.PRICE.getValue();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoes.add(generateLotto());
        }
        return lottoes;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private void validateAmount(int amount) {
        if (amount % LottoConfig.PRICE.getValue() != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }

    private void validateNumber(int number) {
        if (number < LottoConfig.MIN_NUMBER.getValue() || number > LottoConfig.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }
}
