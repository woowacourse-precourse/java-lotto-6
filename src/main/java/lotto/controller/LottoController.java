package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Referee;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.OutputView;

public class LottoController {
    private int money;
    private final List<Lotto> lottos;
    private WinningLotto winningLotto;
    private final OutputView outputView;
    private final Referee referee;

    public LottoController() {
        this.lottos = new ArrayList<>();
        this.outputView = new OutputView();
        this.referee = new Referee();
    }

    public void inputPurchaseMoney() {
        do {
            money = Integer.parseInt(Console.readLine());
        } while (validateMoneyInput());
    }

    public void createLottos() {
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto newLotto = new Lotto(numbers);
            lottos.add(newLotto);
        }
        outputView.printCreateLottoNumbers(lottos);
    }

    public void createWinningLotto() {
        final List<Integer> winningNumbers = inputWinningLottoNumbers();
        final int bonusNumber = inputWinningLottoBonusNumber(winningNumbers);
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public void getPrizeList() {
        referee.judge(lottos, winningLotto);
        System.out.println(referee);
        double rateOfReturn = referee.getRateOfReturn(lottos.size() * 1000);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    private List<Integer> inputWinningLottoNumbers() {
        List<Integer> winningNumbers;
        do {
            final String inputNumbers = Console.readLine().trim();
            final List<String> splitInput = List.of(inputNumbers.split(","));
            winningNumbers = splitInput.stream()
                    .map(Integer::parseInt)
                    .toList();
        } while (validateWinningNumbers(winningNumbers));

        return winningNumbers;
    }

    private int inputWinningLottoBonusNumber(final List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input;
        int bonusNumber;
        do {
            input = Console.readLine();
        } while (validateWinningBonusNumber(winningNumbers, input));
        bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }

    private boolean validateMoneyInput() {
        try {
            if (money == 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 0원일 수 없습니다. 다시 입력하세요.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다. 다시 입력하세요.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private boolean validateWinningNumbers(final List<Integer> numbers) {
        try {
            validateNumbersSize(numbers);
            validateDuplicateNumber(numbers);
            validateNumbersBoundary(numbers);
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        }
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개이어야 합니다. 다시 입력하세요.");
        }
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다. 다시 입력하세요.");
        }
    }

    private void validateNumbersBoundary(final List<Integer> numbers) {
        final boolean isBoundary = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (isBoundary) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다. 다시 입력하세요.");
        }
    }

    private boolean validateWinningBonusNumber(final List<Integer> winningNumbers, final String input) {
        try {
            validateBlankInput(input);
            validateNumberFormat(input);
            validateDuplicateBonusNumber(winningNumbers, input);
            validateBonusNumberBoundary(input);
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        }
    }

    private void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 공백이어선 안됩니다. 다시 입력하세요.");
        }
    }

    private void validateNumberFormat(final String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자이어야 합니다. 다시 입력하세요.");
        }
    }

    private void validateDuplicateBonusNumber(final List<Integer> winningNumbers, final String input) {
        final int bonusNumber = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력하세요.");
        }
    }

    private void validateBonusNumberBoundary(final String input) {
        final int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println(5);
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자입니다. 다시 입력하세요.");
        }
    }
}