package lotto.Controller;

import lotto.Model.Domain.Lotto;
import lotto.Model.Enums.Prices;
import org.mockito.internal.matchers.Null;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultController extends Controller{
    HashMap<String, Integer> resultPlaces;
    List<Lotto> clientLottos;
    List<Integer> winningNumber;
    int winningBonusNumber;
    int prize;
    public ResultController(List<Lotto> clientLottos, List<Integer> winningNumber, int winningBonusNumber){
        resultPlaces = new HashMap<>();
        resultPlaces.put(Prices.LOSE.name(), 0);
        resultPlaces.put(Prices.WIN_1ST.name(), 0);
        resultPlaces.put(Prices.WIN_2ND.name(), 0);
        resultPlaces.put(Prices.WIN_3RD.name(), 0);
        resultPlaces.put(Prices.WIN_4TH.name(), 0);
        resultPlaces.put(Prices.WIN_5TH.name(), 0);
        this.clientLottos = clientLottos;
        this.winningNumber = winningNumber;
        this.winningBonusNumber = winningBonusNumber;
    }
    @Override
    public void run(){
        calculateResultPlaces(clientLottos, winningNumber, winningBonusNumber);
        prize = calculateTotalPrize(resultPlaces);
    }
    private String calculatePlace(Lotto lotto, List<Integer> winningNumber, int winningBonusNumber){
        int hitAmount = lotto.compareWithWinningNumber(winningNumber);
        if (hitAmount < 3){
            return Prices.LOSE.name();
        }if (hitAmount == 6){
            return Prices.WIN_1ST.name();
        }if (hitAmount == 5){
            if (lotto.compareWithWinningBonusNumber(winningBonusNumber)){
                return Prices.WIN_2ND.name();
            }
            return Prices.WIN_3RD.name();
        }if (hitAmount == 4){
            return Prices.WIN_4TH.name();
        }if (hitAmount == 3){
            return Prices.WIN_5TH.name();
        }if (hitAmount > 6){
            return "Error"; // error handling
        }
        return "";
    }
    private void calculateResultPlaces(List<Lotto> clientLottos, List<Integer> winningNumber, int winningBonusNumber){
        for (Lotto lotto : clientLottos){
            String lottoPlace = calculatePlace(lotto, winningNumber, winningBonusNumber);
            int placeAmount = resultPlaces.get(lottoPlace);
            resultPlaces.put(lottoPlace, ++placeAmount);
        }
    }
    private int calculateTotalPrize(HashMap<String, Integer> resultPlaces) {
        int totalPrize = 0;
        for (Map.Entry<String, Integer> entry : resultPlaces.entrySet()) {
            String place = entry.getKey();
            int value = entry.getValue();
            Prices price = Prices.valueOf(place);
            totalPrize += price.intValue() * value;
        }
        return totalPrize;
    }
}
