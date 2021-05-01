package be.tiemenv.projects.user;

import be.tiemenv.projects.exception.ApiRequestException;
import be.tiemenv.projects.github.GithubUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepository {

    @Autowired
    public UserRepository(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;
    private static final String BASE_GITHUB_URI = "https://api.github.com/";
    private static final String BASE_GITHUB_USERS_ENDPOINT = "users/";

    public GithubUser getUserFromGithub(String username) {
        final String uri = BASE_GITHUB_URI + BASE_GITHUB_USERS_ENDPOINT + username;
        try {
            return restTemplate.getForObject(uri, GithubUser.class);
        } catch (HttpClientErrorException e) {
            throw new ApiRequestException(e.getLocalizedMessage());
        }
    }
}
