package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoController {

    private LottoGame lg;
    private Validator validator = new Validator();
    private int price = 0;
    private List<Lotto> myLotto;
    private Lotto winningNumber;
    private int bonusNumber;
    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    public void makeLottoGameInstance(LottoGame lottoGame){
        lg = lottoGame;
    }
    public boolean howMuchIsIt(String number){
        if(!validator.validatePriceNumber(number, lg)) return false;
        price = Integer.parseInt(number);
        if(!validator.validateThousands(price, lg)) return false;
        return true;
    }
    public List<Integer> lottoMaker(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
    public String buyLotto(){
        myLotto = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int times = price/1000;
        sb.append(times).append("개를 구매했습니다.");
        for(int i = 0; i < times; i++){
            Lotto lotto = new Lotto(lottoMaker());
            myLotto.add(lotto);
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean pickWinningNumber(String number){
        List<Integer> winningNumber = new ArrayList<>();
        boolean isValidated = validator.validateWinningNumber(number, lg);
        if(isValidated) {
            StringTokenizer st = new StringTokenizer(number, ",");
            while(st.hasMoreElements()){
                int lottoNumber = Integer.parseInt(st.nextToken());
                winningNumber.add(lottoNumber);
            }
            this.winningNumber = new Lotto(winningNumber);
            return true;
        }
        return false;
    }

    public boolean pickBonusNumber(String number){
        boolean isValidated = validator.validateBonusNumber(number, lg);
        bonusNumber = Integer.parseInt(number);
        return isValidated;
    }

    public String lottoResult(){
        prizeTimes();
        double income = calcIncome();
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---\n");
        sb.append("3개 일치 (5,000원) - ").append(fifth).append("개\n");
        sb.append("4개 일치 (50,000원) - ").append(fourth).append("개\n");
        sb.append("5개 일치 (1,500,000원) - ").append(third).append("개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(second).append("개\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(first).append("개\n");
        sb.append("총 수익률은 ").append(income).append("%입니다.");
        return sb.toString();
    }
    public void prizeTimes(){
        for (Lotto lotto : myLotto) {
            int prize = checkResult(lotto);
            if(prize == 5) fifth++;
            if(prize == 4) fourth++;
            if(prize == 3) third++;
            if(prize == 2) second++;
            if(prize == 1) first++;
        }
    }
    public int checkResult(Lotto lotto){
        int sameNumbers = 0;
        List<Integer> list = lotto.getList();
        for(int i = 0; i < winningNumber.getSize(); i++){
            if(list.contains(winningNumber.getList().get(i))) sameNumbers++;
        }
        return prizeResult(list, sameNumbers);
    }
    public int prizeResult(List<Integer> list, int sameNumbers){
        if(sameNumbers == 3) return 5;
        if(sameNumbers == 4) return 4;
        if(sameNumbers == 5 && !list.contains(bonusNumber)) return 3;
        if(sameNumbers == 5 && list.contains(bonusNumber)) return 2;
        if(sameNumbers == 6) return 1;
        return 6;
    }
    public double calcIncome(){
        double sum = 0;
        sum += fifth*5000;
        sum += fourth*50000;
        sum += third*1500000;
        sum += second*30000000;
        sum += first*2000000000;

        double income = sum/(double)price*100;
        return (double) Math.round(income * 10) /10;
    }
}
