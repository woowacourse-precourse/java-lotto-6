## 로또!
로또 프로그램에 대한 설계서입니다.

### 동작 과정
1. 사용자가 금액을 입력하면 해당 금액만큼 로또를 발행합니다.
- 발행한 로또 번호는 임의적으로 생성됩니다.
2. 사용자가 당첨된 로또의 번호를 입력합니다.
3. 프로그램은 1등부터 5등까지의 당첨된 로또의 수를 출력합니다.
4. 구입 금액 대비 수익률을 구하여 출력합니다.

### 구현 기능 목록

#### InputUtil 객체
사용자의 입력과 관련된 함수들을 포함하고 있는 객체입니다.
- inputLottoPrice 함수
    - 사용자가 구입할 로또의 가격울 입력받고 검증
      - 1000으로 나누어 떨어지는 양의 정수를 입력
- inputWinningLotto 함수
    - 사용자가 당첨된 로또의 번호를 입력받고 검증
      - 입력된 문자가 6개인지 확인
      - 입력된 문자가 1에서 45로 구성된 숫자인지 확인


#### RandomUtil 객체
랜점한 값을 생성하는 함수들을 포함하고 있는 객체입니다.
- createLottoNumber 함수
  - 1부터 45까지의 중복 없는 정렬된 랜덤한 6개의 숫자를 뽑아주는 함수입니다.


#### Lotto
로또 번호의 정보를 가지는 객체입니다.
- getNumbers 함수
  - numbers를 반환하는 함수


#### PlayerLotto 객체
금액 입력 후 사용자의 로또의 정보를 가지는 객체입니다.
- playerLotto 변수
    - List<Lotto>의 형태, 구입한 Lotto를 저장
- purchasesPrice 변수
    - int의 형태, 구입 가격
- lottoAmount 변수
    - int의 형태, 구입 수량


- createPlayerLotto 함수
    - 구매 수량만큼의 로또를 생성하는 함수
- getPlayerLotto 함수
    - playerLotto를 반환하는 함수
- getPurchasesPrice 함수
    - getPurchasesPrice를 반환하는 함수
- getLottoAmount 함수
    - getLottoAmount를 반환하는 함수


#### WinningLotto 객체
당첨 로또의 번호 정보룰 가지는 객체입니다.
- lotto 변수
  - Lotto의 형태, 당첨 로또를 저장
- bonusNumber 변수
  - int의 형태, 보너스 숫자를 저장


- validate 함수
  - 로또와 보너스 숫자의 중복 여부 확인
- matchLotto 함수
  - 플레이어 로또와 당첨 로또를 비교해 등수를 알려주는 함수


#### LottoResult 객체
로또의 등수를 저장하는 ENUM 객체입니다.
- count 변수
  - int의 형태, 맞춘 번호의 개수 저장
- bonus 변수
  - boolean의 형태, 보너스 번호 맞춘 여부 저장
- winningAmount 변수
  - int의 형태, 당첨 금액을 저장
- message 변수
  - String의 형태, 담청 메시지를 저장


- valueOf 함수
  - 맞춘 수와 보너스 여부로 등수 판별 후 알맞은 LottoResult 객체 반환
- getMessage 함수
  - 메시지를 반환하는 함수
- getWinningAmount 함수
  - winningAmount 반환하는 함수

### 구현 목록
- [ ] InputUtil 객체
- [x] RandomUtil 객체
- [x] PlayerLotto 객체