package lotto.views;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.configs.Constant;
import lotto.configs.Prize;
import lotto.models.Lotto;

public class GameView {
    private InputView inputView;
    private OutputView outputView;
    public GameView(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public int purchaseAmountView(){
        outputView.printGetPurchaseAmount();
        while(true){
            try{
                String input = inputView.readPurchaseAmount();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void lotteriesView(List<Lotto> lotteries){
        outputView.printLotteries(lotteries);
    }

    public Lotto winningNumberView(){
        outputView.printGetWinningNumber();
        while(true){
            try{
                String input = inputView.readWinningNumber();
                return new Lotto(
                        Arrays.stream(input.split(Constant.COMMA))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int bonusView(Lotto lotto) {
        outputView.printGetBonusNumber();
        while(true){
            try{
                String input = inputView.readBonusNumber(lotto);
                return Integer.parseInt(input);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void statisticView(HashMap<Prize, Integer> prizes){
        outputView.printPrizes(prizes);
    }

    public void resultView(int useMoney, int payMoney){
        outputView.printResult((double) payMoney / useMoney * 100);
    }
}
