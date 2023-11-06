# 기능 구현 목록

-[x] 구입 금액을 입력받음
  -[x] 예외처리, 1000원 단위로 입력 되었는지.
  - [x] 정수로 변환 가능한 형태로 입력되었는지
    - 공백값 입력에 대한 검증
    - 문자열 입력에 대한 검증을 포함
- [x] 구매 가능한 로또 개수를 반환
- [x] 로또 개수만큼 로또 번호 리스트를 생성
- [x] 로또번호 리스트에 들어갈 6개의 로또번호 리스트 생성
  - [x] 중복된 숫자가 입력되지 않았는지 검증
    -[x] 로또 번호 생성시 오름차순으로 배열
- [x] 당첨 번호 입력 
  - [x] 중복된 숫자 입력 검증
  - [x] ","를 통해 입력값 구분 검증
  -[x] 1~45 사이의 숫자를 입력하는지에 대한 검증
- [x] 입력받은 당첨번호를 리스트에 추가
- [x] 입력 받은 번호를 정수로 반환
- [x] 보너스 번호를 입력받음
  - [x] 1~45 사이의 숫자를 입력하는지 검증
  - [x] 기존 당첨번호와 중복된 숫자가 아닌지 검증
-[x] enum을 통해 당첨 금액 관리 
-[x] 당첨 번호와 번호리스트를 비교하여 당첨여부 확인
- [x] 당첨 등수와 당첨 금액 연결 
- [x] 당첨 등수의 개수를 파악 
- [x] 당첨금과 당첨 횟수에 대한 정보 출력
  - [x] 정확한 format을 설정
- [x] 당첨금의 총액을 구해 구매금액으로 나눔
- [x] %형식에 맞게 포멧을 설정해 수익률 출력


# 초기 구조 구상 

### MVC 패턴에 맞춘 코드 구성 준비

- lotto
  - controller
    - Controller.java
  - model
    - Lotto.java
    - LottoResult.java
    - LottoTicket.java
  - repository
    - LottoRepository.java
  - service
    - LottoService.java
  - view
    - InputView.java
    - OutputView.java
  - Application.java

# 세부사항 수정전 구현완료된 코드

### 코드 구현 과정에서 수정된 package와 class 목록 
(첫 구현 로직 성공 까지의 수정 사항 반영) & 추가수정 실시간 반영 (**)

- lotto
  - controller
    - Controller.java
  - model
    - 수정이유 : 기존 제공되던 Lotto 클래스가 유효성검사로직을 품고 있기에, 해당 클래스와 유사한 기능을 하도록 유효성검사에 초점을 맞춤
    - Lotto.java
    - LottoTicket.java
      - ** 수정,LottoTicketCount(클래스 역할에 맞게 더욱 명확한 이름으로 수정)
    - LottoPrize (enum)
    - WinningNumber.java
    - BonusNumber.java
  - repository
    - 클래스 삭제, repository 구현을 실패함. 추가적인 refactoring에서 사용고려
  - service
    - 수정 이유 : 번호생성과 결과매칭 수익률계산 세부분으로 클래스를 나누어 객체지향적인 클래스 구조를 생성하고자 했음
    - LottoService.java
    - NumberMatchingService.java
    - EarningRateService.java
  - view
    - InputView.java
    - OutputView.java
  - Application.java

# 추가 refactoring 예정사항
-[ ] Naming 수정
  - 코드 구현 과정에서 lotto, lottoNumber, NumberString등 유사하게 작성된 코드가 많음.
  - 긴 메소드등을 세부적으로 분할하는 과정에서 네이밍수정이 필요함 
  - 클래스명 또한, 외국 로또에서 사용하는 네이밍을 기준으로 하였으나 직관적으로 알아보기 힘든 것 같음
-[ ] Controller 내의 메소드 수정
  - 현재 여러기능을 동시에 하는 메소드들이 많음.
  - test과정에서 계속 시간초과가 나서 객체 생성등을 최소화 하려고 합쳐놓은 부분들을 분리해야함
  - 오류값 입력시 중간부터 계속시작해야했기에 while, try-catch구문을 사용했으나 2중 indent에대한 추가 고려 필요해보임
- [ ] BonusNumber, WinningNumber
  - 두 클래스의 경우, 입력값 검증 로직에서 유사한 부분이 많음.
  - 클래스를 상속관계로 두어 오버라이딩 하는 수준 에서 처리가 가능해보임
  - 유사한 코드의 중복을 줄이는 방향으로 추가 refactoring 예정.
- [ ] Lotto
  - 제공된 클래스를 어떻게 수정해야 할 지 모르겠으나, 오류 검증위주로 코드추가예정
  - randomNumber 추출의 경우 제공된 코드가 있기에 어떻게 수정해 나갈지 미정.
- [x] LottoTicket
  - 해당 검증에 빠진 부분이 있는지 추가 고려 필요
- [ ] LottoService
  - switch/case로 구성된 메소드 다시 생각 
  - enum에서 사용 하는 부분에 대해 고려 포함.
- [ ] OutputView
  - 고정된 출력형식에 대한 상수화 추가 진행
- [ ] 전체 수정사항
  - [ ] 구현순서가 제대로 되어있는지 체크할 것.
- [ ] 테스트 코드 추가 하기 
  - [x] LottoTicketCount