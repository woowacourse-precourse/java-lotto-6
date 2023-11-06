package lotto;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;


public class Application {
    final static int lottoMin = 1;
    final static int lottoMax = 45;
    final static int lottolength = 6;
    final static int lotteryWinningRank = 6;
    final static int coinStandard = 1000; 
    static int inputCoin;
    static int bonusNumber;
    static int totalLottoMoney;
    static List<Integer> inputWinningLotto = new ArrayList<>();
    static List<List<Integer>> lottoTotal = new ArrayList<>();
    static List<Integer> lottoWinnings = new ArrayList<>();
    

    public static void CoinValidate(int inputCoin){
        if (inputCoin % coinStandard != 0){
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");        
            throw new IllegalArgumentException();
        }            
    }

    public static void GetCoin(){
        System.out.println("구입금액을 입력해 주세요.");
        inputCoin = Integer.parseInt(Console.readLine());
        CoinValidate(inputCoin);
        inputCoin = inputCoin / coinStandard;
        System.out.println();
    }

    public static List<Integer> RandomLottoNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Collections.sort(computer);
        return computer;
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
        int lottoNum = Integer.parseInt(lottoNumber);

        if (lottoNum < lottoMin || lottoNum > lottoMax){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return lottoNum;
    }
    
    public static void BonusNumberInput(){
        System.out.println("보너스 번호를 입력해주세요");
        bonusNumber = LottoNumberValidate(Console.readLine());
    }

    public static void WinningLottoInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        for(String lottoNumber : Console.readLine().split(",")){
            inputWinningLotto.add(LottoNumberValidate(lottoNumber));
        }
        System.out.println();
    }

    public static void DuplicateCheck(){
        Set<Integer> lottoNumbers = new HashSet<>(inputWinningLotto);
        if(lottoNumbers.size() != inputWinningLotto.size()){
            System.out.println("[ERROR] 당첨 번호에 중복된 숫자는 허용하지 않습니다.");
            throw new IllegalArgumentException();
        }
        if (inputWinningLotto.contains(bonusNumber)){
            System.out.println("[ERROR] 당첨 번호에 중복된 숫자는 허용하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static int CheckLottoRank(int lottoResult){
        System.out.println(lottoResult);
        if (lottoResult == 6)
            return 4;
        if (lottoResult == 15)
            return 3;
        if (lottoResult == 5)
            return 2;
        if (lottoResult == 4 || lottoResult == 14)
            return 1;
        if (lottoResult == 3 || lottoResult == 13)
            return 0;
        return 5;
    }

    public static void MyLottoCheck(Lotto lotto){
        int lottoResult;
        int rank;
        for (List<Integer> mylotto: lottoTotal){
            lottoResult = lotto.LottoCheck(mylotto, bonusNumber, inputWinningLotto);
            rank = CheckLottoRank(lottoResult);
            lottoWinnings.set(rank, lottoWinnings.get(rank)+1) ;
        }
    }

    public static void LotteryWinningInit(){
        for(int i=0; i<lotteryWinningRank; i++)
            lottoWinnings.add(0);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GetCoin();
        GetLottos();
        WinningLottoInput();
        BonusNumberInput();
        DuplicateCheck();

        Lotto lotto = new Lotto(inputWinningLotto);

        LotteryWinningInit();
        MyLottoCheck(lotto);
        System.out.println(lottoWinnings);

    }
}
