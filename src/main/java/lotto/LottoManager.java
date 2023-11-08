package lotto;

import java.util.function.Function;

public enum LottoManager{
    CALC_1(value -> value * 2000000000),
    CALC_2(value -> value * 30000000),
    CALC_3(value -> value * 1500000),
    CALC_4(value -> value * 50000),
    CALC_5(value -> value * 5000),
    CALC_0(value -> 0);

    private final Function<Integer, Integer> expression;
    LottoManager(Function<Integer, Integer> expression){ this.expression = expression; }
    public int calculate(int value){return expression.apply(value);}
}