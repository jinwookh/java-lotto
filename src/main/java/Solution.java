import domain.*;

public class Solution {

    public static void main(String[] args) {

        Lotto lotto = InputHandler.getWinningLotto();
        System.out.println(InputHandler.getBonusNumber(lotto));

    }
}
