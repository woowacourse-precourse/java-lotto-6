package lotto.Lottery.Service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lottery.Enum.LottoWinnings;
import lotto.Lottery.Util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private CostChecker costChecker = new CostChecker();
    private LottoChecker lottoChecker = new LottoChecker();
    private BonusChecker bonusChecker = new BonusChecker();
    private ResultUtil resultUtil = new ResultUtil();

    final static int LOTTO_PRICE = 1000;

    // 유저 구입 금액 정보
    private int userMoney;

    // 티켓 별 정보
    List<List<Integer>> LottoTickets = new ArrayList<>();
    int lottoTicket;

    // 당첨 결과 정보
    private Lotto lotto;
    private int bonusNumber;

    // 1번 파트 부분
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

    // 2번 파트 부분
    public void generateLotto(){ // 로또 생성!
        // user의 로또 티켓 개수
        this.lottoTicket = (int)(this.userMoney/LOTTO_PRICE);

        for(int i = 0; i < lottoTicket; i++){
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            try{
                Collections.sort(ticket);
            } catch(UnsupportedOperationException e){
                // 아무 작업도 하지 않음.
            }
            LottoTickets.add(ticket);
        }
    }

    public void printOutTickets(){
        System.out.println(lottoTicket + "개를 구매했습니다.");
        for(List<Integer> lotto :LottoTickets)
            System.out.println(lotto);
        System.out.println();
    }

    // 3번 기능
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

    // 4번 기능 관련
    public void writeAllResult(){
        // 1등부터 5등까지 모두 0으로 초기화
        List<Integer> WinnerRecord = resultUtil.initWinnerRecord();

        Double winnerPrice = (double)resultUtil.updateAllResult(this.lotto, this.bonusNumber,
                this.LottoTickets, WinnerRecord, 0);

        Double rateOfReturn = 100 * winnerPrice/(double)userMoney;
        rateOfReturn = Math.round(rateOfReturn * 100.0)/ 100.0;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + WinnerRecord.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + WinnerRecord.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + WinnerRecord.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + WinnerRecord.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + WinnerRecord.get(0) + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }



}
