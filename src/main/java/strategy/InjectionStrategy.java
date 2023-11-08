package strategy;

import domain.Lotto;

import java.util.ArrayList;

public class InjectionStrategy implements LottoStrategy {
    @Override
    public Lotto issueLotto(ArrayList<Integer> numbers) {
        return new Lotto(numbers);
    }

    @Override
    public Integer issueBonus(ArrayList<Integer> numbers, Integer number) {
        return number;
    }
}