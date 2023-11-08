package lotto.domain.proxy;

import java.util.ArrayList;
import java.util.List;

public final class PrizeConfig {
    private static final List<Integer> MATCHING_NUMBERS = List.of(3, 4, 5, 5, 6);
    private static final List<Integer> PRIZE_AMOUNT = List.of(5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000);
    private static final List<Boolean> IS_BONUS = List.of(false, false, false, true, false);
    private static final int PRICE_KIND = 5;
    private final PrizeHandler firstChainPrizeType;
    private PrizeConfig() {
        List<PrizeHandler> prizeHandlers = new ArrayList<>(PRICE_KIND);

        initPrizeTypes(prizeHandlers);

        setupPrizeTypes(prizeHandlers);

        firstChainPrizeType = prizeHandlers.get(0);
    }

    private void setupPrizeTypes(List<PrizeHandler> prizeHandlers) {
        for(int i = 0; i < PRICE_KIND - 1; i++) {
            prizeHandlers.get(i).setNextPrizeHandler(prizeHandlers.get(i + 1));
        }
    }

    private void initPrizeTypes(List<PrizeHandler> prizeHandlers) {
        for (int i = 0; i < PRICE_KIND; i++) {
            prizeHandlers.add(PrizeHandlerImpl.of(MATCHING_NUMBERS.get(i), PRIZE_AMOUNT.get(i), IS_BONUS.get(i)));
        }
    }

    private static class SingletonHolder {
        private static final PrizeHandler INSTANCE = new PrizeConfig().firstChainPrizeType;
    }

    public static PrizeHandler getPrizeHandlerInstance() {
        return SingletonHolder.INSTANCE;
    }

}
