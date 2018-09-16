package com.codingkata.rps.web.rest;

import com.codingkata.rps.dto.GameRequestDto;
import com.codingkata.rps.dto.RockPaperScissorsDto;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;
import com.codingkata.rps.web.advice.ErrorResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Integration test that starts up the server to test with HTTP requests
 *
 * @author Tim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RpsControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private GameRequestDto request;

    @Before
    public void createRequest() {
        request = new GameRequestDto();
        request.setChoice(RpsOptions.ROCK);
    }

    @Test
    public void defaultShouldPlayStandardGame() {
        verifyVariant("/", RpsVariants.STANDARD);
    }

    @Test
    public void standardShouldReturnStandard() {
        verifyVariant("/standard", RpsVariants.STANDARD);
    }

    @Test
    public void wellShouldReturnWell() {
        verifyVariant("/well", RpsVariants.WELL);
    }

    @Test
    public void variantsShouldReturnListOfVariantInfo() {
        ResponseEntity<List> variantInfo =  restTemplate.getForEntity("http://localhost:" + port + "/variants", List.class);

        assertThat(variantInfo.getBody().size(), equalTo(RpsVariants.values().length));
    }

    @Test
    public void illegalOptionShouldReturnBadRequest() {
        request.setChoice(RpsOptions.WELL);

        ResponseEntity<ErrorResponse> response;
        response = restTemplate.postForEntity("http://localhost:" + port + "/standard",
                request, ErrorResponse.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void nonExistingOptionShouldReturnBadRequest() {
        request.setChoice(null);

        ResponseEntity<ErrorResponse> response;
        response = restTemplate.postForEntity("http://localhost:" + port + "/standard",
                request, ErrorResponse.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

    private void verifyVariant(String variantPath, RpsVariants variant) {
        ResponseEntity<RockPaperScissorsDto> response;
        response = restTemplate.postForEntity("http://localhost:" + port + variantPath,
                request, RockPaperScissorsDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getVariant(), equalTo(variant));
    }
}
