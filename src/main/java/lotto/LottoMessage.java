package lotto;

enum LottoMessage {
    THREE("3개 일치 (5,000원)", 5000),
    FOUR("4개 일치 (50,000원)", 50000),
    FIVE("5개 일치 (1,500,000원)", 1500000),
    BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX("6개 일치 (2,000,000,000원)", 2000000000);
    final String message;
    final int winningAmount;
    LottoMessage(final String message, final int winningAmount){
        this.message = message;
        this.winningAmount = winningAmount;
    }
}

