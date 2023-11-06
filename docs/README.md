
# 로또 게임
<pre>
이 게임은 크게 3가지 부분으로 이루어져있습니다.
</pre>
1. 구매 금액 입력
<pre>
1000원 단위로 금액을 입력받고 입력한 금액만큼 복권을 구매하여
출력을 하여 보여줍니다. 
</pre>
2. 당첨 숫자 입력
<pre>
복권의 당첨 숫자를 6자리 입력하고 그 다음 보너스 숫자 1개를 입력합니다.
여기서 총 7개의 숫자는 중복이 되면 안되고 1~45사이의 숫자여야 합니다.
</pre>
3. 수익률 확인
<pre>
구매한 복권에서 당첨된 복권을 찾고 각 등수가 몇장 담첨이 되었는지 확인합니다.
최종적으로 복권을 구매한 금액대비 수익률이 몇퍼센트인지 출력해줍니다.
</pre>
## 주의사항
<pre>
해당 게임을 진행할 때 요구사항에서 벗어난 입력을 받을 경우 프로그램을 종료하는 것이 아닌
에러 메세지를 출력후 해당 지점부터 다시 입력을 받습니다.
프로젝트를 구성할 때에는 도메인 로직에 단위테스트를 구현하는 부분도 신경을 써야합니다.
</pre>
# 클래스 구성
# Input
    사용자 입력을 받는 클래스
- lottoBuyMoney
- answerNumber
- bonusNumber
# Output
    출력을 하는 클래스
- *buyMoneyAsk 
- *buyNumberPaperAns
- *answerNumberAsk
- *bonusNumberAsk
- *correctStatisPrint
- lottoBuyPaperPrint
- correctPaperTotalPrint
- correctPaperPrint
- revenueRatePrint
- outOfRangeMoney
- incorrectFormatMoney
- outOfRangeNumber
- incorrectFormatNumber
# Money
    돈에 관련된 걸 관리하는 클래스
- buyLotto
- correctNumber
- revenueRate
# Lotto
    구매한 번호, 당첨번호 관리하는 클래스
- Lotto
- validate
- checkAllSameNumber
- pickNumber
- checkSameNumber
# Calculate
    당첨 통계를 계산해주는 클래스
- calculateRevenueRate
- calculateRank
- correctMoney
# Game
    로또 진행을 관리해주는 클래스
- askMoney
- askNumber
- askBonus
- printCorrect
# Exception
    예외 처리를 해주는 클래스
- *outOfRangeMoney
- sameNumberCheck
- incorrectFormatNumber
- *incorrectFormatMoney

# Message
- Message
- getCode
- getMessage