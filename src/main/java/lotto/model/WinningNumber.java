package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winNumber;

    public WinningNumber(List<Integer> winNumber) {
        validate(winNumber);
        this.winNumber = winNumber;
    }
    private void validate(List<Integer> winNumber){
        if(winNumber.size() != winNumber.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }
}
