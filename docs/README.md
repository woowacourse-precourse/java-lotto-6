# 구현 객체(MVC)
## 컨트롤러
### LottoController 클래스
- run() : 로또 당첨의 일련의 과정을 수행하는 함수
- matchRanking() : checkLottoService 클래스를 이용하여 로또리스트를 각각 하나씩 접근할 수 있도록 도와주는 함수
- calculateProfit() : ScoreType의 열거형에 저장되어있는 money와 count값을 이용해 수익률을 구하는 함수

### CheckLottoService 클래스
- 내가 가진 로또 리스트를 각각 당첨로또와 비교해서 몇등인지 알려주는 클래스
- rankLotto() : 필드를 비교해서 랭킹 알려주는 함수
- checkLotto() : 필드의 값을 재정의하는 함수

## 모델
### DHLottery 클래스
- 로또 당첨번호를 관리하는 클래스
- winningNumber : 당첨 번호
- bonusNumber : 보너스 번호
- 각 필드의 setter를 이용해 예외처리를 진행함
- 상황에 맞는 Validation 함수를 이용해 예외처리에 가독성을 더해줌
- 

### Lotto 클래스
- numbers : List<Integer>
- score : ScoreType
- 번호가 6개가 아니거나 중복값이 존재하는 경우의 validation을 구현해줌

### Member 클래스
- amount : 금액 -> 로또 장 수로 저장
- lottos : 각각의 로또를 저장하는 리스트
- profit : 이익률
- setAmount()를 통해 입력값에 대한 예외처리를 진행

### ScoreType 열거형
- FIRST,SECOND,THIRD,FOURTH,FIFTH,NOTHING로 존재
- ranking : Integer
- money : Integer
- count : Integer
- setCount() : 랭킹에 해당하는 값 +1해주는 함수


## 뷰
### Input 클래스
- Input 클래스에서는 숫자 이외의 입력에 대한 예외처리를 일괄 진행
- 나머지 예외 조건에 대해서는 각 필드에 대한 부분에서 진행
- inputAmount()
- inputWinningNumber()
- inputBonusNumber()

### Print 클래스
- howManyBuyLottos(Member) : void
- lottoResult(Member) : void

# 동작원리
- 구입금액 입력받음(1000원 단위로)
    - 1000원 단위 아닐 시 - "[ERROR] 1000원 단위가 아닙니다. 다시 입력하세요"
    - 숫자 입력이 아닐 시 - "[ERROR] 숫자입력이 아닙니다. 다시 입력하세요"
- 구입 금액 당 랜덤 로또 구매 장 수 출력
- 당첨 번호 입력 받음
  - 당첨 번호에 ,를 제외한 다른 문자 값 입력 시 - "[ERROR] 당첨 번호에 숫자 이외의 값이 포함 되어 있습니다. 다시 입력하세요"
  - 입력값이 6개의 숫자로 이루어지지않았을 시 - "[ERROR] 당첨 번호가 6개가 아닙니다. 다시 입력하세요"
  - 당첨 번호에 중복 숫자 값이 있을 시 - "[ERROR] 중복된 값이 존재합니다. 다시 입력하세요"
  - 당첨 번호의 범위가 1~45 이외 의 값일 시 - "[ERROR] 범위 이외의 값이 존재합니다. 다시 입력하세요"
- 보너스 번호 입력 받음
    - 보너스 번호가 숫자 이외의 값일 시 - "[ERROR] 숫자입력이 아닙니다. 다시 입력하세요"
    - 보너스 번호가 중복 숫자 값이 있을 시 - "[ERROR] 중복된 값이 존재합니다. 다시 입력하세요"
    - 보너스 번호의 범위가 1~45 이외 의 값일 시 - "[ERROR] 범위 이외의 값이 존재합니다. 다시 입력하세요"
- 해당 상황에 맞는 출력을 진행
- 수익률을 출력 후 종료


# 예외처리
"[ERROR] ~~~~~" 입력 후 해당 위치에서 재시작
- 입력값 1000단위 아닐 시
- 입력값 숫자 아닐 시
- winningNumber 6개의 숫자 아닐 시
- winningNumber 중복 숫자 있을 시
- winningNumber 숫자 범위 1~45 이외일 시
- bounsNumber 숫자 아닐 시
- bonusNumber 숫자가 winningNumber와 중복 값 있을 시
- bonusNumber 숫자 범위 1~45 이외일 시