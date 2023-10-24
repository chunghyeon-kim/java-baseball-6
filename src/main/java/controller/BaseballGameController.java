package controller;

import util.ComputerNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.BaseballGameView;

public class BaseballGameController {
    private final BaseballGameView baseballGameView = new BaseballGameView();
    private int isContinue = 1;

    public void repeatBaseballGame() {
        baseballGameView.printGameStartingMessage();

        while (isContinue == 1) {
            doBaseballGame();

            baseballGameView.printGameClosingMessage();
            isContinue = baseballGameView.isContinue();
        }
    }

    private void doBaseballGame() {
        List<Integer> computer = ComputerNumberGenerator.generate();

        List<Integer> userNumbers = new ArrayList<>();

        while (!computer.equals(userNumbers)) {
            userNumbers = baseballGameView.getUserNumberList();

            int strikeCount = countStrike(computer, userNumbers);
            int includedNumberCount = countIncludedNumbers(computer, userNumbers);

            baseballGameView.printJudgementMessage(strikeCount, includedNumberCount);
        }
    }

    private int countStrike(List<Integer> computer, List<Integer> userNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userNumbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int countIncludedNumbers(List<Integer> computer, List<Integer> userNumbers) {
        int includedNumberCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.contains(userNumbers.get(i))) {
                includedNumberCount++;
            }
        }

        return includedNumberCount;
    }
}
