## 의존관계 도식 
- (그림 업로드)

## 구현할 기능 목록
- 금액 입력
  - [ ] 사용자에게 입력 받음
  - [ ] validation 체크 (숫자인지, 1000으로 나눠지는지)
  - [ ] 금액에 따른 로또 티켓 구매 
- 금액에 따른 로또번호 랜덤 생성
  - [ ] 로또 번호 랜덤 생성
- 당첨번호 및 보너스 번호 입력
  - [ ] 당첨번호 및 보너스 번호 입력 받음
  - [ ] validation 체크 (1~45 의 안겹치는 숫자인지)
- 결과 출력 (당첨 내역, 수익률)
  - [ ] 구입한 로또 티켓들과 당첨번호 비교
  - [ ] 비교에 따른 등수 출력
  - [ ] 수익률 출력 
- Utils
  - validation
    - [ ] 숫자 체크 (입력 금액에 대한)
    - [ ] 숫자 체크 (당첨 숫자에 대한)
- 에러 체크
  - 각 상황에 대한 메시지 작성해야 함
  - 에러가 발생해도 종료하지 않고 다시 입력을 받아야 함 
    > 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, 
    > 
    > "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. 
    > 
    > Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- 테스트 케이스
  - 금액 입력이 제대로 되었는지
    - [ ] 숫자인지
    - [ ] 양수인지
    - [ ] 1,000원 단위로 나누어떨어지는지
  - 당첨번호 입력이 잘 되었는지
    - [ ] 숫자인지
    - [ ] 양수인지
    - [ ] 1~45인지
    - [ ] 안겹치는 숫자인지

## 기능에 따른 클래스와 함수들
### (Controller) LottoController
- **진입점으로 LottoBuySystem 과 LottoWinningSystem, LottoView 를 관리하는 클래스**
- 변수
  - `LottoBuySystem lottoBuySystem` - 로또 티켓 구매 위한 객체
  - `LottoWinningSystem lottoWinningSystem` - 로또 번호 비교 및 당첨 확인 위한 객체
  - `LottoView view` - 화면 출력 위한 객체
- 메서드
  - public
    - `void run()`
      - Application 에서 호출하는 함수
      - 로또 번호를 뽑고 추첨을 하는 모든 과정을 호출하는 최상단의 함수
    - `void buyLottos()`
      - 로또 티켓 구매 및 관련 로직 (유효성 체크, 구매, 번호 셋팅) 을 처리하는 함수
    - `void setWinningNumbers()`
      - 로또 당첨번호 입력 및 관련 로직 (유효성 체크, 비교, 당첨 및 수익률 확인) 을 처리하는 함수
    - `void compareLottos()`
      - 로또 당첨 번호 비교 하는 함수
  - private
    - `void enterPrice()`
      - 로또 티켓 구매 위한 금액 _입력받음 (유효성 체크)_
    - `void enterLottoDrawNumbers()`
      - 로또 당첨 번호 (6개+1개) _입력받음 (유효성 체크)_

### (Model) LottoBuySystem
- **로또 티켓을 구매하는 클래스**
- 변수
  - `Lotto[] lottos` -  구매한 로또 티켓 배열
- 메서드 (모두 public)
  - `void validatePrice(String price)`
    - 사용자가 입력한 구매 금액이 적절한지 확인
  - `void buyLottos(String givenPrice)`
    - 구매한 금액을 보고 로또 티켓 배열을 만들어서 lottos 에 저장함 (ex. 6,000원 이면 길이가 6인 배열)
  - `int[] generateLottoNumbersRandom()`
    - 1~45 까지, 겹치지 않는 숫자로 랜덤하게 로또 번호를 생성함
  - `int getLottosCount()`
    - 로또 티켓 갯수를 반환하는 함수

### (Model) LottoDrawSystem
- **로또 번호를 맞춰보는 클래스, WinningNumber 와 Prize 클래스를 관리함**
- 변수
  - `WinningNumber winningNumber` - 정답 번호 (기본 번호, 보너스 번호)
  - `Prize prize` - 우승 로직
