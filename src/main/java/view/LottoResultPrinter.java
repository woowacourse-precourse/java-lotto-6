package view;

import java.util.List;

public interface LottoResultPrinter {
    public void printresult(int[] result);
    public void printRateOfProfit(String rate);
    public void printHowManyAndLottos(List<Integer[]> computerLottos);
}
