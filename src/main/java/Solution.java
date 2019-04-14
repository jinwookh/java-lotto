import domain.*;

public class Solution {

    public static void main(String[] args) {

        Lotto lotto = InputHandler.getWinningLotto();
        BonusNumber bonusNumber = new BonusNumber(" 3 ", lotto);

    }
}
