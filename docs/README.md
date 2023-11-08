## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

## 구현예정
### 클래스 내역
- Lotto (제공된 클래스)
- - list(number)를 변수로 받아온다.
- - validate 함수롤 통해 number의 유효성을 확인한다.

- BuyLotto
- - 로또를 구매하는 클래스
- - 로또 구매액 buyMoney 변수
- - 구매액이 1000원단위로 나누어 떨어지는지 유효성을 검사하는 함수 checkMoney
- - 유효성에 적합하다면 로또를 몇개 살 수 있는지 반환하는 변수 numMoney 반환

- LotteryMachine
- - 로또를 추첨하는 클래스
- - 사용자가 구매한 로또번호 <List> customerLotto
- - 1~45까지의 숫자를 랜덤으로 customerLotto에 6자리씩 넣는 함수 customerRandom

- BonusLotto
- - 보너스번호의 유효성을 확인하는 클래스
- - 유효성에 적합하다면 로또 보너스번호 bonusNum 변수를 출력

- WinningCalculation
- - 로또 당첨여부를 확인하는 클래스
- - Lotto클래스의 number와 Lottery_machine클래스의 customerLotto를 서로 비교하는 winningCheck함수
- - BonusLotto클래스의 bonusNum과 Lottery_machine 클래스의 customerLotto를 서로 비교하는 bonusCheck함수

- WinnigResult
- - 로또 당첨여부를 출력하는 클래스
- - 총 게임수를 받아오는 함수 resultLotto
- - 각 게임 별로 당첨 횟수를 저장하는 resultCount 지역변수
- - WinningCalculation클래스의 winningCheck함수와 bonusCheck함수의 값을 받아 게임 수 만큼 진행하여 resultCount변수 내에 저장하는 resultCheck 함수
- - resultCheck의 값과 BuyLotto 클래스의 buyMoney변수를 받아와 수익률을 계산하는 resultCalculation함수
- - resultCalculation의 값을  화면에 출력하는 resultPrint 함수


# 진행중 문제점
- Bonus의 경우 5개가 일치하며 그 5개 가운데 보너스번호가 있어야하므로 이또한 구현함에 어려움을 겪었다.
- 너무 많은 클래스를 이용하다보니 어떤것을 불러와야할지 감이 잡히지 않아 클래스를 줄였다.
- 분명 코드상으로는 문제가 없는 것같은데 테스트는 통과하지 못했다...대체뭐가 문제일까..
