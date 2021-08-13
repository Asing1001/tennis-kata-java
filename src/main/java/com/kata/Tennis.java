package com.kata;

import java.util.HashMap;

public class Tennis {
    private final String firstPlayerName;
    private final String secondPlayerName;
    private int firstPlayerScoreTimes;
    private final HashMap<Integer, String> scoreLookup = new HashMap<Integer, String>() {{
        put(0, "love");
        put(1, "fifteen");
        put(2, "thirty");
        put(3, "forty");
    }};
    private int secondPlayerScoreTimes;

    public Tennis(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }


    public String score() {
        if (isScoreDifference()) {
            if (isReadyForGamePoint()) {
                if (isAdv()) {
                    return getAdvPlayer() + " Adv";
                }
                return getAdvPlayer() + " Win";
            }
            return lookupScore();
        }
        if (firstPlayerScoreTimes == 3) {
            return "deuce";
        }
        return sameScore();
    }

    private String sameScore() {
        return scoreLookup.get(firstPlayerScoreTimes) + " all";
    }

    private String lookupScore() {
        return scoreLookup.get(firstPlayerScoreTimes) + " " +
                scoreLookup.get(secondPlayerScoreTimes);
    }

    private boolean isAdv() {
        return Math.abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1;
    }

    private boolean isReadyForGamePoint() {
        return firstPlayerScoreTimes > 3 || secondPlayerScoreTimes > 3;
    }

    private boolean isScoreDifference() {
        return secondPlayerScoreTimes != firstPlayerScoreTimes;
    }

    private String getAdvPlayer() {
        return firstPlayerScoreTimes > secondPlayerScoreTimes ? firstPlayerName : secondPlayerName;
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }

    public void secondPlayerScore() {
        secondPlayerScoreTimes++;
    }
}
