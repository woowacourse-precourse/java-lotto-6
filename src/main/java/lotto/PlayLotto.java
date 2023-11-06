package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayLotto {

    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private final int LOTTO_NUM_CNT = 6;

    Money money;
    Lotto lotto;
    String[] inputLottoNumbers;
    List<List<Integer>> userLottoNumbers = new ArrayList<>();
    List<Integer> lottoNumbers;

    int lottoCnt;

    public void play(){
        getMoney();
        makeLotto();
        getNumber();
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

    public void getNumber(){
        try{
            System.out.println("당첨 번호를 입력해 주세요.");
            inputLottoNumbers = readLine().split(",");
            changeInputFormat();
            lotto = new Lotto(lottoNumbers);
            System.out.println();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getNumber();
        }
    }

    public void changeInputFormat(){
        lottoNumbers = new ArrayList<>();
        for (String s : inputLottoNumbers){
            lottoNumbers.add(Integer.parseInt(s));
        }
    }
}
