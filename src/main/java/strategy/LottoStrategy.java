package strategy;

import domain.Lotto;

import java.util.ArrayList;

public interface LottoStrategy {
    public Lotto issueLotto(ArrayList<Integer> numbers);
    public Integer issueBonus(ArrayList<Integer> numbers, Integer number);
}