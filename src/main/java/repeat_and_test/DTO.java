package repeat_and_test;

public class DTO {
    public String name;
    public int age;

    public DTO (String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
