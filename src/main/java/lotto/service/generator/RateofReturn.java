package lotto.service.generator;

import lotto.Controller.PrintScreen;

public class RateofReturn {
    static PrintScreen print = new PrintScreen();

    public static void CalculateRateOfReturn(long winningprice, long buymoney) {
        print.ShowRateofReturn((double) winningprice / buymoney * 100.0);
    }
}
