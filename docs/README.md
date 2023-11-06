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


### 구현 목록
- [ ] InputUtil 객체
- [x] RandomUtil 객체