- 메서드 (모두 public)
  - `void validateNumbers(String givenNumbers)`
    - 사용자가 입력한 정답 번호가 적절하지 확인
  - `void setNumbers(String givenNumbers)`
    - 사용자가 입력한 정답 번호를 winningNumber 에 저장함
    - 저장 로직은 WinningNumber 에서 담당
  - `int draw(int[] numbers)`
    - 로또 확인하고, 등수를 반환함
  - `int getSameNumbersCount(int[] numbers)`
    - numbers 와 정답을 비교하여, 같은 번호가 몇개인지 확인함
  - `boolean isBonusSame(int number)`
    - 보너스 번호가 같은지 확인함
  - `int getMoney(int grade)`
    - grade 에 따라 상금을 반환함
    - 상금 로직은 Prize 에서 담당
  - `String getMessage(int grade)`
    - grade 에 따라 메시지를 반환함
    - 메시지 로직은 Prize 에서 담당

### (Model) Lotto
- **로또 티켓 한 장에 대한 클래스**
- 변수
  - `List<Integer> numbers` - 로또 번호 배열
- 생성자
  - `Lotto(List<Integer> numbers)`
    - 선택한 로또 번호 배열을 인자로 받음
- 메서드
  - `void validate(List<Integer> numbers)`
    - 로또 번호가 제대로 생성되었는지 (1~45, 안겹치는 6개의 숫자) 확인함
  - `List<Integer> getLottoNumbers()`
    - 로또 번호 배열을 반환함

### (Model) Prize
- **등급과 관련한 로직을 관리하는 클래스**
- 변수
  - Prize 클래스 내에서 사용하기 위한 등수, 상금, 같아야하는 숫자 갯수 등이고 너무 많아서 따로 적지 않음
- 메서드
  - `void setGradeBoard()`
    - 맞춘 갯수 (일반, 보너스) 에따른 등급을 저장하고 있음
    - 2차원 배열로  `[일반][보너스] = 등급` 를 의미함
  - `void setMoneyBoard()`
    - 등급에 따른 상금을 저장하고 있음
    - 1차원 배열로 `[등급] = 상금` 을 의미함
  - `void setMatchCountBoard()`
    - 등급에 따라 (일반번호) 맞춰야하는 갯수를 저장하고 있음
    - 1차원 배열로 `[등급] = 맞춰야하는 갯수` 를 의미함
  - `void setMessageBoard()`
    - 등급에 따라 출력될 메시지를 저장하고 있음
    - 1차원 배열로 `[등급] = 메시지` 를 의미함
  - `int getBonusSameCount(boolean bonusSame)`
    - 보너스번호가 겹치면 1을, 아니면 0을 반환함
  - `int getGrade(int sameNumbersCount, boolean bonusSame)`
    - 겹친 일반번호 갯수와 보너스 번호 갯수를 인자로 넘겨, 등급을 반환함
  - `int getMoney(int grade)`
    - 등급을 넣으면 상금을 반환함
  - `String getMessage(int grade)`
    - 등급을 넣으면 메시지를 반환함

### (Model) WinningNumber
- 정답 숫자를 관리하는 클래스
- 생성자
  - 숫자 문자열(1, 2, ...) 을 넣으면 일반번호와 보너스 번호를 나누어서 저장함
- 변수
  - `int[] numbers` - 일반 번호
  - `int bonus` - 보너스 번호
- 함수
  - `boolean[] getNumbersExist()`
    - 번호 비교를 위한 일차원배열 (exist[45]) 을 만드는 함수
  - `int getBonus()`
    - 보너스 번호를 반환하는 함수

### (View) LottoView
- **로또 구매 및 뽑기 진행에 도움을 주는 문구를 출력하는 클래스**
- 함수들은 System.out.println 만을 함
- 구입 금액 및 구매한 로또 개수 안내
  - `구입금액을 입력해 주세요.\n`
  - `n개를 구매했습니다.\n`
- 당첨 번호 입력 안내
  - `당첨 번호를 입력해 주세요.\n`
  - `보너스 번호를 입력해 주세요.\n`
- 당첨 안내
  - `당첨 통계\n`
  - `---\n`
  - `3개 일치 (5,000원) - n개\n`
  - `4개 일치 (50,000원) - n개\n`
  - `5개 일치 (1,500,000원) - n개\n`
  - `5개 일치, 보너스 볼 일치 (30,000,000원) - n개\n`
  - `6개 일치 (2,000,000,000원) - n개\n`
- 수익률 안내
  - `총 수익률은 x.y%입니다.\n`

### (Utils) Utils
- `String getFormattedMoney(int money)`
  - 돈을 받으면 , 를 찍어줌
  - 예를들어 1000 은 1,000 으로 바꿔줌

### (Utils) Validations
- 각종 validation 체크를 위한 클래스

### (Utils) Constants
- 각종 상수가 있는 클래스

### (Enum) LottoMessgaes
- 에러 메시지를 관리하는 enum

