package lotto.Dto;

import java.util.List;

public class MyLottosDto {
    private final List<List<Integer>> myLottosNumber;

    public MyLottosDto(List<List<Integer>> myLottosNumber) {
        this.myLottosNumber = myLottosNumber;
    }

    public List<List<Integer>> getMyLottosNumber() {
        return myLottosNumber;
    }
}
