package lotto.controller;

import java.util.List;

public class Judgment {
    public int correctCount(List<Integer> computer, List<Integer> buyer){
        computer.retainAll(buyer);
        return computer.size();
    }
}
