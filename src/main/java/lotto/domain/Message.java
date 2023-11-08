package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Message {

    BLANK(""),
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_BUY_MESSAGE("n개를 구매했습니다."),
    PUBLISHED_LOTTO_NUMBER_MESSAGE("[ZERO, ONE, TWO, THREE, FOUR, FIVE]"),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_MESSAGE(
            """
                    당첨 통계
                    ---
                    3개 일치 (5,000원) - THREE개
                    4개 일치 (50,000원) - FOUR개
                    5개 일치 (1,500,000원) - FIVE개
                    5개 일치, 보너스 볼 일치 (30,000,000원) - BONUS개
                    6개 일치 (2,000,000,000원) - SIX개
                    총 수익률은 TOTAL_RETURN%입니다."""
    );

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getBuyMessage(int n) {
        return this.message.replace("n", String.valueOf(n));
    }

    public String getPublishedLottoMessage(List<Integer> lottoNumbers) {
        if (this != PUBLISHED_LOTTO_NUMBER_MESSAGE) {
            return getMessage();
        }
        List<String> numbers = lottoNumbers.stream().map(String::valueOf).toList();

        return this.message
                .replace("ZERO", numbers.get(0))
                .replace("ONE", numbers.get(1))
                .replace("TWO", numbers.get(2))
                .replace("THREE", numbers.get(3))
                .replace("FOUR", numbers.get(4))
                .replace("FIVE", numbers.get(5));
    }

    public String getWinningResultMessage(WinningResult winningResult) {
        if (this != WINNING_RESULT_MESSAGE) {
            return getMessage();
        }

        return this.message
                .replace("THREE", String.valueOf(winningResult.getThreeMatches()))
                .replace("FOUR", String.valueOf(winningResult.getFourMatches()))
                .replace("FIVE", String.valueOf(winningResult.getFiveMatches()))
                .replace("BONUS", String.valueOf(winningResult.getFiveAndBonusMatches()))
                .replace("SIX", String.valueOf(winningResult.getSixMatches()))
                .replace("TOTAL_RETURN", String.valueOf(winningResult.getTotalReturn()));
    }
}