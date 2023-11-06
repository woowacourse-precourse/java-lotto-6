package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class LottoView {

    private static LottoController lottoController;
    private Text text;

    LottoView(){
    }

    public void start(){
        lottoController = new LottoController();
        checkMoney();
        purchaceLotto();
        checkWinningNumber();
        checkBonusNumber();
        double rewardRate = showReward();
        System.out.println(text.RATE1.getText()+rewardRate+text.RATE2.getText());
    }
    private void checkMoney(){
        try {
            System.out.println(text.START);
            String pMoney = Console.readLine();
            lottoController.setpMoney(Integer.parseInt(pMoney));
            System.out.println();
        }catch(IllegalArgumentException e){
            String message = e.getMessage();
            if(message.contains("For input string"))
                message = "숫자를 입력해야 합니다";
            System.out.println("[ERROR] "+message);
            checkMoney();
        }
    }
    private void purchaceLotto(){
        try{
            System.out.println(lottoController.getMaxRound() + text.SHOW.getText());
            lottoController.startLotto();
            lottoController.showLottos();
            System.out.println();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
            purchaceLotto();
        }
    }
    private void checkWinningNumber(){
        try{
            System.out.println(text.INPUTNUMBER);
            String numbers = Console.readLine();
            lottoController.setLotto(getNumbers(numbers));
            System.out.println();
        }catch(IllegalArgumentException e){
            String message = e.getMessage();
            if(message.contains("For input string"))
                message = "당첨번호는 숫자여야 합니다.";
            System.out.println("[ERROR]"+message);
            checkWinningNumber();
        }
    }
    private void checkBonusNumber(){
        try{
            System.out.println(text.INPUTBONUS);
            String bonus = Console.readLine();
            lottoController.setLotto(Integer.parseInt(bonus));
            System.out.println();
        }catch(IllegalArgumentException e){
            String message = e.getMessage();
            if(message.contains("For input string"))
                message = "숫자를 입력해야 합니다";
            System.out.println("[ERROR] "+message);
            checkBonusNumber();
        }
    }
    private List<Integer> getNumbers(String numbers){
        List<Integer> result = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(numbers,",");
        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());
            validate(result,number);
            result.add(number);
        }
        return result;
    }
    private void validate(List<Integer> item, int number){
        if(item.contains(number))
            throw new IllegalArgumentException("보너스번호는 당첨번호와 다른 숫자여야 합니다.");
        if(number<=0||number>45)
            throw new IllegalArgumentException("보너스번호는 1이상 45이하의 숫자여야 합니다.");
    }

    private double showReward(){
        System.out.println(text.SHOWRESULT);
        System.out.println(text.DIVIDER);
        return lottoController.showLottoReward();
    }
}
