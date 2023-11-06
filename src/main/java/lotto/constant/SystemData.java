package lotto.constant;

import lotto.model.WinningCondition;

import java.util.List;

public class SystemData {
    public static final int PURCHASE_AMOUNT_UNIT = 1000;
    public static final int NUMBER_OF_WINNING_NUMBER = 6;
    public static final int NUMBER_OF_BONUS_NUMBER = 1;

    public static final List<WinningCondition> WINNIG_CONDITIONS = List.of(
            new WinningCondition(3,false,5000),
            new WinningCondition(4,false,50000),
            new WinningCondition(5,false,1500000),
            new WinningCondition(5,true,30000000),
            new WinningCondition(6,false,2000000000)
    );
}

