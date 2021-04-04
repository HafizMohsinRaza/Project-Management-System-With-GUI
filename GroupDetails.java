package ProjectManagementSystem;

public abstract class User extends TeamMember {

    public User(String name, String password, Task[] tasks) {
        this.name = name;
        this.password = password;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    private String name;

    private String password;

    private Task[] tasks;

    
    //Make consturctors here
    public void Display_userInfo() {
    }
}
