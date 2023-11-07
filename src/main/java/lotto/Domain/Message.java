package lotto.Domain;

public enum Message {

        BUY_MESSAGE("구입금액을 입력해 주세요."),
        HOWMANY_LOTTO("개를 구매했습니다."),
        INPUT_WINNER("당첨번호를 입력해주세요."),
        INPUT_BONUS("보너스 번호를 입력해주세요."),
        FIFTH("3개 일치 (5,000원) - "),
        FOURTH("4개 일치 (50,000원) - "),
        THIRD("5개 일치 (1,500,000원) - "),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        FIRST("6개 일치 (2,000,000,000원) - "),
        WINNING_STATISTICS("당첨 통계\n---"),
        TOTAL_RETURN("총 수익률은 ");

        private final String content;

        private Message(String content) {
            this.content = content;
        }
        public String getContent(){
            return this.content;
        }

}
