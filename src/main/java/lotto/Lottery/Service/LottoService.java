package lotto.Lottery.Service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lottery.Util.BonusChecker;
import lotto.Lottery.Util.CostChecker;
import lotto.Lottery.Util.LottoChecker;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    CostChecker costChecker = new CostChecker();

    private int userMoney;
    final static int LOTTO_PRICE = 1000;

    // Getter
    public int getUserMoney() {
        return userMoney;
    }

    /**
     * 해당 부분은 사용자의 입력 부분과 관련이 있으며 사용자의 입력 정보(Long type)를 받고 검사한다.
     * 검사가 되는 부분은 총 4가지이다.
     * 1. Long 타입 값을 벗어난 경우 Java에서 자체적으로 IllegalArgumentException을 던져준다.
     * 2. 사용자의 입력을 받았을 때 숫자값이 아닌 경우 Java의 오류를 IllegalArgumentException으로 변환하여 던진다.
     * 3. 사용자 정의: 로또 금액인 1000원 단위를 벗어난 경우 IllegalArgumentException을 던져준다.
     * 4. 사용자 정의: 로또 금액이 양수가 아닌 경우 IllegalArgumentException을 던져준다.
     *
     * 실제 구현에서는 오류가 뜨더라도 예외 메세지를 던지고 반복을 해야한다.
     * 따라서 Impl 부분에서는 해당 조건이 만족되어 true를 반환할 때까지 무한하게 반복한다.
     */

    public boolean getUserCostInput(){
        try{
            System.out.println("구입금액을 입력해 주세요.");
            this.userMoney = costChecker.isNumber(Console.readLine()); // 유효성 검사(숫자?) -> IllegalArgumentException으로 변환
            System.out.println();
            costChecker.CostCheck(userMoney); // 유효성 검사(1000원 단위?, 양수?)
            return true;
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 유효하지 않은 금액입니다. 다음과 같이 입력해주세요. ex) 1000");
            System.out.println();
            return false;
        }
    }

    public void UserCostInputImpl(){
        while(getUserCostInput() == false);
    }

    /**
     * 유저 input에 맞는 로또 생성! 여기서는 앞에서 검사를 제대로 했다면 오류가 날 가능성이 없음!
     * 기능 1. 로또 생성 앞에서 받아온 유저 Input값을 통해서 로또 생성
     * 기능 2. 로또 생성 프린트
     */

    // 티켓 별 정보
    List<List<Integer>> LottoTickets = new ArrayList<>();
    int lottoTicket;

    public void generateLotto(){ // 로또 생성!
        // user의 로또 티켓 개수
        this.lottoTicket = (int)(this.userMoney/LOTTO_PRICE);

        for(int i = 0; i < lottoTicket; i++){
            LottoTickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void printOutTickets(){
        System.out.println(lottoTicket + "개를 구매했습니다.");
        for(List<Integer> lotto :LottoTickets)
            System.out.println(lotto);
        System.out.println();
    }

    /**
     * 로또 당첨 번호 입력
     * 예외 정리(당첨 번호)
     * 1. 숫자 개수가 6개가 아닌 경우
     * 2. 값이 1-45 사이의 번호가 아닌 경우
     * 3. 번호가 겹치는 게 있는 경우
     * 4. 숫자가 아닌 값이 나오는 경우
     *
     * 예외 정리(보너스 번호)
     * 1. 입력 값이 숫자가 아닌 경우
     * 2. 입력 값이 1-45 사이의 번호가 아닌 경우
     * 3. 입력값이 이미 당첨 번호에 포함되는 경우
     *
     */

    private LottoChecker lottoChecker = new LottoChecker();
    private BonusChecker bonusChecker = new BonusChecker();

    private Lotto lotto;
    private int bonusNumber;

    public boolean generateWinners(){
        try{
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> lottoNumbers = lottoChecker.generateWinner(Console.readLine());
            this.lotto = new Lotto(lottoNumbers);
            System.out.println();
            return true;

        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 입력값입니다. 다시 입력해주세요. ex) 1,2,3,4,5,6");
            System.out.println();
            return false;
        }
    }

    public void generateWinnerImpl(){
        while(generateWinners() == false);
    }

    public boolean generateBonusNumber(){
        try{
            System.out.println("보너스 번호를 입력해주세요.");
            this.bonusNumber = bonusChecker.isNumber(Console.readLine());

            if(lotto.bonusValidate(bonusNumber) == false)
                throw new IllegalArgumentException("[ERROR] 입력 값이 이미 존재합니다.");

            if(bonusChecker.isInRange(bonusNumber) == false)
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자 값을 벗어났습니다.");

            System.out.println();
            return true;
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] 이미 존재하거나, 유효하지 않은 입력값입니다.");
            System.out.println();
            return false;
        }
    }

    public void generateBonusNumberImpl(){
        while(generateBonusNumber() == false);
    }

}
