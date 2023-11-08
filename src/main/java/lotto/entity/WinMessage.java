package lotto.entity;

public class WinMessage {
    public enum WinType {
        MATCH_3(3, "3개 일치 (5,000원)"),
        MATCH_4(4, "4개 일치 (50,000원)"),
        MATCH_5(5, "5개 일치 (1,500,000원)"),
        MATCH_5_BONUS(6, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        MATCH_6(7, "6개 일치 (2,000,000,000원)");

        private final int matchCount;
        private final String label;

        WinType(int matchCount, String label) {
            this.matchCount = matchCount;
            this.label = label;
        }



        public String getLabel() {
            return label;
        }
    }
}
