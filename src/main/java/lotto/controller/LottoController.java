package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);

        resultView.printLottos(lottos);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        LottoResult lottoResult = getLottoResult(lottos, winningLotto);

        resultView.printResult(lottoResult, purchaseAmount);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = inputView.getPurchaseAmount();
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.getWinningNumbers();
                if (winningNumbers.size() != 6 || !isValidNumbers(winningNumbers)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
                }
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.getBonusNumber();
                if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isValidNumbers(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45) && numbers.size() == new HashSet<>(numbers).size();
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = purchaseAmount / 1000;

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = LottoMachine.generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private LottoResult getLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = calculateResult(lottos, winningLotto);
        return new LottoResult(result);
    }

    private Map<Rank, Integer> calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            if (rank != Rank.MISS) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }
        return result;
    }
}
