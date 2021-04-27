package be.tiemenv.projects.user;

public class User {

    private String name;
    private Integer projectCount;

    public User(String name, Integer projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(Integer projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
