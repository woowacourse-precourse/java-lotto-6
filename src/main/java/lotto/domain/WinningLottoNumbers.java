package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.validate.InputValidation;

public class WinningLottoNumbers {
    private Lotto winningLotto;
    private int bouns;
    InputValidation inputValidation = new InputValidation();

    public WinningLottoNumbers(String numbers, String bouns) {
        this.winningLotto = convertWinningNumbers(numbers);
        this.bouns = convertBonus(bouns);
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

}
