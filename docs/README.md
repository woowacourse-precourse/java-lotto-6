# 요구사항 정리

## 1. 기능 요구사항 (핵심만)

- [x] 로또 1000원
- [x] 사용자가 값을잘못 입력할 경우 예외 처리 및 "[Error]" 메시지 출력 후 해당 부분부터 입력받기
    - try-catch 시, throws 작은 단위 설정
    - try-catch 위치는 금액 입력 단계
- [x] 모든 예외 문구는 출력을 통해 보여줘야함.

## 2. 프로그래밍 요구사항

- 사용 API
    - List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);// 주의 : 변경불가한 list
- [x] 삼항연산자 X, 들여쓰기 2단계
- [x] 메서드 길이가 15라인 넘어가지 않도록 구현
- [x] else 사용 말것
- [x]  Enum 적용
- [x] model, view, controller, util 분리
- [ ] domain logic 단위 테스트

# 구현 설계

## 1. 패키지

1. util
    - Validator
    - LottoTypeConverter
    - LottoMachine
2. model
    - Lotto
    - RankTable
    - ClientLottoData
    - WinningLottoNumber
3. controller
    - LottoController
4. view
    - InputView
    - OutputView

## 2. 구현 기능

- 공통 고민
    1. new 객체 생성위치를 통일 하면 좋을 듯하다. 어떤 건 controller, 어떤 건 LottoMachine  
       해당 class에서 직접생성하든지, 생성하는 정규화된 위치가 존재하면 좋을 듯하다.  
       ps. 내 생각에는 자료형 객체 생성은 상관 없는 것 같다. 해당 method에서 자료형 객체에 담아서 결국 만들어진 클래스의 인스턴스에 담을 것이기 때문
    2. private iv들은 getter까진 괜찮다. 하지만 setter를 통해서 값을 설정하면 개발자에 의해 문제가 발생할 수 있다.  
       setter를 풀어도되는 조건과 안되면 나중에 값을 받을 경우 어떻게 받을지, 관련 패턴이 있는지 확인 필요
    3. 맨 마지막에 네이밍 컨밴션 전체적으로 수정할 것 확인하기

### 2.1. summary

### 2.2. detail

1. view package

- [x] InputView : static method로써 class명을 같이 사용할 것이기때문에 get,set 접두어 제거
    - buyLottoPrice() : 로또 구입 금액
    - WinningLottoNumber() : 당첨번호를 입력 받는다.
    - BonusNumber() : 보너스 번호를 입력 받는다.

- [ ] OutputView
    - askBuyLottoPrice(), askWriteWinningNumber(), askWriteBonusNumber() : 질문 관련 단순 method
    - boughtLottoNumber() : 구입한 로또 수량 및 번호를 받는다.
      ~~- showErrorString() : [ERRROR] 내가 정한 문구~~
    - ⚠️ winningStatistics() : Enum 활용한 당첨 확률 출력, 조금 복잡한 code, 리팩토링 필요
        - ⚠️ count() : 내부 method - 해당 class에 존재하는게 맞는지 , util로 분리해야할지 고민
    - income() : 수익률 출력

2.✅ model package

- [x] Lotto : 로또번호 list
- [x] RankTable : enum clas로 맞춘 번호 개수, bonus 여부, 획득 상금 여부에 따른 변수 생성
- [x] ClientLottoData : 구매가격, 로또 티켓 개수, 로또 리스트, 순위표 리스트
    - ⚠️ 해당 변수를 private으로 변경 및 getter(), setter() 사용 여부 고민 -> private으로 변수 변경 및 getter() setter() 설정
- [x] WinningLottoNumber : 당첨 번호, 보너스 번호
    - ⚠️ 해당 변수를 private으로 변경 및 getter(), setter() 사용 여부 고민 - setter() 안좋다는 얘기를 들었는데 확인하기 -> 생성자로만 값 설정? 빌더 패턴?

3. util package

- [x] LottoMachine ~~LottoService~~
    - ~~setLottoTicketNumber()~~ : 로또 티켓 개수 발행
    - [x] ⚠️ ~~setLottoTicket()~~ : 로또 티켓 발행 - 여기서 new Lotto를 하는것이 맞을까?
    - [ ] ⚠️ matchLottoCalculate() : 당첨 번호와 가진 번호 비교 및 data 저장
        1. 내부 메서드를 줄일 수 잇지 않을까? countMatchNumber(), filterBonusNumber(), addMatchRank () 내부 메서드끼리 꼬리를 문다.
        2. 네이밍이 마땅한게 생각이 나지 않는다.
    - ~~setIncome()~~ ~~getRateOfReturn()~~ : 수익률 계산 - 소수점 2째자리서 반올림
- [x] LottoTypeConverter
    - toList() : , 연결된 String List<Integer>로 변환
    - toWon() : 숫자를 한국돈으로 format 변경
- [ ] LottoValidator
    - divideMoney() : 1000원 단위로 잘 나뉘는지 확인
    - checkWinningNumber() : 올바른 숫자 들어왔는지, 중복 숫자 없는지
    - checkBonusNumber() :  올바른 숫자 들어왔는지, 중복 숫자 없는지
-  [x] ClientLottoData
    - setLottoTicketNumber() : 로또 티켓 개수 발행
    - setLottoTicket() : 로또 티켓 발행 - 여기서 new Lotto를 하는것이 맞을까?
    - SetIncome() : 수익률 계산 - 소수점 2째자리서 반올림
-  [x] WinningLottoNumber

4.✅ controller

- [x] LottoController
    - [x] ⚠️ controller에서 iv를 최소한으로 줄이는 것이 좋지 않을까? 줄이는게 좋다.
    - [x] ⚠️ iv가 꼭 필요한 경우 생성자를 통해서 객체를 넣을 수 있지만, 해당 객체 내부에 값을 넣어야하는 경우는 어떻게 해결? run()
