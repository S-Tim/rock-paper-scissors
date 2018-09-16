package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Represents the rules of a RPS Game in a DTO fashion.
 *
 * @author Tim Silhan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RpsVariantInfo {
    private RpsVariants variant;
    private Map<RpsOptions, List<RpsOptions>> ruleSet;
}
