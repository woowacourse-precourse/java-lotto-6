package lotto.Model.WinningNumber;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> numbers){
        this.winningNumber = numbers;
    }

    public List<Integer> getWinningNumber(){
        return this.winningNumber;
    }

    /**
     * 입력 검증 목록
     *
     */
}
