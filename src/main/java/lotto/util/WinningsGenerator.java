package lotto.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningsGenerator {
    public static Map<Integer, String> createWinnings() {
        Map<Integer, String> winnings = new LinkedHashMap<>();
        winnings.put(2_000_000_000, "2,000,000,000");
        winnings.put(30_000_000, "30,000,000");
        winnings.put(1_500_000, "1,500,000");
        winnings.put(50_000, "50,000");
        winnings.put(5_000, "5,000");
        return winnings;
    }
}
