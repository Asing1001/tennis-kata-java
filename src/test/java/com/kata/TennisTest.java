package com.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisTest {

    private final Tennis tennis = new Tennis("Miki", "Sing");

    @Test
    void love_all() {
        scoreShouldBe("love all");
    }

    @Test
    void fifteen_love() {
        tennis.firstPlayerScore();
        scoreShouldBe("fifteen love");
    }

    @Test
    void thirty_love() {
        givenFirstPlayerScore(2);
        scoreShouldBe("thirty love");
    }

    @Test
    void forty_love() {
        givenFirstPlayerScore(3);
        scoreShouldBe("forty love");
    }

    @Test
    void love_fifteen() {
        givenSecondPlayerScore(1);
        scoreShouldBe("love fifteen");
    }

    @Test
    void love_thirty() {
        givenSecondPlayerScore(2);
        scoreShouldBe("love thirty");
    }

    @Test
    void fifteen_all() {
        givenFirstPlayerScore(1);
        givenSecondPlayerScore(1);
        scoreShouldBe("fifteen all");
    }

    @Test
    void thirty_all() {
        givenFirstPlayerScore(2);
        givenSecondPlayerScore(2);
        scoreShouldBe("thirty all");
    }

    @Test
    void deuce() {
        givenDeuce();
        scoreShouldBe("deuce");
    }

    @Test
    void first_player_adv() {
        givenDeuce();
        givenFirstPlayerScore(1);
        scoreShouldBe("Miki Adv");
    }

    @Test
    void second_player_adv() {
        givenDeuce();
        givenSecondPlayerScore(1);
        scoreShouldBe("Sing Adv");
    }

    @Test
    void second_player_win() {
        givenDeuce();
        givenSecondPlayerScore(2);
        scoreShouldBe("Sing Win");
    }


    private void givenDeuce() {
        givenFirstPlayerScore(3);
        givenSecondPlayerScore(3);
    }


    private void givenSecondPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennis.secondPlayerScore();
        }
    }


    private void givenFirstPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennis.firstPlayerScore();
        }
    }


    private void scoreShouldBe(String expected) {
        assertThat(tennis.score()).isEqualTo(expected);
    }
}
