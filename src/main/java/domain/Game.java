package domain;


import java.util.List;

public class Game {
    public static void start() {
        int purchaseAmount = InputHandler.getPurchaseAmount();
        List<Lotto> lottos = PurchaseLottoList.is(purchaseAmount);
        Lotto winningLottoWithoutBonusNumber = InputHandler.getWinningLotto();
        int bonusNumber = InputHandler.getBonusNumber(winningLottoWithoutBonusNumber);
        WinningLotto winningLotto
                = new WinningLotto(winningLottoWithoutBonusNumber, bonusNumber);
        LottoResult result = new LottoResult(winningLotto, lottos);
        result.show();
    }
}
