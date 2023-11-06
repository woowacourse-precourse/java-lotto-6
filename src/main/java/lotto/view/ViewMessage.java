package lotto.view;

import lotto.domain.Rank;

enum ViewMessage {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASED_LOTTOS("개를 구매했습니다."),

    OUTPUT_WINNING_STATISTICS("당첨 통계");

    final private String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getPurchasedLottosMessage(int count) {
        return count + OUTPUT_PURCHASED_LOTTOS.message;
    }

    public static String getWinningResultMessage(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            return rank.getMatchCount() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원) - " + count + "개";
        }
        return rank.getMatchCount() + "개 일치(" + rank.getWinningMoney() + "원) - " + count + "개";
    }
}
