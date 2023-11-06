package lotto.domain;

public enum LottoRanking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FORTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    OTHER(0,0,"");

    private static final Integer MINIMUM_WINNING_COUNT = 3;
    private final Integer countLottoMatched;
    private final Integer winningMoney;
    private final String winningMessage;

    LottoRanking(Integer countLottoMatched, Integer winningMoney, String winningMessage){
        this.countLottoMatched = countLottoMatched;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    private Integer getCountLottoMatched() {
        return countLottoMatched;
    }

    private Integer getWinningMoney() {
        return winningMoney;
    }

    private String getWinningMessage() {
        return winningMessage;
    }

    public Integer getCountAboutLotto(Lotto winningLotto, Lotto playerLotto){
        return winningLotto.countMatchedOtherLotto(playerLotto);
    }

    public Boolean getIsMatchBonus(Lotto winningLotto, )
    public LottoRanking getRanking(Integer countAboutLotto, Boolean isMatchBonus){
        if(countAboutLotto < MINIMUM_WINNING_COUNT){
            return OTHER;
        }
        for(LottoRanking ranking : values()){
            if(countAboutLotto.equals(ranking.getCountLottoMatched())){
                return ranking;
            }
        }
    }
}
