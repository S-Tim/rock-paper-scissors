package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsOutcomes;
import com.codingkata.rps.game.RpsVariants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data-Transfer-Object for RPS games.
 * <p>
 * Encapsulates the state and variant of the game that was played.
 *
 * @author Tim Silhan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RockPaperScissorsDto {
    private RpsVariants variant;
    private RpsOptions playerChoice;
    private RpsOptions aiChoice;
    private RpsOutcomes outcome;
}
