
## 게임 진행 흐름

이야기 : 손님이 로또를 구매하고 이후 당첨번호를 입력해서 자기가 얼마나 벌었는지 확인함

1. `누군가(Appplication)`가 `진행자`에게 `로또 게임`을 시작해달라고 요청한다.
1. `진행자`는 `로또 기계`에게 구매 금액을 보내 `로또들(Lottos)을 생성`해달라고 한다.
   2. 구매 금액 입력
   3. 로또 생성
3. `진행자`는 `구입한 로또`들을 `출력기` 에게 보내 출력해달라고 한다.
4. `진행자`는 `당첨 로또`를 생성한다.
   1. `당첨 번호`를 입력
   2. `보너스 번호`를 입력
5. `진행자`는 `Lottos`에게 `WinngLotto`를 보내 `WinningResult`를 만들어 달라고 한다.
6. `진행자`는 받은 `WinningResult`를  `출력기`에게 보내 출력 해달라고 한다.
7. `진행자`는 `WinngingResult`에게 `Money`를 보내 수익률을 계산해 달라고 하여 출력한다.


# Domain

## LottoMoney
1. Money 생성 기능(int money) -> return Money
2. 로또 몇개 구매 가능한지 개수 구하는 기능(int pricePerLotto) -> return int
3. calculateProfitPercentage(int totalWinningMoney) -> return float;

## LottoMachine
1. LottoMachine 생성기능(LottoGenerator) -> return LottoMachine
2. 로또 구매 기능(Money money) -> Lottos

## LottoGenerator(Interface)

실제 구현체 : AutoLottoGenerator

1. LottoGenerator 생성 기능(NumberGenerator) -> return LottoGenerator
2. 로또 생성 기능(money) -> return List<`Lotto`>
   1. money는 1000원 단위어야한다. (0원 안됨)

## NumbersGenerator(Interface)

실제 구현체 : RandomNumbersGenerator

1. NumbersGenerator 생성기능() -> return NumbersGenerator
2. Numbers 생성 기능() -> return List<`Integer`>

## WinningResult(class)

1. WinningResult 생성기능(EnumMap<WinningRank,Integer> result ) -> return WinngingResult
2. 출력 위한 당첨 결과들 구하는 기능 () -> return result
3. 수익률 계산 기능(LottoMoeny lottoMoney) -> return float;
   1. 전체 당첨금액이 얼마인지 구한다.
   2. lottoMoney에게 전체 당첨금액을 보내 몇퍼센트인지 구한다. re
## WinningRank(enum)

1. WinningResult 생성 기능(int matchCount, int money, boolean bonusNumber)
2. WinningResult 찾아주기(int matchCount, boolean bonusNumber)
   1. 5개라면 bonusNumber도 확인
   2. 아니라면 matchCount만 확인

## Lottos(class)
1. Lottos 생성 기능(List<Lotto>) -> return Lottos
2. WinningResult 구하는 기능(WinningLotto) -> return WinningResult
 
## Lotto(class)
1. 로또 생성 기능(List<숫자>)
   1. 숫자들은 1~45의 숫자여야한다.
   2. 숫자들은 중복되면 안된다.
2. 숫자가 몇개 같은지 확인 하는 기능(Lotto lotto) -> return count
3. 숫자를 가지고 있는지 확인하는 기능(int number) ->return boolean
4. 보너스 숫자를 가지고 있는지 확인하는 기능(BonusNumber bonusNumber) ->return boolean

## WinningLotto(class)

1. WinningLotto 생성 기능(Lotto, BonusNumber)
   1. 숫자는 Lotto에 있는 숫자에 포함되어 있으면 안된다.
2. 몇등에 당첨됬는지 알려주는 기능(Lotto lotto) -> return WinningRank

## BonusNumber
1. BonusNumber 생성 기능(Integer) -> return BonusNumber
2. 숫자가 같은지 확인하는 기능(int number) -> return boolean

# View

## 입력
1. 구매 금액 입력 기능
3. 당첨 번호 입력   -> return List<`Integer`>
   1. 1,2,3,4,5,6 형식이 아니면 예외 발생
   2. String to List<`Integer`> 기능
4. 당첨 보너스 번호 입력
   1. 숫자가 아니라면 예외

## 출력
1. 당첨 통계 출력 기능
2. 수익률 출력 기능
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.