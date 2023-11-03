# 기능명세
- [ ] 구입 금액을 입력한다. InputMaker#InsertCoin()
  - [ ] (예외처리) 로또금액인 1000원으로 나누어지지 않는 경우 Customer#validateCoin()
- [ ] 구입 금액에 해당하는 만큼 로또를 생성한다. (1000/한장) TicketMaster#makeTicket()
- [ ] 당첨 번호를 입력한다. InputMaker#inputWinningNum()
  - [ ] 입력받는 번호는 ','(쉼표)로 구분된다. InputMaker#validateWinningInput()
  - [ ] (예외처리) 6자리로 구분되어 저장 될 수 없는경우 Lotto#validateWinningNumSize()
  - [ ] (예외처리) 로또 번호의 숫자 범위는 1~45까지이다. Lotto#validateWinningNum()
- [ ] 보너스 번호를 입력한다. InputMaker#inputBonusNum()
  - [ ] (예외처리) 보너스 번호는 로또번호와 중복되지 않는다. TicketMaster#validateBonusNum()
- [ ] 당첨 확인 TicketMaster#checkLotto()
- [ ] 당첨 내역 출력 OutputMaker#printLottoResult()
  - [ ] 발행한 로또 수와 로또번호(오름차순)을 출력한다. Lotto#sortNumbers() _ OutputMaker#printLotto();
  - [ ] 당첨갯수 기준 오름차 순으로 출력한다.
- [ ] 수익률 출력 OutputMaker#printROI()
  - 수익률은 소수점 둘째 자리에서 반올림한다.(##.#%) OutputMaker#validateROI() 
- [ ] 예외상황의 에러문구는 "[ERROR]"로 시작한다.
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 시나리오 LottoController
- 로또 구입 금액을 입력
- 로또 발행(비공개)
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

# 구현 클래스의 목적
- LottoController : 로또 미션 로직을 담음
domain
- Customer : 상품 구매자, 금액과 발행된 로또를 가지고 있음.
- Lotto : 로또(상품)의 객채
- TicketMaster : 로또를 발행한다.
UI
- OutputMaker : 출력 서식을 담당
- InputMaker : 사용자 입력을 받음
- ExceptionMessage : 에러 메세지를 갖음