package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.validate.InputValidation;

public class WinningLottoNumbers {
    private Lotto winningLotto;
    private int bonus;
    InputValidation inputValidation = new InputValidation();

    public WinningLottoNumbers(String numbers, String bouns) {
        validateWinningNumbers(numbers);
        isDuplicateNumbers(numbers);
        this.winningLotto = convertWinningNumbers(numbers);

        validateBonusNumber(bouns);
        this.bonus = convertBonus(bouns);
    }

    // 담첨번호 String > List<Integer>
    private Lotto convertWinningNumbers(String numbers) {
        return new Lotto(Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
    // 보너스번호 String > int
    private int convertBonus(String bonus) {
        return Integer.parseInt(bonus);
    }
    // 당첨번호 validate
    public void validateWinningNumbers(String numbers) {
        inputValidation.isNumber(numbers);
        inputValidation.isNumbersDivied6NumbersWithComma(numbers);
    }
    // 중복된 당첨번호
    public void isDuplicateNumbers(String numbers) {
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed() // IntStream을 Stream<Integer>로 변환
                .collect(Collectors.toList());

        inputValidation.isDuplicate(numberList);
    }
    // 보너스번호 validate
    public void validateBonusNumber(String bonus) {
        inputValidation.isNumber(bonus);
        inputValidation.isNullOrBlank(bonus);
        validateDuplicate(Integer.parseInt(bonus));
    }
    // 당첨번호와의 중복 체크
    public void validateDuplicate(int bonus) {
        winningLotto.getNumbers().contains(bonus);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
