package lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    private static final String LOTTO_PURCHASE_AMOUNT_INPUTMESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_INPUTMESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_INPUTMESSAGE = "보너스 번호를 입력해 주세요.";

    private List<Integer> userWinningRanks;
    private float profitSummary;
    private int lottoPurchaseNum;
    private final String LOTTO_PURCHASE_NUMBERS_OUTPUTMESSAGE = String.format("%d개를 구매했습니다.", lottoPurchaseNum);
    private final String WINNING_STATISTICS_OUTPUTMESSAGE = String.format("""
                당첨 통계
                ---
                3개 일치 (5,000원) - %d개
                4개 일치 (50,000원) - %d개
                5개 일치 (1,500,000원) - %d개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                6개 일치 (2,000,000,000원) - %d개     
            """, userWinningRanks.get(0), userWinningRanks.get(1), userWinningRanks.get(2), userWinningRanks.get(3), userWinningRanks.get(4));
    private final String PROFIT_SUMMARY_OUTPUTMESSAGE = String.format("총 수익률은 %.1f%입니다.", profitSummary);

    public void checklottoPurchaseAmount(String lottoPurchaseAmount){
        try{ //int값인지 확인, int 범위 내 인지 확인
            Integer.parseInt(lottoPurchaseAmount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] int로 정의 될 수 없습니다.");
        }
        if(Integer.parseInt(lottoPurchaseAmount)<1){
            throw new IllegalArgumentException("[ERROR] 음수의 값은 들어올 수 없습니다.");
        }
        if(Integer.parseInt(lottoPurchaseAmount)%1000!=0){
            throw new IllegalArgumentException("[ERROR] 잔돈이 없어서 1000원 단위의 돈만 받을 수 있습니다.");
        }
    }

    public void lottoPurchaseAmountInput(){
        System.out.println(LOTTO_PURCHASE_AMOUNT_INPUTMESSAGE);
        String lottoPurchaseAmount = readLine();
        checklottoPurchaseAmount(lottoPurchaseAmount);
        lottoPurchaseNum = Integer.parseInt(lottoPurchaseAmount);
    }

    public void checkWinningNumber(String winningNumber){
        if (winningNumber.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(String winningnum : winningNumber.split(",")){
            try{
                Integer.parseInt(winningnum);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] int로 정의 될 수 없습니다.");
            }
            if(Integer.parseInt(winningnum)<1 && Integer.parseInt(winningnum)>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> winningNumberInput(){
        System.out.println(LOTTO_WINNING_NUMBER_INPUTMESSAGE);
        String winningNumber = readLine();
        checkWinningNumber(winningNumber);
        List<Integer> winNumberInt = new ArrayList<Integer>();
        for(String winningnum : winningNumber.split(",")){
            winNumberInt.add(Integer.parseInt(winningnum));
        }
        return winNumberInt;
    }

    public void checkbounsNumber(String bonusNumber){
        try{
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] int로 정의 될 수 없습니다.");
        }
        if(Integer.parseInt(bonusNumber)<1 && Integer.parseInt(bonusNumber)>45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    
    public int bonusNumberInput(){
        System.out.println(LOTTO_BONUS_NUMBER_INPUTMESSAGE);
        String bounsNumber = readLine();
        checkbounsNumber(bounsNumber);
        return Integer.parseInt(bounsNumber);
    }

    public void setUserWinningRanks(List<Integer> userWinningRanks){
        this.userWinningRanks = userWinningRanks;
    }

    public void setProfitSummary(float profitSummary){
        this.profitSummary = profitSummary;
    }

    public int getLottoPurchaseNum(){
        return lottoPurchaseNum;
    }


    public void lottoPurchaseNumbersOutput(ArrayList<Lotto> userLottos){
        System.out.println(LOTTO_PURCHASE_NUMBERS_OUTPUTMESSAGE);
        for(Lotto lotto : userLottos){
            System.out.println(lotto.getNumbers().toString());
        }
    }
    
    public void winningStatisticsOutput(){
        System.out.println(WINNING_STATISTICS_OUTPUTMESSAGE);
    }
    
    public void profitSummaryOutput(){
        System.out.println(PROFIT_SUMMARY_OUTPUTMESSAGE);
    }
}
