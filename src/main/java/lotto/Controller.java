package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private final Ui ui;

    private List<Lotto> lottos = new ArrayList<>();
    Integer numOfLotto;

    private List<Integer> winningNumbers = new ArrayList<>();
    Integer bonusNumber;
    Map<Integer, Integer> lottoResults = new HashMap<>();

    private final int [] prices = {5000, 50000, 1500000, 2000000000, 30000000};

    Controller(Ui ui){

        this.ui = ui;
        for(int i=3;i<8;i++){
            lottoResults.put(i, 0);
        }
    }

    public void run(){
        do {
            ui.print(Notification.start.getMessage());
            String input = ui.input();
            numOfLotto = ui.checkPurchaseAmount(input);
        } while(numOfLotto == null);

        for(int i=0;i<numOfLotto;i++){
            List<Integer> numbers = Lotto.makeLotto();
            try{
                lottos.add(new Lotto(numbers));
            } catch(IllegalArgumentException e){
                ui.print(ExceptionMessage.lottoNumber.getMessage());
                i--;
            }
        }

        ui.print(numOfLotto+Notification.buy.getMessage());
        for(int i=0;i<numOfLotto;i++){
            ui.print(lottos.get(i).toString());
        }

        do{
            ui.print(Notification.inputWinning.getMessage());
            String inputWinning = ui.input();
            winningNumbers = ui.checkWinningInput(inputWinning);
        } while(winningNumbers == null);

        do{
            ui.print(Notification.inputBonus.getMessage());
            String inputBonus = ui.input();
            bonusNumber = ui.checkBonusInput(inputBonus);
        } while(bonusNumber == null);

        for(int i=0;i<numOfLotto;i++){
            int result = lottos.get(i).checkResult(winningNumbers, bonusNumber);
            if(result > 2){
                lottoResults.put(result, lottoResults.get(result)+1);
            }
        }

        String profitRate = calculateProfitRate();

        ui.print(Notification.result.getMessage());
        ui.print(Notification.fifthPlace.getMessage() + lottoResults.get(3));
        ui.print(Notification.fourthPlace.getMessage() + lottoResults.get(4));
        ui.print(Notification.thirdPlace.getMessage() + lottoResults.get(5));
        ui.print(Notification.secondPlace.getMessage() + lottoResults.get(7));
        ui.print(Notification.firstPlace.getMessage() + lottoResults.get(6));
        ui.print("총 수익률은" + profitRate + "%입니다");
    }

    public String calculateProfitRate(){

        double profit = 0;
        for(int i=0;i<5;i++){
            profit += lottoResults.get(i+3) * prices[i];
        }

        return String.format("%.1f", (profit / (numOfLotto * 1000) * 100));
    }
}
