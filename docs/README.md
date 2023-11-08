## 프로그램 순서

- 프로그램 실행
- 구입금액 입력
- 로또 발행
- 당첨번호, 보너스번호 입력
- 당첨 확인
- 결과 출력

## 구현 기능 목록

- [x] controller) 사용자 구입 금액 입력 요청 - LottoController.lottoOrderRequest()
    - [x] view) 사용자 로또 구입 금액 입력 - UI.sendLottoPurchaseRequest()
- [x] controller) 사용자 구입 입력값에 대한 로또 발행 요청 LottoController.buyLottoTicketRequest()
    - [x] domain) 로또 구매후 값저장 - LottoStore.buyLottoTickets()
        - [x] domain) 로또 발행 - LottoStoreClerk.createLottoTickets()
            - [x] domain) 주문 금액 처리 - LottoStoreClerk.handlingOrderAmount()
                - [x] domain) 금액이 올바른 값인지 확인 - LottoStoreClerk.checkLottoOrderAmount()
            - [x] domain) 주문 갯수에 맞게 로또 발행 - LottoStoreClerk.lottoGenerater()
    - [x] view) 발행된 로또 출력 - UI.displayLottoTicketsHistory()
- [x] controller) 당첨 번호 입력 요청 LottoController.requestInputWinningNumbers()
    - [x] view) 당첨 번호 입력 - UI.InputWinningNumbers()
- [x] controller) 입력된 당첨 번호 확인및 저장 요청  
    - [x] domain) 당첨 로또 올바른 생성및 검사 - Lotto.createLotto()
        - [x] domain) 6자리인가 - 제공된 Lotto.validate()
        - [x] domain) 번호가 겹치는건 없는가? Lotto.validateUnique()
        - [x] domain) 번호가 1~45 사이의 정수인가? Lotto.Range()
- [x] controller) 보너스 번호 입력 요청 - LottoController.requestBonusNumber()
    - [x] view) 보너스 번호 입력 - UI.InputBonusNumber()
- [x] controller) 입력된 보너스 번호 확인및 생성
    - [x] domain) 보너스 번호 입력값 검사 Lotto.validateBonusNumber()
    - [x] domain) 보너스 번호 반환 Lotto.createBonusNumber()
- [x] controller) 사용자가 구매한 로또 번호와 당첨 번호를 비교 요청
    - [x] domain) 사용자가 구매한 로또 번호와 당첨 번호를 비교
        - [x] domain) 각 로또 번호당 일치 갯수 확인 
        - [x] domain) 각 로또 번호당 2등 확인
    - [x] domain) 비교한 자료를 토대로 수익률계산
    - [x] domain) 결과들을 토대로 문자열 생성
    - [x] view) 생성된 문자열 출력

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [x] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

 