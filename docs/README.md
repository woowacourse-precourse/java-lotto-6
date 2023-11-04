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
- **진입점으로 LottoBuySystem 과 LottoWinningSystem 을 관리하는 클래스**
- 변수
  - `LottoBuySystem lottoBuySystem` - 로또 티켓 구매 위한 객체 
  - `LottoWinningSystem lottoWinningSystem` - 로또 번호 비교 및 당첨 확인 위한 객체
- 메서드
  - `void run()`
    - Application 에서 호출하는 함수
    - 로또 번호를 뽑고 추첨을 하는 모든 과정을 호출하는 최상단의 함수  
  - `void buy()`
    - 로또 티켓 구매 및 관련 로직 (유효성 체크, 구매, 번호 셋팅) 을 처리하는 함수 
  - `void setDrawNumbers()`
    - 로또 당첨번호 입력 및 관련 로직 (유효성 체크, 비교, 당첨 및 수익률 확인) 을 처리하는 함수
  - `void draw()`
    - 로또 당첨 번호 비교 하는 함수 
  - `void enterLottoBuyPrice()`
    - 로또 티켓 구매 위한 금액 _입력받음 (유효성 체크)_
  - `void enterLottoDrawNumbers()`
    - 로또 당첨 번호 (6개+1개) _입력받음 (유효성 체크)_

### (Model) LottoBuySystem
- **로또 티켓을 구매하는 클래스**
- 변수
  - `Lotto[] lottos` -  구매한 로또 티켓 배열
- 생성자
  - `LottoBuySystem(String price)`
    - 구매한 금액(문자)을 인자로 받음
- 메서드
  - `void validatePrice(String price)`
    - 사용자가 입력한 구매 금액이 적절한지 확인
  - `Lotto[] buyLottos(int price)`
    - 구매한 금액을 보고 로또 티켓 배열을 생성해줌 (ex. 6,000원 이면 길이가 6인 배열)
  - `int[] generateLottoNumbersRandom()`
    - 1~45 까지, 겹치지 않는 숫자로 랜덤하게 로또 번호를 생성함  
      - abstract, extends 를 사용해서 랜덤 뽑기 외에도 홀수, 짝수 등 뽑기 방법을 추가해보는건?? 
      - todo : generateLottoOdd()
        - 홀수만 생성함
      - todo : generateLottoEven()
        - 짝수만 생성함

### (Model) LottoWinningSystem
- **로또 번호를 맞춰보는 클래스**
- 변수
  - `List<Integer> winningNumbers` - 정답인 로또 번호 배열
  - `Integer bonusNumber` - 보너스 정답 번호 
  - `Lotto[] boughtLottos` - 구매했던 로또 티켓들
- 생성자
  - `LottoWinningSystem(List<Integer> winningNumbers, int bonusNumber)`
    - 정답 로또 번호와 보너스 번호를 인자로 받음
- 메서드
  - `void setBoughtLottos(Lottos[] boughtLottos)`
    - 구매한 로또 티켓들을 set 함  
  - `Prize[] getPrizes(Lottos[] boughtLottos)`
    - 선택된 로또 번호와 정답, 보너스 번호를 비교하여 등수 및 상금을 반환함
  - `Prize getPrize(Lottos lottos)`
    - 선택된 로또 번호와 정답, 보너스 번호를 비교하여 등수 및 상금을 반환함 
  - `float getEarningsRate(int buyPrice, earningPrice)`
    - 수익률을 반환함
    - 수익률은 (당첨금액/티켓구매금액)*100 이며 소숫점 둘째자리 에서 반올림함 

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

### (Enum) Prize
- 등수 별 금액
- 값
  - FIRST(2_000_000_000)
  - SECOND(30_000_000)
  - THIRD(1_500_000)
  - FOURTH(50_000)
  - FIFTH(5_000)
### Utils
  - validation
    - 숫자 체크 (입력 금액에 대한)
    - 숫자 체크 (당첨 숫자에 대한)


