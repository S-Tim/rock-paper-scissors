package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;
import lombok.Data;

/**
 * @author Tim Silhan
 */
@Data
public class GameRequestDto {
    private RpsOptions choice;
}
