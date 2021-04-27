package be.tiemenv.projects.user;

import be.tiemenv.projects.github.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserProjects(String username) {
//        throw new IllegalStateException("state exception");

            GithubUser githubUser = userRepository.getUserFromGithub(username);
            return new User(githubUser.getLogin(), githubUser.getPublic_repos());

    }

}
