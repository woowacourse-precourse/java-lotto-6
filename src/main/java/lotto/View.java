package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    private Map<Integer, Integer> userWinningRanks;
    private double profitSummary;
    private int lottoPurchaseNum;
    private String winningNumber;
    private String bounsNumber;

    public enum InputMassage{
        LOTTO_PURCHASE_AMOUNT_INPUTMESSAGE("구입금액을 입력해 주세요."),
        LOTTO_WINNING_NUMBER_INPUTMESSAGE("당첨 번호를 입력해 주세요."),
        LOTTO_BONUS_NUMBER_INPUTMESSAGE("보너스 번호를 입력해 주세요.");

        final private String message;
        public String getMessage() {
            return message;
        }
        InputMassage(String message){
            this.message = message;
        }
    }

    public void checklottoPurchaseAmount(String lottoPurchaseAmount){
        if (lottoPurchaseAmount == null){
            throw new IllegalArgumentException("[ERROR] 값을 입력하여야 합니다.");
        }
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
        System.out.println(InputMassage.LOTTO_PURCHASE_AMOUNT_INPUTMESSAGE.getMessage());
        boolean reTry=true;
        String lottoPurchaseAmount = null;
        while(reTry) {
            try {
                lottoPurchaseAmount = readLine();
                checklottoPurchaseAmount(lottoPurchaseAmount);
                reTry = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            lottoPurchaseNum = Integer.parseInt(lottoPurchaseAmount) / 1000;
        }
    }

    public void checkWinningNumber(String winningNumber){
        if (winningNumber == null){
            throw new IllegalArgumentException("[ERROR] 값을 입력하여야 합니다.");
        }
        if (winningNumber.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(String winningnum : winningNumber.split(",")){
            try{
                Integer.parseInt(winningnum);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] int로 정의 될 수 없습니다.");
            }
            if(Integer.parseInt(winningnum)<1 || Integer.parseInt(winningnum)>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (Collections.frequency(Arrays.asList(winningNumber.split(",")), winningnum) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    public List<Integer> winningNumberInput(){
        System.out.println(InputMassage.LOTTO_WINNING_NUMBER_INPUTMESSAGE.getMessage());
        boolean reTry = true;
        while(reTry){
            try{
                winningNumber = readLine();
                checkWinningNumber(winningNumber);
                reTry = false;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        List<Integer> winNumberInt = new ArrayList<Integer>();
        for(String winningnum : winningNumber.split(",")){
            winNumberInt.add(Integer.parseInt(winningnum));
        }
        return winNumberInt;
    }

    public void checkbounsNumber(String bonusNumber){
        if (bonusNumber == null){
            throw new IllegalArgumentException("[ERROR] 값을 입력하여야 합니다.");
        }
        try{
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] int로 정의 될 수 없습니다.");
        }
        if(Integer.parseInt(bonusNumber)<1 || Integer.parseInt(bonusNumber)>45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(Arrays.asList(winningNumber.split(",")).contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    
    public int bonusNumberInput(){
        System.out.println(InputMassage.LOTTO_BONUS_NUMBER_INPUTMESSAGE.getMessage());
        boolean reTry = true;
        while(reTry){
            try{
                bounsNumber = readLine();
                checkbounsNumber(bounsNumber);
                reTry = false;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(bounsNumber);
    }

    public void setUserWinningRanks(Map<Integer, Integer> userWinningRanks){
        this.userWinningRanks = userWinningRanks;
    }

    public void setProfitSummary(double profitSummary){
        this.profitSummary = profitSummary;
    }

    public int getLottoPurchaseNum(){
        return lottoPurchaseNum;
    }


    public void lottoPurchaseNumbersOutput(){
        System.out.println(String.format("%d개를 구매했습니다.", lottoPurchaseNum));
    }

    public void userLottoNumbersOutput(List<Integer> userNums){
        System.out.println(userNums.toString());
    }
    
    public void winningStatisticsOutput(){
        System.out.println(String.format("""
                당첨 통계
                ---
                3개 일치 (5,000원) - %d개
                4개 일치 (50,000원) - %d개
                5개 일치 (1,500,000원) - %d개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                6개 일치 (2,000,000,000원) - %d개
            """, userWinningRanks.get(5), userWinningRanks.get(4), userWinningRanks.get(3), userWinningRanks.get(2), userWinningRanks.get(1)));
    }
    
    public void profitSummaryOutput(){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitSummary));
    }
}
