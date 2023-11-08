**기능 구현 목록**

1. LottoPlayer

   1-1. buyLottos(int) : 정해진 개수만큼 로또를 구입하여 player가 보관한다.

   1-2. printRateOfProfit(int) : 수익률을 출력한다. (상금 / 구입 금액)

   1-3. addMoney(int) : player의 소지금을 추가한다.

   1-4. getter : lottos, money

   

2. LottoAdmin

   2-1. checkLottos(Player) : player가 보유한 로또 확인 후 등수를 반환한다. (LottoRank) 

   2-2. payPrizeMoney(Player) : player가 보유한 lotto를 확인해 당첨금을 지급한다.

   2-3. printPrize : player가 보유한 lotto를 확인해 당첨 통계를 출력한다.

   2-4. getter : winningNumber

   2-5. setter : winningNumber, bonusNumber

   

3. LottoRank(enum)

   3-1. getter : value(당첨금), message(당첨 문구)

   

4. LottoApp

   4-1. playGame : 전체 게임을 진행한다.
