package lotto;

import lotto.message.ExceptionMessage;
import lotto.message.Notification;

import java.util.*;

public class Controller {

    private final Ui ui;
    List<Lotto> lottos = new ArrayList<>();
    Integer numOfLotto;
    Lotto winningLotto;
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

        do { numOfLotto = inputPurchaseAmount();} while(numOfLotto == null);

        initLotto();
        printPurchasedLotto();

        do{ winningLotto = inputWinningNumbers(); } while(winningLotto == null);

        do{ bonusNumber = inputBonusNumber(); } while(bonusNumber == null);

        compareWinningWithLotto();

        String profitRate = calculateProfitRate();
        printResult(profitRate);
    }

    //복권을 구매할 금액 입력
    public Integer inputPurchaseAmount(){

        ui.print(Notification.start.getMessage());
        String input = ui.input();
        return ui.checkPurchaseAmount(input);
    }

    //복권 준비
    public void initLotto(){

        for(int i=0;i<numOfLotto;i++){
            List<Integer> numbers = Lotto.makeLotto();
            try{
                Collections.sort(numbers);
                lottos.add(new Lotto(numbers));
            } catch(IllegalArgumentException e){
                ui.print(ExceptionMessage.lottoNumber.getMessage());
                i--;
            }
        }
    }

    //구매한 복권 출력
    public void printPurchasedLotto(){

        ui.print(numOfLotto+Notification.buy.getMessage());
        for(int i=0;i<numOfLotto;i++){
            ui.print(lottos.get(i).toString());
        }
    }

    //당첨 번호 6개 입력
    public Lotto inputWinningNumbers(){

        ui.print(Notification.inputWinning.getMessage());
        String inputWinning = ui.input();

        return ui.checkWinningInput(inputWinning);
    }

    //보너스 번호 입력
    public Integer inputBonusNumber(){

        ui.print(Notification.inputBonus.getMessage());
        String inputBonus = ui.input();
        return ui.checkBonusInput(inputBonus);
    }

    //당첨 연산
    public void compareWinningWithLotto (){

        for(int i=0;i<numOfLotto;i++){
            int result = lottos.get(i).checkResult(winningLotto.getNumbers(), bonusNumber);
            if(result > 2){
                lottoResults.put(result, lottoResults.get(result)+1);
            }
        }
    }

    //당첨 통계 출력
    public void printResult(String profitRate){

        ui.print(Notification.result.getMessage());
        ui.print(Notification.fifthPlace.getMessage() + lottoResults.get(3) + "개");
        ui.print(Notification.fourthPlace.getMessage() + lottoResults.get(4) + "개");
        ui.print(Notification.thirdPlace.getMessage() + lottoResults.get(5) + "개");
        ui.print(Notification.secondPlace.getMessage() + lottoResults.get(7) + "개");
        ui.print(Notification.firstPlace.getMessage() + lottoResults.get(6) + "개");
        ui.print("총 수익률은 " + profitRate + "%입니다.");
    }

    //수익률 계산
    public String calculateProfitRate(){

        double profit = 0;
        for(int i=0;i<5;i++){
            profit += lottoResults.get(i+3) * prices[i];
        }

        return String.format("%.1f", (profit / (numOfLotto * 1000) * 100));
    }
}
