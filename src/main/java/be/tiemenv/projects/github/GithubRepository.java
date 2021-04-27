//package be.tiemenv.projects.github;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.HttpStatusCodeException;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.http.HttpHeaders;
//
//public class GithubRepository {
//
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    public GithubUser getGithubUser(String username) {
//
//
//            final String uri = "https://api.github.com/users/" + username;
//
////        RestTemplate restTemplate = new RestTemplate();
//
//            GithubUser githubUser = restTemplate.getForObject(uri, GithubUser.class);
//
//            return githubUser;
//
//    }
//}
