package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.controller.InputController;
import lotto.service.NumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInRange(numbers);
        validateNumbersIsDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호만 입력할 수 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public Lotto generateWinnerLotto(InputController inputController) {
        return new Lotto(inputController.inputLottoNumbers());
    }

    public List<Lotto> generatePlayerLotto(InputController inputController) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> playerLotto = new ArrayList<>();
        for (int i = 0; i < Unit.getPurchaseNumber(inputController.inputPurchasePrice())) {
            playerLotto.add(new Lotto(lottoGenerator.generateSixNumbers()));
        }
        return playerLotto;
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        NumberValidator numberValidator = new NumberValidator();
        for (int number : numbers) {
            numberValidator.validateNumberInRange(number);
        }
    }

    private void validateNumbersIsDuplicated(List<Integer> numbers) {
        Set<Integer> copyNumbers = new HashSet<>();
        copyNumbers.addAll(numbers);
        if (copyNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }
}
