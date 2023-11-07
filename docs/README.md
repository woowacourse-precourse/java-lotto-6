구현할 기능 목록
- 사용자 입력받기 - LottoInputHandler
  - 구입 금액(1000원 단위가 아니면 예외 처리) - LottoInputHandler#getPurchaseAmount()
  - 당첨 번호(1-45사이 숫자가 아니면 예외 처리) - LottoInputHandler#getWinningNumbers()
  - 보너스 번호 - LottoInputHandler#getBonusNumber()
- 로또 1장당 번호 6개 발행 - LottoNumberFactory#generate()
  - 랜덤, 중복x, 범위:1-45
- 당첨 번호와 구입한 로또 번호 비교 - Number#compare()
- 결과 출력 - LottoManager
  - 발행한 로또 수량 및 번호(오름차순) - LottoManager#showTicketInfo()
  - 당첨내역 - LottoManager#showResults()
  - 수익률(소수점 둘째 자리에서 반올림) - LottoManager#printProfitRate



🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
      로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
      로또 1장의 가격은 1,000원이다.
      당첨 번호와 보너스 번호를 입력받는다.
      사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
      사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.