package lotto.dto;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class WinningTierResponseDto {

    private final Map<Integer, WinningResponseDto> winningResponseMap;

    private WinningTierResponseDto(Map<Integer, WinningResponseDto> winningResponseMap) {
        this.winningResponseMap = new TreeMap<>(Comparator.reverseOrder());
        this.winningResponseMap.putAll(winningResponseMap);
    }

    public static WinningTierResponseDto of(Map<Integer, WinningResponseDto> winningResponseMap) {
        return new WinningTierResponseDto(winningResponseMap);
    }

    public Map<Integer, WinningResponseDto> getWinningResponseMap() {
        return winningResponseMap;
    }
}
