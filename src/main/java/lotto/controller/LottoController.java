package lotto.controller;

/**
 * 로또 게임의 메인 컨트롤러입니다. 사용자의 입력을 받고 게임의 흐름을 제어합니다.
 */
public class LottoController {

    public void receivePurchaseAmount() {
        // TODO: 사용자로부터 로또 구매 금액을 입력받는 메서드 구현
    }

    public void createLottoTickets() {
        // TODO: 구매 금액에 따라 로또 티켓을 생성하는 메서드 구현
    }

    public void receiveWinningNumbers() {
        // TODO: 사용자로부터 당첨 번호를 입력받는 메서드 구현
    }

    public void calculateResults() {
        // TODO: 당첨 결과를 계산하는 메서드 구현
    }

    public void displayResults() {
        // TODO: 결과를 출력하는 메서드 구현
    }

    /**
     * 로또 게임을 실행하는 메인 메서드.
     */
    public void run() {
        // 로또 구매 금액 입력받기
        receivePurchaseAmount();

        // 로또 티켓 생성
        createLottoTickets();

        // 당첨 번호 입력받기
        receiveWinningNumbers();

        // 당첨 결과 계산
        calculateResults();

        // 결과 출력
        displayResults();
    }
}
