package be.tiemenv.projects.user;

import be.tiemenv.projects.github.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserProjects(String username) {

            GithubUser githubUser = userRepository.getUserFromGithub(username);
            return new User(githubUser.getLogin(), githubUser.getPublicRepos());

    }

}
