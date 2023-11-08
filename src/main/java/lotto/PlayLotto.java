package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayLotto {

    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private final int LOTTO_NUM_CNT = 6;

    Money money;
    Lotto lotto;
    BonusNumber bonusNumber;
    String[] inputLottoNumbers;
    List<UserLotto> userLottos = new ArrayList<>();
    List<Integer> lottoNumbers;
    int lottoCnt;
    int matchedNumberCnt;
    Map<Rank, Integer> result = new HashMap<>();
    boolean hasBonusNumber;
    Profit profit;
    double profitRate;
    String userMoney;

    public void play(){
        getMoney();
        makeLotto();
        getLottoNumber();
        getBonusNumber();
        getResult();
        checkResult();
        getProfitRate();
    }

    public void getMoney(){
        try{
            System.out.println("구입 금액을 입력해 주세요.");
            userMoney = readLine();
            money = new Money(userMoney);
            System.out.println();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getMoney();
        }
    }

    public void makeLotto(){
        lottoCnt = Integer.parseInt(money.amount) / 1000;
        System.out.println(lottoCnt + "개를 구매했습니다.");

        for (int i=0; i<lottoCnt; i++){
            userLottos.add(new UserLotto(getGeneratedRandomNumbers()));
        }

        for (UserLotto userLotto : userLottos){
            System.out.println(userLotto.numbers);
        }

        System.out.println();
    }

    public List<Integer> getGeneratedRandomNumbers(){
        List<Integer> curNumbers;
        curNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUM_CNT);
        return curNumbers;
    }

    public void getLottoNumber(){
        try{
            System.out.println("당첨 번호를 입력해 주세요.");
            inputLottoNumbers = readLine().split(",");
            changeInputFormat();
            lotto = new Lotto(lottoNumbers);
            System.out.println();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getLottoNumber();
        }
    }

    public void changeInputFormat(){
        lottoNumbers = new ArrayList<>();
        for (String s : inputLottoNumbers){
            lottoNumbers.add(Integer.parseInt(s));
        }
    }

    public void getBonusNumber(){
        try{
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = new BonusNumber(readLine(), lottoNumbers);
            System.out.println();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getBonusNumber();
        }
    }

    public void getResult(){
        System.out.println("당첨 통계\n---");
        initResult();
        for (UserLotto userLotto : userLottos){
            hasBonusNumber = false;
            matchedNumberCnt = getMatchedNumberCnt(userLotto.numbers, lottoNumbers);
            if (matchedNumberCnt == 5 && userLotto.numbers.contains(bonusNumber.number)){
                hasBonusNumber = true;
            }
            updateResult(matchedNumberCnt, hasBonusNumber);
        }
    }

    public void initResult(){
        for (Rank r : Rank.values()){
            result.put(r, 0);
        }
    }

    public int getMatchedNumberCnt(List<Integer> userLottoNumber, List<Integer> lottoNumbers){
        int cnt = 0;
        for (int num : userLottoNumber){
            if (lottoNumbers.contains(num)){
                cnt++;
            }
        }
        return cnt;
    }

    public void updateResult(int matchedNumberCnt, boolean hasBonusNumber){
        for (Rank r : Rank.values()){
            if (r.matchedCnt == matchedNumberCnt && r.hasBonusNumber == hasBonusNumber){
                result.put(r, result.get(r) + 1);
            }
        }
    }

    public void checkResult(){
        for (int i = Rank.values().length - 1; i>=0; i--){
            System.out.println(Rank.values()[i].message + result.get(Rank.values()[i]) + "개");
        }
    }

    public void getProfitRate(){
        profit = new Profit(result, Integer.parseInt(money.amount));
        profit.printProfitRate();
    }

}
