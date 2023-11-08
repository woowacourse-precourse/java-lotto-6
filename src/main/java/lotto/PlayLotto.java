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
    int[] rankCnt = new int[8];
    List<List<Integer>> userLottoNumbers = new ArrayList<>();
    List<Integer> lottoNumbers;
    int lottoCnt;
    int matchedNumberCnt;
    Map<Rank, Integer> result = new HashMap<>();
    boolean hasBonusNumber;

    public void play(){
        getMoney();
        makeLotto();
        getLottoNumber();
        getBonusNumber();
        getResult();
        checkResult();
    }

    public void getMoney(){
        try{
            System.out.println("구입 금액을 입력해주세요.");
            money = new Money(readLine());
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
            userLottoNumbers.add(getGeneratedRandomNumbers());
        }

        for (List<Integer> userLottoNumber : userLottoNumbers){
            System.out.println(userLottoNumber);
        }

        System.out.println();
    }

    public List<Integer> getGeneratedRandomNumbers(){

        List<Integer> curNumbers = new ArrayList<>();
        while (curNumbers.size() < LOTTO_NUM_CNT){
            int randomNumber = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            if (!curNumbers.contains(randomNumber)) {
                curNumbers.add(randomNumber);
            }
        }

        Collections.sort(curNumbers);
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
        initResult();
        for (List<Integer> userLottoNumber : userLottoNumbers){
            hasBonusNumber = false;
            matchedNumberCnt = getMatchedNumberCnt(userLottoNumber);
            if (matchedNumberCnt == 5 && userLottoNumber.contains(bonusNumber.number)){
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

    public int getMatchedNumberCnt(List<Integer> userLottoNumber){
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
}





