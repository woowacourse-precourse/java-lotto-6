package lotto.domain.proxy;

public class PrizeConfig {
    private final PrizeHandler fiveRank;
    private PrizeConfig() {
        fiveRank = PrizeHandlerImpl.of(3, 5_000, false);
        PrizeHandler fourRank = PrizeHandlerImpl.of(4, 50_000, false);
        PrizeHandler threeRank = PrizeHandlerImpl.of(5, 1_500_000, false);
        PrizeHandler twoRank = PrizeHandlerImpl.of(5, 30_000_000, true);
        PrizeHandler oneRank = PrizeHandlerImpl.of(6, 2_000_000_000, false);

        fiveRank.setNextPrizeHandler(fourRank);
        fourRank.setNextPrizeHandler(threeRank);
        threeRank.setNextPrizeHandler(twoRank);
        twoRank.setNextPrizeHandler(oneRank);
    }

    private static class SingletonHolder {
        private static final PrizeHandler INSTANCE = new PrizeConfig().fiveRank;
    }

    public static PrizeHandler getPrizeHandlerInstance() {
        return SingletonHolder.INSTANCE;
    }

}
