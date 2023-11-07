package lotto.Lottery.Controller;

import lotto.Lottery.Service.LottoService;

public class LottoController { // Lotto 시스템을 통합 관리하는 Controller
    LottoService lottoService = new LottoService();

    public void runLottoSystem(){

        lottoService.UserCostInputImpl(); // 유저가 금액 정보 입력 및 전달

        lottoService.generateLotto(); // Lotto 생성
        lottoService.printOutTickets(); // Lotto 정보 출력

        lottoService.generateWinnerImpl(); // 유저 입력한 값에 따라 Winner 결정
        lottoService.generateBonusNumberImpl(); // 유저 입력한 값에 따라 bonus 번호 결정

        lottoService.writeAllResult();
    }

}
