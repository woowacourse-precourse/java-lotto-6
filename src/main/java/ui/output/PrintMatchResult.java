package ui.output;

import java.util.Map;

class PrintMatchResult {
    public static void printMatchResult(Map<Integer, Long> matchCounts, int matchCount, String prize) {
        long count = matchCounts.getOrDefault(matchCount, 0L);
        System.out.println(matchCount + "개 일치 " + prize + " - " + count + "개");
    }
}

