package be.tiemenv.projects.user;

import be.tiemenv.projects.exception.ApiRequestException;
import be.tiemenv.projects.github.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepository {

    @Autowired
    public UserRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    public GithubUser getUserFromGithub(String username) {
        final String uri = "https://api.github.com/users/" + username;

        try {
            ResponseEntity<GithubUser> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, GithubUser.class);
            System.out.println(responseEntity.getStatusCode());
            GithubUser githubUser = restTemplate.getForObject(uri, GithubUser.class);
            return githubUser;
        } catch (HttpClientErrorException e) {
            System.out.println(e.getLocalizedMessage());
            throw new ApiRequestException(e.getLocalizedMessage());
        }
    }
}
