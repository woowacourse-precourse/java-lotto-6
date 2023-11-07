package lotto.dto;

import java.util.List;

public class WinningBundleDto {

    private final List<Integer> winningsBundleResult;

    private WinningBundleDto(List<Integer> winningsBundleResult) {
        this.winningsBundleResult = winningsBundleResult;
    }

    public static WinningBundleDto from(List<Integer> winningBundle) {
        return new WinningBundleDto(winningBundle);
    }

    public List<Integer> getWinningsBundleResult() {
        return winningsBundleResult;
    }
}
