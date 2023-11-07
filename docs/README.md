## 기능 목록
- [] 로또 구입 금액 입력
  - [] Exception: 1000원 단위가 아닐 시
- [] 당점 번호 입력
  - [] Exception: 쉼표로 구분되지 않는 경우
  - [] Exception: 6개의 숫자를 입력받지 않는 경우
  - [] Exception: 중복 되는 숫자가 있는 경우
  - [] Exception: 숫자의 범위가 1 ~ 45가 아닌 경우
- [] 보너스 번호 입력
  - [] Exception: 숫자의 범위가 1 ~ 45가 아닌 경우
  - [] Exception: 당첨 번호와 중복 되는 경우
- [] 로또 번호 일치 확인
- [] 수익률 계산


## 어떻게 구현할 것인가
<요구사항>
- [] 클래스 분리
- [] 도메인 로직에 대한 단위 테스트 작성
- [] 함수의 길이가 15라인을 넘지 않도록
  - 한 함수가 한 가지 기능만 담당하도록
- [] else 사용 X
- [] Java Enum 적용


- (class) Lotto
  - validate(): 예외 처리
  - getRandomLotto(): 로또 번호 랜덤 설정
-  (class) InputData
  - inputMoney(): 금액 입력
  - inputWinNum(): 당첨 번호 입력
  - inputBonus(): 보너스 번호 입력
  - validate(): 예외 처리
- (class) Check
  - checkLottoNum(): 로또 번호 몇 개 맞추었는 지 확인
  - checkRank(): 등수 확인
- (class) Calculate
  - calculateReturnRate(): 수익률 계산