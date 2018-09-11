package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;

/**
 * @author Tim Silhan
 */
public class GameRequestDto {
    private RpsOptions choice;

    public GameRequestDto() {

    }

    public RpsOptions getChoice() {
        return choice;
    }

    public void setChoice(RpsOptions choice) {
        this.choice = choice;
    }
}
