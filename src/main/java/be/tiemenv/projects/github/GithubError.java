//package be.tiemenv.projects.github;
//
//import org.springframework.http.HttpStatus;
//
//import java.time.LocalDateTime;
//
//public class GithubError {
//    private HttpStatus status;
//    private String message;
//    private LocalDateTime timestamp;
//
//    private GithubError() {
//        this.timestamp = LocalDateTime.now();
//    }
//
//    GithubError(HttpStatus status){
//        this();
//        this.status = status;
//    }
//
//    GithubError(HttpStatus status, String message){
//        this();
//        this.status = status;
//        this.message = message;
//    }
//}
