package lotto.Dto;

import java.util.List;

public class BoughtLottosDto {
    private final List<List<Integer>> myLottosNumber;

    public BoughtLottosDto(List<List<Integer>> myLottosNumber) {
        this.myLottosNumber = myLottosNumber;
    }

    public List<List<Integer>> getMyLottos() {
        return myLottosNumber;
    }

    public int size() {
        return getMyLottos().size();
    }

    ;
}
