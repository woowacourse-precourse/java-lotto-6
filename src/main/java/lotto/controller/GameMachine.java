package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMachine {

    private final LottoNumbers lottoNumbers;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine() {
        this.lottoNumbers = new RandomLottoNumbers();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        // 사용자가 구입 금액 입력 , 1000으로 나눈다.
        int inputPrice = getInputPrice();
        int count = getCount(inputPrice);

        // 로또 번호 출력 -> 리팩토링
        outputView.lottoPurchaseCountMessage(count);
        Lottos lottos = new Lottos(count, lottoNumbers);
        outputView.lottoNumbersMessage(lottos);

        // 사용자가 당첨 번호 6자리를 입력.
        Lotto winningNumbers = getWinningNumbers();

        // 보너스 번호 입력
        int inputBonusNumber = getBonusNumber(winningNumbers);

        // 사용자와 번호 비교
        lottos.compareWithWinningNumbers(winningNumbers, inputBonusNumber);
        // 당첨 통계, 수익률 출력
        outputView.winningHistoryMessage();
        outputView.TotalReturnRateMessage(inputPrice);
    }

    private int getInputPrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");

            try {
                int inputPrice = parseAndValidateInput(inputView.inputPrice());
                validatePurchaseAbility(inputPrice);
                return inputPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getCount(int inputPrice) {
        return inputPrice / 1000;
    }


    private Lotto getWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            try {
                List<Integer> inputWinningNumbers = inputView.inputWinningNumbers();
                return new Lotto(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                int inputBonusNumber = inputView.inputBonusNumber();
                duplicationBonusNumber(winningNumbers.getNumbers(), inputBonusNumber);
                return inputBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidateInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 옳바른 금액을 입력해주세요.");
        }
    }

    private void validatePurchaseAbility(int inputPrince) {
        if (inputPrince < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족하여 로또를 살 수 없습니다.");
        }
    }

    private void duplicationBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

}