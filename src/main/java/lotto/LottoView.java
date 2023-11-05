package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class LottoView {

    LottoController lottoController;

    private static final String STARTTEXT = "구입금액을 입력해 주세요.";
    private static final String SHOWTEXT = "개를 구매했습니다.";
    private static final String INPUTNUMBERTEXT = "당첨 번호를 입력해 주세요.";
    private static final String INPUTBONUSTEXT = "보너스 번호를 입력해 주세요.";
    private static final String RATETEXT = "총 수익률은 ";

    LottoView(){
    }

    public void start(){
        try {
            lottoController = new LottoController();

            System.out.println(STARTTEXT);
            String pMoney = Console.readLine();
            System.out.println();

            lottoController.setpMoney(Integer.parseInt(pMoney));
            System.out.println(lottoController.getMaxRound() + SHOWTEXT);
            lottoController.startLotto();
            lottoController.showLottos();
            System.out.println();

            System.out.println(INPUTNUMBERTEXT);
            String numbers = Console.readLine();
            System.out.println();

            System.out.println(INPUTBONUSTEXT);
            String bonus = Console.readLine();
            System.out.println();

            lottoController.setLotto(getNumbers(numbers), Integer.parseInt(bonus));
            double rewardRate = lottoController.showLottoReward();
            System.out.println(RATETEXT+rewardRate+"%입니다.");
        }catch(Exception e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }

    private List<Integer> getNumbers(String numbers){
        List<Integer> result = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(numbers,",");
        while(st.hasMoreTokens()){
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }
}
