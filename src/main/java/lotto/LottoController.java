package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoController {
    private int money;
    private final List<Lotto> lottos;
    private WinningLotto winningLotto;
    private final OutputView outputView;

    public LottoController() {
        this.lottos = new ArrayList<>();
        this.outputView = new OutputView();
    }

    public void inputPurchaseMoney() {
        do {
            money = Integer.parseInt(Console.readLine());
        } while (validMoneyInput());
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
        final int bonusNumber = inputWinningLottoBonusNumber();
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);

    }

    private List<Integer> inputWinningLottoNumbers() {
        List<Integer> winningNumbers;
        do {
            final String inputNumbers = Console.readLine().trim();
            final List<String> splitInput = List.of(inputNumbers.split(","));
            winningNumbers = splitInput.stream()
                    .map(Integer::parseInt)
                    .toList();
        } while(validateWinningNumbers(winningNumbers));

        return winningNumbers;
    }

    private int inputWinningLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());

    }

    private boolean validMoneyInput() {
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
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개이어야 합니다.");
        }
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumbersBoundary(final List<Integer> numbers) {
        final boolean isBoundary = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (isBoundary) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다.");
        }
    }
}
