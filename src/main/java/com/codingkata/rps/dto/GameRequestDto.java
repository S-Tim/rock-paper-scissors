package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;

/**
 * @author Tim Silhan
 */
public class GameRequestDto {
    private RpsOptions playerChoice;

    public GameRequestDto() {

    }

    public RpsOptions getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(RpsOptions playerChoice) {
        this.playerChoice = playerChoice;
    }
}
