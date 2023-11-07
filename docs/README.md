# 👀 로또 게임

로또 게임 기능.

로또는 1~45 사이의 숫자를 6개 맞추는 게임이다.

이 게임에서는 참여자가 로또를 구매할 금액을 입력하면 한 장당 1,000원의 가격으로 복권을 구매해
그 장 수만큼 랜덤으로 복권을 뽑는다.

그리고 6개의 번호와 보너스 번호를 입력한다.

이 7개의 번호를 랜덤으로 뽑힌 복권의 6개 번호와 비교해 결과를 도출해내는 것이 이 게임의 목표이다.

![결과화면.gif](https://blog.kakaocdn.net/dn/bEpYFB/btszMZZUiPP/vIXhEzbuedHv1sTmh9Te2K/img.gif)

## 📃기능 목록

- [x] 입력 받는 기능 구현
    - [x] 로또 구입 금액을 입력받는다.
        - [x] [예외처리] 1,000원 단위로 입력받아야 하며 1,000원으로 나누어 떨어지지 않으면 예외.
        - [x] [예외처리] 사용자가 숫자를 입력하지 않았다면 예외.
        - [x] [예외처리] 1,000원 미만인 경우 예외.
        - [x] 사용자가 입력에 ,를 입력했을 경우 ,를 제거하고 숫자로 변환시켜준다.
    - [x] 당첨 번호를 입력 받는다.
        - [x] [예외처리] 구분자가 쉼표(,)나 공백이 아니라면 예외 / 즉 쉼표, 공백, 숫자 이외의 문자는 X
        - [x] [예외처리] 1~45 사이의 숫자가 아니라면 예외
        - [x] [예외처리] 번호가 6개가 아니라면 예외
        - [x] [예외처리] 중복된 번호가 있으면 안된다.
    - [x] 보너스 번호를 입력 받는다.
        - [x] [예외처리] 숫자를 제외한 다른 문자를 입력했다면 예외
        - [x] [예외처리] 1~45 사이의 숫자가 아니라면 예외
        - [x] [예외처리] 당첨번호에 포함되는 숫자라면 예외
- [x] 구매한 수량만큼 로또를 생성하는 기능
    - [x] 구입 금액에 따라 알맞은 개수만큼 생성
    - [x] 1~45 사이의 중복되지 않은 랜덤한 숫자 6개를 가지고 있어야 한다.
    - [x] 구매한 로또의 숫자는 오름차순 정렬되어 있어야 한다.
- [x] 로또의 당첨 결과를 계산하는 기능
    - [x] 2개 이하로 일치하는 경우는 당첨이 아니다.
    - [x] 3개 이상은 당첨이다.
    - [x] 6개가 일치한 경우는 보너스볼의 일치 여부에 따라 당첨 금액이 달라진다.
    - [x] 수익률을 계산한다. (소수점 둘째 자리에서 반올림한다.)
- [x] 출력 기능 구현
    - [x] 구매 메시지 출력
    - [x] 구매한 로또 목록 출력
    - [x] 당첨 통계 메시지 출력
    - [x] 당첨 결과 출력
    - [x] 수익률 출력

## ❗주의 사항

- 예외 발생 시 에러 문구를 출력하고 해당 지점부터 입력을 다시 받아야 한다.
- 사용자가 잘못된 입력을 했을 때는 IllegalArgumentException을 발생시킨다.
- Exception이 아닌 IlleagalStateException과 같은 명확한 유형을 처리한다.

## 🎁패키지 구조

<table>
<tr>
<th>패키지</th>
<th>이름</th>
<th>설명</th>
</tr>
<tr>
<td width="110">🖥️Controller</td>
<td>LottoController</td>
<td>로또 게임의 전체적인 흐름을 제어하는 컨트롤러 클래스.</td>
</tr>
<tr>
<td colspan="3"></td>
</tr>
<tr>
<td colspan="3" align="center">🌐Domain</td>
</tr>
<tr>
<td rowspan="5">lotto</td>
<td>Lotto</td>
<td>로또 내 6개의 숫자를 검증하고, 정렬하는 클래스.</td>
</tr>
<tr>
<td>LottoTickets</td>
<td>구입 금액만큼 로또를 생성하고 그 로또를 담고있는 컬렉션 클래스.</td>
</tr>
<tr>
<td>PurchasePrice</td>
<td>구입 금액 포장 클래스. 구입 금액에 대해 검증한다. </td>
</tr>
<tr>
<td>WinningNumbers</td>
<td>당첨 번호 컬렉션 클래스. 당첨 번호에 대한 검증한다.  </td>
</tr>
<tr>
<td>BonusNumber</td>
<td>보너스 번호 포장 클래스. 보너스 번호에 대해 검증한다. </td>
</tr>
<tr>
<td rowspan="3">lottoresult</td>
<td>EarningRate</td>
<td>수익률 포장 클래스. 수익률을 계산한 결과를 도출한다. </td>
</tr>
<tr>
<td>LottoCheckResult</td>
<td>로또 당첨 결과를 컬렉션을 통해 관리하는 클래스. </td>
</tr>
<tr>
<td>LottoResultStatus</td>
<td>로또 당첨 결과를 담는 Enum 클래스. 맞춘 번호 개수에 따라 알맞은 로또 결과를 매칭한다. </td>
</tr>
<tr>
<td colspan="3"></td>
</tr>
<tr>
<td>📊Service</td>
<td>LottoChecker</td>
<td>수익률, 로또 결과에 필요한 값을 각 객체에 전달하여 결과를 도출하는 클래스.</td>
</tr>
<tr>
<td colspan="3"></td>
</tr>
<tr>
<td rowspan="2">🧰Utils</td>
<td>LottoValidator</td>
<td>범위 검증과 같은 로또 검증의 공통된 검증 로직을 담당하는 클래스.</td>
</tr>
<tr>
<td>LottoConstants</td>
<td>로또에 대해 정의된 상수를 관리하는 Enum 클래스. </td>
</tr>
<tr>
<td colspan="3"></td>
</tr>
<tr>
<td colspan="3" align="center">👀View</td>
</tr>
<tr>
<td rowspan="2">inputview</td>
<td>InputView</td>
<td>사용자 입력값을 받기 위한 출력과 입력의 공통처리를 담당하는 클래스.</td>
</tr>
<tr>
<td>InputValueType</td>
<td>사용자 입력값을 받기위한 메시지와 입력값 객체 생성 메서드들의 관리를 담당하는 Enum 클래스.</td>
</tr>
<tr>
<td rowspan="4">outputview</td>
<td>OutputView</td>
<td>전체적인 결과 출력을 담당하는 클래스. </td>
</tr>
<tr>
<td>EarningRateOutputView</td>
<td>포맷에 맞추어 수익률 결과 출력을 담당하는 클래스. </td>
</tr>
<tr>
<td>LottoTicketOuputView</td>
<td>포맷에 맞추어 구입된 로또의 목록 출력을 담당하는 클래스. </td>
</tr>
<tr>
<td>LottoResultFormatOutputView</td>
<td>포맷에 맞추어 로또 결과 출력을 담당하는 클래스. </td>
</tr>
</table>