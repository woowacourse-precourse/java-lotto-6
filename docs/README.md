## 🚀 기능 요구 사항

- [x] 로또 게임 기능을 시작한다.
    - LottoGame.start()
    - LottoGame.isGaming : 게임 중임을 나타내는 boolean 변수
- [x] 로또 구입 금액을 입력한다. 잘못 입력할시 다시 입력하도록 한다.
    - LottoGame.money: 구입한 총 금액
    - LottoGame.inputMoney() : 로또를 위해 돈 넣기
- [x] 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    - LottoGame.validateThousandWonUnits() : 입력값이 천원 단위인지 검증
- [x] 사용자에게서 로또 번호를 입력받는다. 입력된 문자를 쉼표(,)로 나누어 리스트로 만든다.
    - LottoGame.inputNumbers() : 사용자에게 숫자 6개를 입력받는다.
    - LottoGame.inputBonusNumber() : 사용자에게 보너스 번호를 입력받는다.
        - Lotto.setBounusNumber() : 보너스 번호를 로또 객체에 set
    - LottoGame.splitByComma() : 입력 받은 숫자들을 쉼표로 구현
- [x] 로또 번호의 숫자 범위는 1~45까지이다, 중복되지 않는 7개의 숫자(보너스 번호 포함)를 뽑는다.
    - LottoGame.winningNumbers : 당첨 번호
    - LottoGame.pickWinningNumbers() :  당첨번호 + 보너스 번호까지 뽑기
        - pickUniqueNumbersInRange(1, 45, 7)
- [x] 금액만큼 로또 티켓을 발행한다. 로또 1장의 가격은 1,000원이다.
    - LottoGame.lottoTickets<Lotto> : 구입된 로또 티켓 리스트(로또 객체)
    - LottoGame.generateLottoTickets() : 입력된 금액에 따라 로또 티켓 발행하기
- [x] 입력된 번호들의 숫자가 6개를 넘어선 안된다. 잘못 입력될시 다시 입력한다.
    - Lotto.validate() : 기존에 구현된 메소드 사용하기
    - LottoGame.inputNumbers() : 다시 입력하기 while, try-catch로 구현하기
- [ ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    ```
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
    ```
    - LottoGame.getLottoRank() : 당첨번호를 받아 등수를 판별
    - LottoGame.getMoneyForRank() : 등수를 입력받아 당첨금액을 반환
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
    - LottoGame.printResult()
    - LottoGame.getRateOfReturn()
    - LottoGame.getWinningHistory()
    - LottoGame.end()
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    ```
    Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
    ```
    - Lotto.validate() : LottoGame이 아닌 Lotto 객체가 입력받을때 직접 검증하고 출력
- [ ] Enum을 사용하여 문자열, 숫자등의 값은 상수로 관리
    - Constant Enum 생성

---

## 📝 과제 진행중 개인 기록

- 코드말고 기능 요구사항과 클래스, 메소드 정리 하는데 최대한 시간 많이 쓰기
- 보너스 번호를 사용자가 정하는것이 아닌 게임에서 만드는 것으로 착각했음. 중간에 수정
- 커밋 메시지는 줄바꿈까지 해서 구체적인 내용을 전부 써야 하는건가?
- 매개변수와 반환 값을 최대한 이용해야 하는 이유를 조금씩 알기 시작했다. 재사용성, 순수성, 테스트, 가독성 면에서도 낫다.
- 기능 구현을 하다보면 기능 목록을 넘어 자연스럽게 다른 메소드를 수정할 일이 생긴다 > 메소드를 잘못 나눈건가?