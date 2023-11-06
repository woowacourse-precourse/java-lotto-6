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
    - [x] view) 발행된 로또 출력 
- [ ] controller) 당첨 번호 입력 요청
    - [ ] view) 당첨 번호 입력
- [ ] controller) 입력된 당첨 번호 확인및 저장 요청
    - [ ] domain) 당첨 번호 입력값 검사
    - [ ] domain) 당첨 번호 저장
- [ ] controller) 보너스 번호 입력 요청
    - [ ] view) 보너스 번호 입력
- [ ] controller) 입력된 보너스 번호 확인및 저장 요청
    - [ ] domain) 보너스 번호 입력값 검사
    - [ ] domain) 보너스 번호 저장
- [ ] controller) 사용자가 구매한 로또 번호와 당첨 번호를 비교 요청
    - [ ] domain) 사용자가 구매한 로또 번호와 당첨 번호를 비교
        - [ ] domain) 각 로또 번호당 일치 갯수 확인
        - [ ] domain) 각 로또 번호당 2등 확인
    - [ ] domain) 비교한 자료를 토대로 수익률계산
    - [ ] domain) 결과들을 토대로 문자열 생성
    - [ ] view) 생성된 문자열 출력

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 개발 진행 중 고민과 결정

- 유효성 검사 지점을 한곳에 집중하는게 나을까? 아니면 모든 레이어에 걸쳐 독립적으로 하는게 나을까?
- 유틸클래스나 상수, 유효성 검사클래스는 독립적으로 분리하는게 나을까? 아니면 각 레이어에 포함 시키는게 나을까?
- "Java Enum을 적용한다" 요구사항에서 어떻게 사용할까?
- "핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다." 을 어떻게 구현할가?
    - MVC 패턴이 비지니스 레이어와 프레젠테이션 레이어를 분리하는데 집중하는데 착안하여 UI 기능과 핵심 로직을 담당하는 기능을 분리하는데 힘썼다, 하지만 controller 같은 경우는 둘 사이에서 애매한
      성격을 가지고 있어서 고민  
- 처음부터 완벽하게 설계후 만드는게 불가능에 가깝워 보임.
  - 차라리 기능을 하나씩 천천히 만들고 완성시키면서 이후에 기능별로 레이어별로 더 분리하고, 자기가 맡은일만 할수있도록 리팩토링 하면서 만들기로 결정.