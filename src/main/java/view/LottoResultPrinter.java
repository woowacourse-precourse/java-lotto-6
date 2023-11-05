package view;

import java.util.EnumMap;
import java.util.List;
import model.Rank;

public interface LottoResultPrinter {
    public void printresult(EnumMap<Rank,Integer> result);
    public void printRateOfProfit(String rate);
    public void printHowManyAndLottos(List<Integer[]> computerLottos);
}
