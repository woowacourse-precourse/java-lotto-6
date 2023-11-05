package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class LottoView {

    private static LottoController lottoController;

    private static final String STARTTEXT = "구입금액을 입력해 주세요.";
    private static final String SHOWTEXT = "개를 구매했습니다.";
    private static final String INPUTNUMBERTEXT = "당첨 번호를 입력해 주세요.";
    private static final String INPUTBONUSTEXT = "보너스 번호를 입력해 주세요.";
    private static final String RATETEXT = "총 수익률은 ";

    LottoView(){
    }

    public void start(){
        lottoController = new LottoController();
        checkMoney();
        purchaceLotto();
        checkWinningNumber();
        checkBonusNumber();
        double rewardRate = lottoController.showLottoReward();
        System.out.println(RATETEXT+rewardRate+"%입니다.");
    }
    private void checkMoney(){
        try {
            System.out.println(STARTTEXT);
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
            System.out.println(lottoController.getMaxRound() + SHOWTEXT);
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
            System.out.println(INPUTNUMBERTEXT);
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
            System.out.println(INPUTBONUSTEXT);
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
}
