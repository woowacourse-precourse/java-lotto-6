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
        isDuplicateNumbers(numbers);
        this.winningLotto = convertWinningNumbers(numbers);
        this.bonus = convertBonus(bouns);
    }

    private Lotto convertWinningNumbers(String numbers) {
        return new Lotto(Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
    private int convertBonus(String bonus) {
        return Integer.parseInt(bonus);
    }
    // 중복된 당첨번호
    public void isDuplicateNumbers(String numbers) {
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        inputValidation.isDuplicate(numberList);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
