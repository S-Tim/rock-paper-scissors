package com.codingkata.rps.web.rest;

import com.codingkata.rps.dto.GameRequestDto;
import com.codingkata.rps.dto.RockPaperScissorsDto;
import com.codingkata.rps.dto.RpsVariantInfo;
import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsVariants;
import com.codingkata.rps.service.RpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST-Controller to interact with the RpsService
 *
 * @author Tim Silhan
 */
@RestController
public class RpsController {
    private final RpsService rpsService;

    @Autowired
    public RpsController(RpsService rpsService) {
        this.rpsService = rpsService;
    }

    @PostMapping(value = {"/", "/standard"})
    public RockPaperScissorsDto standardGame(@RequestBody GameRequestDto gameRequest) {
        RockPaperScissors rps = rpsService.playGame(RpsVariants.STANDARD, gameRequest.getChoice());
        return rpsService.getDto(rps);
    }

    @PostMapping("/well")
    public RockPaperScissorsDto wellGame(@RequestBody GameRequestDto gameRequest) {
        RockPaperScissors rps = rpsService.playGame(RpsVariants.WELL, gameRequest.getChoice());
        return rpsService.getDto(rps);
    }

    @GetMapping("/variants")
    public List<RpsVariantInfo> getRuleSets() {
        return rpsService.getRuleSets();
    }
}
