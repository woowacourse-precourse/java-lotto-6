package lotto;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;

public class Application {
    final static int lottoMin = 1;
    final static int lottoMax = 45;
    final static int lottolength = 6;
    final static int lotteryWinningRank = 6;
    final static int coinStandard = 1000;
    final static int[] lottoRankMoney = {0, 2000000000, 30000000, 1500000, 50000, 5000};
    static int inputCoin;
    static int bonusNumber;
    static int totalLottoMoney;
    static List<Integer> inputWinningLotto = new ArrayList<>();
    static List<List<Integer>> lottoTotal = new ArrayList<>();
    // myWinningLotto = {미당첨, 1등, 2등, 3등, 4등, 5등}
    static List<Integer> myWinningLotto = new ArrayList<>();    

    public static void CoinValidate(String playerInput){
        try{
            inputCoin = Integer.parseInt(playerInput);          
        }catch(Exception e){
            System.out.println("[ERROR] 로또 구입 금액에는 숫자만 존재해야 합니다.");        
            throw new IllegalArgumentException();
        }

        if (inputCoin % coinStandard != 0){
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");        
            throw new IllegalStateException();
        }              
        
    }

    public static void GetCoin(){
        System.out.println("구입금액을 입력해 주세요.");
        String playerInput = Console.readLine();

        CoinValidate(playerInput);

        inputCoin = inputCoin / coinStandard;
        System.out.println();
    }

    public static List<Integer> RandomLottoNumber() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(lottoMin, lottoMax, lottolength);
        Collections.sort(randomNumber);
        return randomNumber;
    }

    public static void GetLottos(){
        System.out.println(inputCoin+"개를 구매했습니다.");
        for(int i=0; i<inputCoin; i++){
            lottoTotal.add(RandomLottoNumber());
        }
        for(List<Integer> lotto: lottoTotal){
            System.out.println(lotto);
        }
        System.out.println();
    }
    
    public static int LottoNumberValidate(String lottoNumber){
        int lottoNum;
        try{
            lottoNum = Integer.parseInt(lottoNumber);
        }catch(Exception e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }        

        if (lottoNum < lottoMin || lottoNum > lottoMax){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return lottoNum;
    }
    
    public static void BonusNumberInput(){
        System.out.println("보너스 번호를 입력해주세요");
        bonusNumber = LottoNumberValidate(Console.readLine());
        System.out.println();
    }

    public static void WinningLottoInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        for(String lottoNumber : Console.readLine().split(",")){
            inputWinningLotto.add(LottoNumberValidate(lottoNumber));
        }
        System.out.println();
    }

    public static void BonusNumberDuplicateCheck(){
        if (inputWinningLotto.contains(bonusNumber)){
            System.out.println("[ERROR] 당첨 번호에 중복된 숫자는 허용하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static int CheckLottoRank(int lottoResult){
        if (lottoResult == 6)
            return 1;
        if (lottoResult == 15)
            return 2;
        if (lottoResult == 5)
            return 3;
        if (lottoResult == 4 || lottoResult == 14)
            return 4;
        if (lottoResult == 3 || lottoResult == 13)
            return 5;
        return 0;
    }

    public static void MyLottoCheck(Lotto lotto){
        int lottoResult;
        int rank;
        for (List<Integer> mylotto: lottoTotal){
            lottoResult = lotto.LottoCheck(mylotto, bonusNumber, inputWinningLotto);
            rank = CheckLottoRank(lottoResult);
            myWinningLotto.set(rank, myWinningLotto.get(rank)+1) ;
        }
    }

    public static void LotteryWinningInit(){
        for(int i=0; i<lotteryWinningRank; i++)
            myWinningLotto.add(0);
    }

    public static int GetMoney(int rank, int lottoWinCount){
        if (rank == 1)
            System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinCount + "개");
        if (rank == 2)
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinCount + "개");
        if (rank == 3)
            System.out.println("5개 일치 (1,500,000원) - " + lottoWinCount + "개");
        if (rank == 4)
            System.out.println("4개 일치 (50,000원) - " + lottoWinCount + "개");
        if (rank == 5)
            System.out.println("3개 일치 (5,000원) - " + lottoWinCount + "개");

        return lottoRankMoney[rank] * lottoWinCount;
    }

    public static void SumLottoResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=lotteryWinningRank-1; i>0; i--){
            totalLottoMoney += GetMoney(i, myWinningLotto.get(i));
        }
    }

    public static void RateOnReturn(){
        double rate = Math.round((double)totalLottoMoney/(inputCoin*coinStandard)*1000)/10.0;
        System.out.println("총 수익률은 "+String.format("%.1f",rate)+"%입니다.");        
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GetCoin();
        GetLottos();
        WinningLottoInput();
        BonusNumberInput();
        BonusNumberDuplicateCheck();

        Lotto lotto = new Lotto(inputWinningLotto);
        
        LotteryWinningInit();
        MyLottoCheck(lotto);
        SumLottoResult();
        RateOnReturn();
    }
}
